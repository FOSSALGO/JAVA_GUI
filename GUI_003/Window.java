package fosalgo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int n = 23;
    private static final int size = ALPHABET.length();//26

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplikasi GUI");
        frame.setSize(600, 100);//atur lebar dan tinggi window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.decode("#d35400"));

        frame.getContentPane().setLayout(new FlowLayout());

        JLabel jLabel1 = new JLabel("Plaintext");
        frame.getContentPane().add(jLabel1);

        JTextField jTextField1 = new JTextField();
        jTextField1.setPreferredSize(new Dimension(100, 28));
        frame.getContentPane().add(jTextField1);

        JButton jButton1 = new JButton("Encrypt");
        frame.getContentPane().add(jButton1);

        JButton jButton2 = new JButton("Decrypt");
        frame.getContentPane().add(jButton2);

        JLabel jLabel2 = new JLabel("Ciphertext");
        frame.getContentPane().add(jLabel2);

        JTextField jTextField2 = new JTextField();
        jTextField2.setPreferredSize(new Dimension(100, 28));
        frame.getContentPane().add(jTextField2);

        //AKSI TOMBOL
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("ENCRYPT");
                String plaintext = jTextField1.getText();
                plaintext = plaintext.toUpperCase();
                String ciphertext = "";
                for (int i = 0; i < plaintext.length(); i++) {
                    char cin = plaintext.charAt(i);
                    int x = ALPHABET.indexOf(cin);
                    int ex = (x + n) % size;
                    char cout = ALPHABET.charAt(ex);
                    ciphertext = ciphertext + cout;
                }
                jTextField2.setText(ciphertext);
            }
        });

        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("ENCRYPT");
                String ciphertext = jTextField2.getText();
                ciphertext = ciphertext.toUpperCase();
                String plaintext = "";
                for (int i = 0; i < ciphertext.length(); i++) {
                    char cin = ciphertext.charAt(i);
                    int x = ALPHABET.indexOf(cin);
                    int dx = (x - n) % size;
                    if (dx < 0) {
                        dx = size + dx;
                    }
                    char cout = ALPHABET.charAt(dx);
                    plaintext = plaintext + cout;
                }
                jTextField1.setText(plaintext);
            }
        });

        ImageIcon imageIcon = new ImageIcon("logo.png");
        frame.setIconImage(imageIcon.getImage());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
