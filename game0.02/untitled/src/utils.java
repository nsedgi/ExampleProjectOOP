import javax.swing.*;

public class utils {
    public class Utils {
        public ImageIcon createImage (String path) {
            return new ImageIcon(Utils.class.getResource(path));
        }
    }
}
