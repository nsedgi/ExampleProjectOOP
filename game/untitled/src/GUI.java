import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
public GUI(){
    Dimension dimension = new Dimension(900, 600);
    GamePanel g1 = new GamePanel();
    this.setPreferredSize(dimension);
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
    this.add(g1);
}
}
