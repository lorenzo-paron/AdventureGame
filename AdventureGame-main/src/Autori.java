import javax.swing.*;
import java.awt.*;

public class Autori extends JFrame {

    public Autori(){

        JFrame autori = new JFrame("Autori");
        autori.setBounds(100, 200, 1050, 583);
        autori.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = autori.getContentPane();

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("Autori.png"));
        Dimension size = label.getPreferredSize();
        label.setBounds(50, 30, 520, 504);

        autori.setLocationRelativeTo(null);

        c.add(label);

        autori.setVisible(true);
    }



}
