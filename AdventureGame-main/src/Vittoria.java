import javax.swing.*;
import java.awt.*;

public class Vittoria extends JFrame {

    public Vittoria(){

        JFrame vittoria = new JFrame("YOU WIN!!!");

        vittoria.setBounds(100, 200, 520, 504);
        vittoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = vittoria.getContentPane();

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("vittoria.jpg"));
        Dimension size = label.getPreferredSize();
        label.setBounds(50, 30, 520, 504);

        vittoria.setLocationRelativeTo(null);

        c.add(label);

        vittoria.setVisible(true);
    }

}
