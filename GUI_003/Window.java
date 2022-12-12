package fosalgo;

import java.awt.Color;
import java.awt.Container;
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

    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int N = 23;
    public static final int SIZE = ALPHABET.length();//26

    public static void main(String[] args) {
        JFrame frame = new JFrame("Crypto Caesar Cipher");
        frame.setSize(600, 300);//atur lebar dan tinggi window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("logo.png");
        frame.setIconImage(imageIcon.getImage());

        Container contentPane = frame.getContentPane();
        contentPane.setBackground(Color.decode("#d35400"));
        contentPane.setLayout(new FlowLayout());

        JLabel jLabel1 = new JLabel("Plaintext");
        contentPane.add(jLabel1);

        JTextField jTextField1 = new JTextField();
        jTextField1.setPreferredSize(new Dimension(100, 28));
        contentPane.add(jTextField1);

        JButton jButton1 = new JButton("Encrypt");
        contentPane.add(jButton1);

        JButton jButton2 = new JButton("Decrypt");
        contentPane.add(jButton2);

        JLabel jLabel2 = new JLabel("Ciphertext");
        contentPane.add(jLabel2);

        JTextField jTextField2 = new JTextField();
        jTextField2.setPreferredSize(new Dimension(100, 28));
        contentPane.add(jTextField2);

        //AKSI TOMBOL
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plaintext = jTextField1.getText();
                plaintext = plaintext.toUpperCase();
                String ciphertext = "";
                for (int i = 0; i < plaintext.length(); i++) {
                    char cin = plaintext.charAt(i);
                    int x = ALPHABET.indexOf(cin);//mencari posisi huruf di alphabet
                    int ex = (x + N) % SIZE;
                    char cout = ALPHABET.charAt(ex);
                    ciphertext = ciphertext + cout;//konkatenasi
                }
                jTextField2.setText(ciphertext);
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciphertext = jTextField2.getText();
                ciphertext = ciphertext.toUpperCase();
                String plaintext = "";
                for (int i = 0; i < ciphertext.length(); i++) {
                    char cin = ciphertext.charAt(i);
                    int x = ALPHABET.indexOf(cin);//mencari posisi huruf di alphabet
                    int dx = (x - N) % SIZE;
                    if (dx < 0) {
                        dx = SIZE + dx;
                    }
                    char cout = ALPHABET.charAt(dx);
                    plaintext = plaintext + cout;
                }
                jTextField1.setText(plaintext);
            }
        });

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
