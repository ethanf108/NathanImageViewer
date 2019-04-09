package launch;

import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        String path = PathGetter.getInPath();
        System.out.println("Path: '" + path + "'");
        BufferedImage img = ImgGenerator.readImage(path);
        DisplayImg di = new DisplayImg(img);
    }

}
