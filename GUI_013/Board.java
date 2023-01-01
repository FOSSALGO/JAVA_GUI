package fosalgo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author Sugiarto Cokrowibowo <fosalgo>
 */
public class Board extends JPanel {

    int x = 20,y=30;

    public Board() {
        init();
    }
    
    private void init(){
        addKeyListener(new TAdapter());
        setFocusable(true);
    }
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor(new Color(16,161,157));
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        g2d.setColor(Color.red);
        g2d.fillRect(x, y, 60, 80);        
    }  
    
    private class TAdapter extends KeyAdapter{
        
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_LEFT){
                x -= 4;
            }else if(key == KeyEvent.VK_RIGHT){
                x += 4;
            }
            
            if(key == KeyEvent.VK_UP){
                y -= 4;
            }else if(key == KeyEvent.VK_DOWN){
                y += 4;
            }
            
            
            System.out.println("x: "+x);
            repaint();
        }
    }
}
