package launch;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public final class DisplayImg extends JFrame {

    private final BufferedImage dispImg;

    public DisplayImg(BufferedImage img) {
        super("Image");
        this.dispImg = img;
        this.setSize(new Dimension(this.dispImg.getWidth(), this.dispImg.getHeight()));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        this.repaint();
    }

    @Override
    public void paint(Graphics go) {
        Graphics2D g = (Graphics2D) go;
        g.drawImage(dispImg, null, 0, 0);
    }

}
