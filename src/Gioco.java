import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.*;

public class Gioco
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
	
	char[][] mappaMovimento = new char[14][44];
	
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
	
	Mappa tempo = new Mappa("stanzaAvvio.txt");
	
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
		
		tempo = avvio;
		
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
		
		gioco.addKeyListener(new MyKeyListener());
		gioco.setFocusable(true);
	
		
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
		
		mappaMovimento = avvio.spostaPediana(avvio.getMappaMovimento(), p);
		central.setText(avvio.trasformaDaChar(mappaMovimento));
		
		
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
	
	
		
	
	
	
	class MyKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {}
		
		public void keyReleased(KeyEvent e) {
			System.out.println("You releasd key char: " + e.getKeyChar());
			System.out.println("You releasd key code: " + e.getKeyCode());
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO:
			/*
			 * funzione per spostare il personaggio
			 * una per movimento
			 * controllare che non ci siano '_' o '-' oppure '|'
			 * se c'� la cassa ('c') e la 'e' viene premuta bisogna aprirla
			 * inventarsi un modo per cambiare stanza
			 */
			switch(e.getKeyChar()) {
			
			case 'a': muoviPedinaASinistra();
				break;
			case 'w': muoviPedinaSu();
				break;
			case 's': muoviPedinaGiu();
				break;
			case 'd': muoviPedinaADestra();
				break;
			case 'f': //colpisci
			case 'e': //cassa
				break;
			}
			
		}
		
		
		
		
	}
	
	
	public void muoviPedinaASinistra() {
		
		char[][] mappaMovimento = tempo.trasformaDaString(avvio.getMappa(), p);
		if(controlloCambioMappa() == true) {
			cambioMappaAvvio();
			return;
		}
		if(controlloSinistraAvvio() == true) {
			p.setPosizioneX(p.getPosizioneX()-1);
		}
		mappaMovimento = tempo.spostaPediana(mappaMovimento, p);
		this.mappaMovimento = mappaMovimento;
		String s = tempo.trasformaDaChar(mappaMovimento);
		System.out.println(s);
		central.setText(s); //cambia la mappa mostrata
	}
	
	public void muoviPedinaADestra() {
		
		char[][] mappaMovimento = tempo.trasformaDaString(tempo.getMappa(), p);
		if(controlloCambioMappa() == true) {
			cambioMappaAvvio();
			return;
		}
		if(controlloDestraAvvio() == true) {
			p.setPosizioneX(p.getPosizioneX()+1);
		}
		mappaMovimento = tempo.spostaPediana(mappaMovimento, p);
		this.mappaMovimento = mappaMovimento;
		String s = tempo.trasformaDaChar(mappaMovimento);
		central.setText(s); //cambia la mappa mostrata
	}
	
	public void muoviPedinaSu() {
		
		char[][] mappaMovimento = tempo.trasformaDaString(tempo.getMappa(), p);
		if(controlloCambioMappa() == true) {
			cambioMappaAvvio();
			return;
		}
		if(controlloSuAvvio() == true) {
			p.setPosizioneY(p.getPosizioneY()-1);
		}
		mappaMovimento = tempo.spostaPediana(mappaMovimento, p);
		this.mappaMovimento = mappaMovimento;
		String s = tempo.trasformaDaChar(mappaMovimento);
		System.out.println(s);
		central.setText(s); //cambia la mappa mostrata
	}
	
	public void muoviPedinaGiu() {
		
		char[][] mappaMovimento = tempo.trasformaDaString(tempo.getMappa(), p);
		if(controlloCambioMappa() == true) {
			cambioMappaAvvio();
			return;
		}
		if(controlloGiuAvvio() == true) {
			p.setPosizioneY(p.getPosizioneY()+1);
		}
		mappaMovimento = tempo.spostaPediana(mappaMovimento, p);
		this.mappaMovimento = mappaMovimento;
		String s = tempo.trasformaDaChar(mappaMovimento);
		System.out.println(s);
		central.setText(s); //cambia la mappa mostrata
	}
	
	public boolean controlloGiuAvvio() {
		
		return (mappaMovimento[p.getPosizioneY()+1][p.getPosizioneX()] != '_' && mappaMovimento[p.getPosizioneY()+1][p.getPosizioneX()] != '|' && (p.getPosizioneY()+1==10? (p.getPosizioneX()<27?true:false):true) && (p.getPosizioneY()+1==9? (p.getPosizioneX()<42?true:false):true) ?true:false);
	}
	
	public boolean controlloDestraAvvio() {
		
		return (mappaMovimento[p.getPosizioneY()][p.getPosizioneX()+1] != '_' && mappaMovimento[p.getPosizioneY()][p.getPosizioneX()+1] != '|'?true:false);
	}
	
	public boolean controlloSinistraAvvio() {
		return (mappaMovimento[p.getPosizioneY()][p.getPosizioneX()-1] != '_'&& mappaMovimento[p.getPosizioneY()][p.getPosizioneX()-1] != '|'?true:false);
		
	}
	public boolean controlloSuAvvio() {
		
		return (mappaMovimento[p.getPosizioneY()-1][p.getPosizioneX()] != '_' && mappaMovimento[p.getPosizioneY()-1][p.getPosizioneX()] != '|' && (p.getPosizioneY()-1==10? (p.getPosizioneX()<27?true:false):true) && (p.getPosizioneY()+1==9? (p.getPosizioneX()<42?true:false):true) ?true:false);
	}
	
	public boolean controlloCambioMappa() {
		return (p.getPosizioneX()-1 == -1 || p.getPosizioneY()-1 == -1);
	}
	
	public void cambioMappaAvvio() {
		if(p.getPosizioneX()-1 == -1 && (p.getPosizioneY() == 5 || p.getPosizioneY() == 4)) {
			p.setPosizioneX(43);
			p.setPosizioneY(3);
			mappaMovimento = est1.spostaPediana(est1.getMappaMovimento(), p);
			avvio = tempo;
			tempo = est1;
			central.setText(est1.trasformaDaChar(mappaMovimento));
		}
	}
	
}