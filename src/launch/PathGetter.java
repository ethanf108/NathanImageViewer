package launch;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class PathGetter extends JFrame{
    private String path = null;
    private final JLabel label = new JLabel("Input Path:");
    private final JTextField inLine = new JTextField();
    private final JButton submit = new JButton("Submit");
    private final ActionListener submitAction = e -> {
            this.path = inLine.getText();
    };
    private PathGetter(){
        super("Nathan Image Viewer");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label);
        getContentPane().add(inLine);
        getContentPane().add(submit);
        inLine.setPreferredSize(new Dimension(300, 30));
        getContentPane().revalidate();
        setSize(new Dimension(500,80));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        submit.addActionListener(this.submitAction);
        inLine.addActionListener(this.submitAction);
    }
    private String getPath(){
        while(path == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return path;
    }
    public static String getInPath(){
        PathGetter p = null;
        try{
        p = new PathGetter();
        p.setVisible(true);
        p.getContentPane().validate();
        return p.getPath();
        }finally{
            p.dispose();
        }
    }
}
