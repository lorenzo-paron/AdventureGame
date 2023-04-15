import javax.swing.*;
import java.awt.*;

public class GameOver extends JFrame {

    public GameOver() {

        Icon icon = new ImageIcon(this.getClass().getResource("giphy.gif"));

        JFrame gameOver = new JFrame("gif");

        JLabel label = new JLabel(icon);
        gameOver.setBackground(Color.black);

        label.setBounds(668, 43, 46, 14);

        gameOver.getContentPane().add(label);

        gameOver.setBackground(Color.black);

        gameOver.setSize(800, 500);

        gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameOver.setVisible(true);

    }



}
