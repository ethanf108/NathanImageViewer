package launch;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ImgGenerator {

    private static final class ds {

        int x, y;
        Color c;

        public static ds from(String g) {
            ds ret = new ds();
            String xy = g.split(":? ")[0];
            ret.x = Integer.parseInt(xy.split(",")[0]);
            ret.y = Integer.parseInt(xy.split(",")[1]);
            String c = g.split(":? ")[1];
            String c1 = c.split(",")[0].substring(1);
            String c2 = c.split(",")[1];
            String c3 = c.split(",")[2];
            c3 = c3.substring(0, c3.length() - 1);
            double i1 = Double.parseDouble(c1);
            double i2 = Double.parseDouble(c2);
            double i3 = Double.parseDouble(c3);
            i1 = (i1 / 65536.0) * 255.0;
            i2 = (i2 / 65536.0) * 255.0;
            i3 = (i3 / 65536.0) * 255.0;
            Color cl = new Color((int) i1, (int) i2, (int) i3);
            ret.c = cl;
            return ret;
        }
    }

    public static BufferedImage readImage(String path) {
        try {
            List<ds> points = Files.lines(new File(path).toPath())
                    .parallel().map(n -> ds.from(n)).collect(Collectors.toList());
            int x = points.parallelStream()
                    .map(n -> n.x)
                    .reduce(Integer::max)
                    .orElseThrow(() -> new IllegalStateException("No Points"));
            int y = points.parallelStream()
                    .map(n -> n.y)
                    .reduce(Integer::max)
                    .orElseThrow(() -> new IllegalStateException("No Points"));
            System.out.println("X: " + x + " Y: " + y);
            final BufferedImage ret = new BufferedImage(x + 1, y + 1, BufferedImage.TYPE_INT_ARGB);
            points.parallelStream().forEach(n -> {
                ret.setRGB(n.x, n.y, n.c.getRGB());
            });
            return ret;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
            return null;
        }
    }

}
