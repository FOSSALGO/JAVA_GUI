package fosalgo;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konversi CM ke INCH");
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
        
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container pane = frame.getContentPane();
        JLabel jLabelCm = new JLabel("CM      ");
        JTextField jTextFieldCm = new JTextField();
        JButton jButtonConvert = new JButton("Convert");
        JLabel jLabelInch = new JLabel("INCH");
        JTextField jTextFieldInch = new JTextField();
        
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();//constraint
        
        //letakkan label cm
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.3;
	c.gridx = 0;
	c.gridy = 0;
	pane.add(jLabelCm, c);
        
        //letakkan textfield cm
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 0;
        c.gridwidth = 4;
	pane.add(jTextFieldCm, c);
        
        //letakkan tombol convert
        c.fill = GridBagConstraints.HORIZONTAL;
	c.gridwidth = 5;
	c.gridx = 0;
	c.gridy = 1;
	pane.add(jButtonConvert, c);
        
        //letakkan label inch
        c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 2;
	pane.add(jLabelInch, c);
        
        //letakkan textfield cm
        c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 2;
        c.gridwidth = 4;
	pane.add(jTextFieldInch, c);
        
        jButtonConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String sCm = jTextFieldCm.getText();
                double dCm = Double.parseDouble(sCm);
                double dInch = dCm / 2.54;
                String sInch = String.valueOf(dInch);
                jTextFieldInch.setText(sInch);
            }
        });
        
        //frame.pack();        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
