package fosalgo;

import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplikasi GUI JSOUP");
        frame.setSize(400, 300);//atur lebar dan tinggi window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setBackground(Color.decode("#d35400"));

        //ImageIcon imageIcon = new ImageIcon("logo.png");
        //frame.setIconImage(imageIcon.getImage());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
