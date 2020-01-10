import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {
    private int x;
    private int y;
    private Hero hero;
    private ArrayList<Goblin> goblins;
    boolean explosion1;
    boolean gameOver=false;
    boolean gameOver2=true;
    private int score = 0;
    JLabel showScore = new JLabel("" +score);

    public GamePanel() {
        showScore.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(showScore);
        this.goblins = new ArrayList<Goblin>();
        this.hero = new Hero(300, 260);
        Random random = new Random(2);
        new Thread(() -> {
            try {
                while (gameOver2) {
                    ArrayList<Goblin> copy = new ArrayList<>(this.goblins);
                    int xGoblin = random.nextInt(2);
                    copy.add(new Goblin(xGoblin));
                    System.out.println("number: " + xGoblin);
                    this.goblins = copy;
                    Thread.sleep(2000);
                    System.out.println("Goblin Added!");
                    if (this.score >= 3) {
                        gameOver2 = false;
                        showScore.setText("Kill the remaining goblins!");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }).start();



        new Thread(() -> {
            try {
                Thread.sleep(1000);
                setFocusable(true);
                requestFocus();
                this.addKeyListener(new KeyFunctions(this.hero));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    ImageIcon goblinIcon = new ImageIcon("src\\pics\\GoblinLeft.gif");
                    ImageIcon heroIcon = new ImageIcon("src\\pics\\soldier2_idle.gif");
                    Rectangle heroHitBox = new Rectangle(hero.getX(),hero.getY(),heroIcon.getIconWidth(), heroIcon.getIconHeight());
                    for (Goblin goblin : this.goblins) {
                        Rectangle goblinHitbox = new Rectangle(goblin.getX(), goblin.getY(), goblinIcon.getIconWidth(), goblinIcon.getIconHeight());
                        if (goblin.isFacingRight()) {
                            goblin.MoveRight();

                        } else
                            goblin.MoveLeft();
                        if(goblinHitbox.intersects(heroHitBox)){
                            if(hero.isAttacking()&&(hero.isFacingRight()!=goblin.isFacingRight())) {
                                goblin.setAlive(false);
                                score++;
                                showScore.setText(""+score);
                                try {
                                    Thread.sleep(400);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("yay!");
                                goblin.setY(-1000);
                                if(score==goblins.size()){
                                    showScore.setText("YOU WIN!!!");
                                    Thread.sleep(1000);
                                }
                            }
                            else{
                                endGame();
                            }
                        }
                    }
                    Thread.sleep(100);

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void endGame() {
        disappearHero();
        showExplosion();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hideExplosion();
    }

    public void disappearHero() {
        hero.setAlive(false);
        System.out.println("ouch!");


    }

    public void hideExplosion () {
        this.hero.setY(-10000);
        explosion1=false;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gameOver=true;

    }



    public void showExplosion () {
        explosion1=true;

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        ImageIcon background = new ImageIcon("src\\pics\\background.jpg");
        background.paintIcon(this, graphics, 0, 0);
        for (Goblin goblin : this.goblins) {
            if (goblin.isAlive()) {
                if (goblin.isFacingRight() == false) {
                    ImageIcon goblinIcon = new ImageIcon("src\\pics\\GoblinLeft.gif");
                    goblinIcon.paintIcon(this, graphics, goblin.getX(), goblin.getY());
                } else {
                    ImageIcon goblinIcon = new ImageIcon("src\\pics\\GoblinRight.gif");
                    goblinIcon.paintIcon(this, graphics, goblin.getX(), goblin.getY());
                }
            }
            else{
                ImageIcon goblinBloodIcon = new ImageIcon("src\\pics\\goblinblood.gif");
                goblinBloodIcon.paintIcon(this, graphics, goblin.getX(), goblin.getY());
            }
        }


        if (this.hero.isAlive()) {
            if(this.hero.isIdle()) {
                ImageIcon hero1 = new ImageIcon("src\\pics\\soldier2_idle.gif");
                hero1.paintIcon(this, graphics, hero.getX(), hero.getY());
            }
        if (this.hero.isMovingRight()) {
            this.hero.setIdle(false);
            this.hero.setMovingLeft(false);
            this.hero.setFacingRight(true);
            ImageIcon hero1 = new ImageIcon("src\\pics\\soldier2_move.gif");
            hero1.paintIcon(this, graphics, hero.getX(), hero.getY());
        }
        if (this.hero.isMovingLeft()) {
            this.hero.setIdle(false);
            this.hero.setMovingRight(false);
            this.hero.setFacingRight(false);
            ImageIcon hero1 = new ImageIcon("src\\pics\\soldier2_moveLeft.gif");
            hero1.paintIcon(this, graphics, hero.getX(), hero.getY());
        }
        if (this.hero.isAttacking()) {
            if (this.hero.isFacingRight() == true) {
                this.hero.setIdle(false);
                ImageIcon hero1 = new ImageIcon("src\\pics\\soldier2_attack.gif");
                hero1.paintIcon(this, graphics, hero.getX(), hero.getY());
            } else {
                this.hero.setIdle(false);
                ImageIcon hero1 = new ImageIcon("src\\pics\\soldier2_attackLeft.gif");
                hero1.paintIcon(this, graphics, hero.getX(), hero.getY());
            }

            }
        }

            if (!this.hero.isAlive()){
                if(explosion1==true) {
                    ImageIcon explosion = new ImageIcon("src\\pics\\blood.gif");
                    explosion.paintIcon(this, graphics, hero.getX(), hero.getY());
                }

        }
            if(this.gameOver){
                ImageIcon gameOverIcon = new ImageIcon("src\\pics\\GameOver.jpg");
                this.showScore.setVisible(false);
                gameOverIcon.paintIcon(this, graphics, 0, 0);

            }

    }
}
