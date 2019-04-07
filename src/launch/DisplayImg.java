package launch;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayImg extends JPanel{
    private final BufferedImage dispImg;
    private final JFrame frame;
    
    private void setupFrame(){
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public DisplayImg(BufferedImage img){
        super();
        this.frame = new JFrame("Image");
        this.dispImg = img;
        this.setPreferredSize(new Dimension(this.dispImg.getWidth(), this.dispImg.getHeight()));
        setupFrame();
        this.frame.repaint();
    }
    
    @Override
    public void paintComponent(Graphics go){
        Graphics2D g = (Graphics2D)go;
        g.drawImage(dispImg, null, 0, 0);
    }

}
