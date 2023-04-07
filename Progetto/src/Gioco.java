import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.*;

public class Gioco implements KeyListener
{
	/**
	 * TODO:
	 * creare una mappa divisa in 4 stanze
	 * ogni stanza è un file txt in ciu gli # sono i muri,
	 * C sono le casse / B bauli, basta mettersi d'accordo
	 * M sono mostri 8 (non da mettere nella mappa ma saranno da inserire)
	 * 
	 * le casse sono una classe a parte; una volta aperte ti si apre un piccolo frame con il loro contenuto
	 * 
	 */
	
	private String comandi = " \n\n\nComandi:\n"
			+ "   W : avanti\n"
			+ "   A : sinistra\n"
			+ "   S : giu\n"
			+ "   D : destra\n"
			+ "   E : interagisci\n"
			+ "   F : colpisci";
	
	private Personaggio p = new Personaggio('@');
	private char[][] mappaTemp = new char [14][44];
	
	JFrame gioco = new JFrame();
	JPanel bordoSup = new JPanel();
	JTextArea bordoSx = new JTextArea();
	JTextArea central = new JTextArea();
	JProgressBar vita = new JProgressBar();
	
	Mappa avvio = new Mappa("stanzaAvvio.txt");
	Mappa est1 = new Mappa("stanzaEst.txt");
	Mappa est2 = new Mappa("stanzaEst2.txt");
	Mappa nord = new Mappa("stanzaNord1.txt");
	Mappa ovest = new Mappa("stanzaOvest.txt");
	
	Gioco(int H, int L) throws IOException
	{
		/**********************************************************/
		gioco.setSize(L,H);
		gioco.setResizable(true);
		gioco.setTitle("Adventure Game");
		gioco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gioco.getContentPane().setBackground(Color.BLACK);
		gioco.setVisible(true);
		gioco.setLayout(new BorderLayout());
		
		/**********************************************************/
		bordoSup.setLayout(new BorderLayout());
		bordoSup.setBounds(0, 0, L, H);
		
		/**********************************************************/
		vita.setBounds(0, 0, L, 400);
		vita.setValue(50);
		vita.setBackground(Color.BLACK);
		vita.setForeground(Color.RED);
		vita.setStringPainted(true);
		vita.setMaximum(50);
		vita.setFont(new Font("Stencil",Font.ITALIC, 20));
		vita.setString("Vita: "+ vita.getValue());
		
		gioco.add(vita, BorderLayout.NORTH);
		
		colpito(0);
	}
	
	private void colpito(int valore)
	{
		int vitaAttuale = vita.getValue();
		vita.setValue(vitaAttuale-valore);
		vita.setString("Vita: "+ vita.getValue());
	}
	
	public boolean start()
	{
		/*
		 * TODO:
		 * fare il gioco
		 * quando si vince ritorna true, se si muore ritorna false
		 */
		
		//inizio
		/**********************************************************/
		bordoSx.setText(this.comandi + this.setStringInventario());
		bordoSx.setBackground(Color.BLACK);
		bordoSx.setForeground(Color.ORANGE);
		bordoSx.setFont(new Font("Courier",Font.PLAIN, 20));
		bordoSx.setOpaque(true);
		bordoSx.setEditable(false);
		
		central.setText(avvio.getMappa()); //cambia la mappa mostrata
		mappaTemp = avvio.getMappaMovimento();
		
		
		central.setBackground(Color.BLACK);
		central.setForeground(Color.WHITE);
		central.setFont(new Font("Courier",Font.PLAIN, 40));
		central.setOpaque(true);
		central.setEditable(false);

		gioco.add(bordoSx, BorderLayout.LINE_START);
		gioco.add(central, BorderLayout.CENTER);
		return true;
	}
	
	private String setStringInventario()
	{
		//dovra essere passato in futuro un oggetti trasportabile con un icona che sceglieremo (o il nome)
		//per essere inserito nell'inventario sul bordo della mappa
		
		String s = "\n\n\n Inventario:\n";
		
		return s;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO:
		/*
		 * funzione per spostare il personaggio
		 * una per movimento
		 * controllare che non ci siano '_' o '-' oppure '|'
		 * se c'è la cassa ('c') e la 'e' viene premuta bisogna aprirla
		 * inventarsi un modo per cambiare stanza
		 */
		switch(e.getKeyChar()) {
		
		case 'a': central.setLocation(central.getX()-10, central.getY());
			break;
		case 'w': central.setLocation(central.getX(), central.getY()-10);
			break;
		case 's': central.setLocation(central.getX(), central.getY()+10);
			break;
		case 'd': central.setLocation(central.getX()+10, central.getY());
		case 'f': //colpisci
		case 'e': //cassa
			break;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}