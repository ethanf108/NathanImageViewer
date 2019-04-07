
package launch;

import java.awt.image.BufferedImage;

public class Main {

    private String path;
    public Main(){
        this.path = PathGetter.getInPath();
        System.out.println("Path: '"+path+"'");
        BufferedImage img = ImgGenerator.readImage(path);
        DisplayImg di = new DisplayImg(img);
    }
    public static void main(String[] args) {
        Main m = new Main();
    }

}
