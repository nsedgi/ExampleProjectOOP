import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyFunctions implements KeyListener {
    private Hero hero;

    public KeyFunctions(Hero hero){
        this.hero = hero;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (this.hero.isAlive()){
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                hero.MoveRight(); break;
            case KeyEvent.VK_LEFT:
                hero.MoveLeft(); break;
            case KeyEvent.VK_CONTROL:
                hero.Attack(); break;
        }}
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        hero.StayIdle();
    }
}
