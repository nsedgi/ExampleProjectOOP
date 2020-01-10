import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public final int WIDTH=900;
    public final int HEIGHT=600;
public GUI(){
    Dimension dimension = new Dimension(WIDTH, HEIGHT);
    GamePanel g1 = new GamePanel();
    this.setPreferredSize(dimension);
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
    this.add(g1);
}
}
