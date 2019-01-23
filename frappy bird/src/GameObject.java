import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;

public class GameObject {
    public Random rand = new Random(System.currentTimeMillis());
    protected int topPipeHeight;
    protected JLabel image;
    protected double vx, vy;
    protected int SCREEN_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    protected int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    GameObject()
    {
        topPipeHeight = rand.nextInt(500)+100;
        image = new JLabel();   //very important data field
        vx = 0.0;
        vy = 0.0;
    }
    public JLabel getImage() { return image;}

    public int getTopPipeHeight() {
        return topPipeHeight;
    }
    public void resetTopPipeHeight() {
        topPipeHeight = rand.nextInt(500) + 100;
    }
}

class bird extends GameObject implements KeyListener
{
    int x, y;
    bird()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes addedLabel ans stores it
        try {
            URL imgurl = getClass().getResource("/resources/Bird2-1.png.png");
            Image img = toolkit.getImage(imgurl);
            img = img.getScaledInstance( 50, 50, Image.SCALE_SMOOTH);
            ImageIcon i = new ImageIcon(img);
            JLabel l = new JLabel();
            l.setIcon(i);
            image = l;
        } catch (Exception ex) {}
        vy = 9.0;
        vx = 9.0;  // how fast is this
        x = 75; y = 300;
    }
    public void keyPressed( KeyEvent k) {
        if (k.getKeyCode() == 40) {
            vy = 9;
            //move();
        } else {
            vy = -9;//is this a good number?
           // move();
        }
    }
    public void keyReleased(KeyEvent k) {}
    public void keyTyped (KeyEvent k) {}
    public void move()
    {
        (this.getImage()).setLocation(x += (int)vx, y += (int)vy);
    }

}


class scoreBox extends GameObject
{
    scoreBox() {
        URL imgurl;
        Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes addedLabel ans stores it
        try {
            imgurl = getClass().getResource("/resources/white.png");
            Image img = toolkit.getImage(imgurl);
            img = img.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
            ImageIcon i = new ImageIcon(img);
            JLabel l = new JLabel();
            l.setIcon(i);
            image = l;
        } catch (Exception ex) {
        }
        image.setVisible(true);
    }
}
class topPipe extends GameObject
{
    URL imgurl;
    topPipe()
        {

            Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes addedLabel ans stores it
            try {
                imgurl = getClass().getResource("/resources/pipe_down.png");
                Image img = toolkit.getImage(imgurl);
                img = img.getScaledInstance(150, topPipeHeight, Image.SCALE_SMOOTH);
                ImageIcon i = new ImageIcon(img);
                JLabel l = new JLabel();
                l.setIcon(i);
                image = l;
            } catch (Exception ex) {}
            topPipeHeight = rand.nextInt(500)+100;
    }

}
class bottomPipe extends GameObject {
    private URL bottomPipe;
    private Image bottomPipeimg;
    private ImageIcon bottomPipeIcon;
    private JLabel bottomPipeLabel;

    bottomPipe() {

        Toolkit tk = Toolkit.getDefaultToolkit();
        try {
            bottomPipe = getClass().getResource("/resources/pipe_up.png");
            bottomPipeimg = tk.getImage(bottomPipe);
            bottomPipeimg = bottomPipeimg.getScaledInstance(150, SCREEN_HEIGHT-topPipeHeight-100, Image.SCALE_SMOOTH);
            bottomPipeIcon = new ImageIcon(bottomPipeimg);
            bottomPipeLabel = new JLabel();
            bottomPipeLabel.setIcon(bottomPipeIcon);
            image = bottomPipeLabel;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        image.setVisible(true);
    }
}



