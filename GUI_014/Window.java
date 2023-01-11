package fosalgo;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sugiarto Cokrowibowo <fosalgo>
 */
public class Window extends JFrame {

    public Window() {
        add(new Board());
        ImageIcon ii = new ImageIcon("logo.png");
        Image image = ii.getImage();
        setIconImage(image);
        setTitle("Sudah ADA Judul");
        setSize(640, 480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window w = new Window();
            }
        });
    }

}
