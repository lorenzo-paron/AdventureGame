import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class Menu implements ActionListener
{
	/**********************************************************/
	private int L = 1820;
	private int H = 980;
	
	/**********************************************************/
	JFrame frame = new JFrame();
	
	JPanel titolo = new JPanel();
	JLabel testo = new JLabel();
	
	JPanel fine = new JPanel();
	JLabel testoFine = new JLabel("versione 1.1");
	
	JPanel areaBottoni = new JPanel();
	JButton[] bottoni = new JButton[4];
	
	/**
	 * TODO: tramite file di Ballandini mettere la modalità impostazioni sul menu
	 */
	
	public void start()
	{		
		/**********************************************************/
		frame.setSize(L,H);
		frame.setTitle("Adventure Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.setResizable(true);
		
		/**********************************************************/
		testo.setBackground(Color.BLACK);
		testo.setForeground(Color.WHITE);
		testo.setHorizontalAlignment(JLabel.CENTER);
		testo.setFont(new Font("Stencil",Font.ITALIC, 100));
		testo.setText("ADVENTURE GAME");
		testo.setOpaque(true);
		
		/**********************************************************/
		testoFine.setBackground(Color.BLACK);
		testoFine.setForeground(Color.WHITE);
		testoFine.setHorizontalAlignment(JLabel.RIGHT);
		testoFine.setFont(new Font("Stencil",Font.ITALIC, 10));
		testoFine.setOpaque(true);
		
		/**********************************************************/
		titolo.setLayout(new BorderLayout());
		titolo.setBounds(0, 0, L, H);
		fine.setLayout(new BorderLayout());
		fine.setBounds(0, 0, L, H);
		
		/**********************************************************/
		areaBottoni.setLayout(new GridLayout(4,1));
		areaBottoni.setBackground(Color.BLACK);
		//areaBottoni.setBorder();
		
		/**********************************************************/		
		bottoni[0] = new JButton();
		areaBottoni.add(bottoni[0]);
		bottoni[0].setFont(new Font("Stencil",Font.ITALIC, 20));
		bottoni[0].setFocusable(false);
		bottoni[0].addActionListener(this);
		bottoni[0].setText("Gioca");
		bottoni[0].setForeground(Color.WHITE);
		bottoni[0].setBackground(Color.BLACK);
		bottoni[0].setBounds(800, 400, 200, 40);
	
		bottoni[1] = new JButton();
		areaBottoni.add(bottoni[1]);
		bottoni[1].setFont(new Font("Stencil",Font.ITALIC, 20));
		bottoni[1].setFocusable(false);
		bottoni[1].addActionListener(this);
		bottoni[1].setText("Autori");
		bottoni[1].setForeground(Color.WHITE);
		bottoni[1].setBackground(Color.BLACK);
		bottoni[1].setBounds(800, 400, 200, 40);
		
		bottoni[2] = new JButton();
		areaBottoni.add(bottoni[2]);
		bottoni[2].setFont(new Font("Stencil",Font.ITALIC, 20));
		bottoni[2].setFocusable(false);
		bottoni[2].addActionListener(this);
		bottoni[2].setText("Impostazioni");
		bottoni[2].setForeground(Color.WHITE);
		bottoni[2].setBackground(Color.BLACK);
		bottoni[2].setBounds(800, 400, 200, 40);
		
		bottoni[3] = new JButton();
		areaBottoni.add(bottoni[3]);
		bottoni[3].setFont(new Font("Stencil",Font.ITALIC, 20));
		bottoni[3].setFocusable(false);
		bottoni[3].addActionListener(this);
		bottoni[3].setText("Esci");
		bottoni[3].setForeground(Color.WHITE);
		bottoni[3].setBackground(Color.BLACK);
		bottoni[3].setBounds(800, 400, 200, 40);
		
		/**********************************************************/		
		titolo.add(testo);
		fine.add(testoFine);
		areaBottoni.setBounds(800, 400, 200, 40);
		
		/**********************************************************/
		frame.add(titolo, BorderLayout.PAGE_START);
		frame.add(fine, BorderLayout.PAGE_END);
		frame.add(areaBottoni, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0; i<4; i++)
		{
			if(e.getSource() == bottoni[i])
			{
				switch(i) {
				case 0: try {
						gioco();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} break;
				case 1: autori(); break;
				case 2: impostazioni(); break;
				case 3: esci(); break;
				default: break;
				}
			}
		}
	}

	private void esci()
	{
		int exit = (JOptionPane.showOptionDialog(null, "Vuoi veramente USCIRE?", "EXIT", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0));
		if(exit == 0)
			frame.dispose();
	}

	private void autori()
	{
		new Autori();
	}

	private void impostazioni()
	{
		//adattare file Ballandini
		//conviene fare una classe
		//L = imput casella testo larghezza;
		//H = imput casella testo altezza;
		//se riusciamo con il cambio colore testo
		//per il giocatore: cambiare pedina e nome
		
		new Settings();
		
		frame.setSize(L, H);
	}
	
	private void gioco() throws IOException
	{
		Gioco g = new Gioco(H, L);
		
		/**
		 * TODO: fare una schermata per la vittoria
		 * g.start() ritorna gia un boolean
		 */
		if(g.start())
			vittoria();
		else
			scarso();
		
	}
	
	private void vittoria()
	{
		new Vittoria();
	}
	
	private void scarso()
	{
		new GameOver();
	}
	
}
