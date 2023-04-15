import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Settings implements ItemListener{

    JPanel cards;

    final static String BUTTONPANEL = "Cambia Risoluzione";
    final static String BUTTONPANEL2 = "1920x1080";
    final static String BUTTONPANEL3 = "1600x900";
    final static String BUTTONPANEL4 = "1280x720";
    final static String BUTTONPANEL5 = "1280x600";
    final static String BUTTONPANEL6 = "854x480";

    private JButton buttonSet = new JButton("Set");

    public void addComponentToPane(Container pane)
    {
        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = {BUTTONPANEL, BUTTONPANEL2, BUTTONPANEL3, BUTTONPANEL4, BUTTONPANEL5, BUTTONPANEL6};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);


        JPanel card1 = new JPanel();
        card1.add(buttonSet);

        cards = new JPanel(new CardLayout());
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(card1, BorderLayout.CENTER);
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Impostazioni");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Settings demo = new Settings();
        demo.addComponentToPane(frame.getContentPane());

        frame.setSize(300, 150);;
        frame.setVisible(true);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    public void actionPerformed(ActionEvent e) {

        JButton premuto = (JButton)e.getSource();
    }

    public Settings(){

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
