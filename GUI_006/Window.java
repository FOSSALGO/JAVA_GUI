package fosalgo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Window {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplikasi GUI JSOUP");
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ///
        }
        
        frame.setSize(600, 400);//atur lebar dan tinggi window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setBackground(Color.decode("#d35400"));
        contentPane.setLayout(new BorderLayout());

        JPanel jPanelNorth = new JPanel(new FlowLayout());
        JLabel jLabelURL = new JLabel("URL");
        JTextField jTextFieldURL = new JTextField();
        jTextFieldURL.setPreferredSize(new Dimension(300, 30));
        JButton jButtonGO = new JButton("GO");
        jPanelNorth.add(jLabelURL);
        jPanelNorth.add(jTextFieldURL);
        jPanelNorth.add(jButtonGO);
        contentPane.add(jPanelNorth, BorderLayout.NORTH);

        JPanel jPanelCenter = new JPanel(new BorderLayout());
        JScrollPane jScrollPane = new JScrollPane();
        JTextPane jTextPane = new JTextPane();
        jScrollPane.setViewportView(jTextPane);
        jPanelCenter.add(jScrollPane, BorderLayout.CENTER);

        contentPane.add(jPanelCenter, BorderLayout.CENTER);

        //ACTION
        jButtonGO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    String sURL = jTextFieldURL.getText();
                    Document document = Jsoup.connect(sURL).get();
                    String text = document.text();
                    jTextPane.setText(text);
                } catch (IOException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //ImageIcon imageIcon = new ImageIcon("logo.png");
        //frame.setIconImage(imageIcon.getImage());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
