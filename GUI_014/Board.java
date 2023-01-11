package fosalgo;

import java.awt.BasicStroke;
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
public class Board extends JPanel implements Runnable{

    Thread thread;
    int x = 20,y=30;

    public Board() {
        init();
    }
    
    private void init(){
        addKeyListener(new TAdapter());
        setFocusable(true);
    }
    
    @Override
    public void addNotify(){
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }
    
    private void update(){
        x++;
        y++;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor(new Color(16,161,157));
        //g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        
        g2d.setColor(Color.GRAY);
        g2d.setStroke(new BasicStroke(10));
        g2d.drawRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        
        g2d.setColor(Color.red);
        //g2d.fillRect(x, y, 60, 80);   
        g2d.fillRoundRect(x, y, 60, 80, 20, 20);
    }  

    @Override
    public void run() {
         while(true){
             update();
             repaint();//render
             try{
                 Thread.sleep(20);
             }catch(InterruptedException ex){
                 ex.printStackTrace();
             }
         }
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
