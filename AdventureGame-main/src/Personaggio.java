import java.util.*;
import javax.swing.ImageIcon;

public class Personaggio
{
	private char pedina;
	private int vita = 50;
	private int forza = 10;
	private int attacco = 5;
	private int difesa = 5;
	private int esperienza = 0;
	private HashMap<Integer, Oggetto> inventario;
	private Mappa luogo;
	private int posizioneX = 13;
	private int posizioneY = 12;
	
	Personaggio(char pedina)
	{
		this.pedina = pedina;
		inventario = new HashMap<Integer, Oggetto>();
	}

	public int getVita() {return vita;}
	public void setVita(int vita) {this.vita = vita;}
	public int getForza() {return forza;}
	public void setForza(int forza) {this.forza = forza;}
	public int getAttacco() {return attacco;}
	public void setAttacco(int attacco) {this.attacco = attacco;}
	public int getDifesa() {return difesa;}
	public void setDifesa(int difesa) {this.difesa = difesa;}
	public int getEsperienza() {return esperienza;}
	public void setEsperienza(int esperienza) {this.esperienza = esperienza;}
	public Mappa getLuogo() {return luogo;}
	public void setLuogo(Mappa luogo) {this.luogo = luogo;}
	public Oggetto getOggettoInPos(int pos) {return inventario.get(pos);}
	public void setPersonaggio(char pedina)	{this.pedina = pedina;}
	public char getPersonaggioSx()	{return pedina;}
	public int getPosizioneX() {return posizioneX;}
	public void setPosizioneX(int posizioneX) {this.posizioneX = posizioneX;}
	public int getPosizioneY() {return posizioneY;}
	public void setPosizioneY(int posizioneY) {this.posizioneY = posizioneY;}
	
	public void aggiugiOggetto(Oggetto o, int quantita)
	{
		if(o!=null && quantita>0)	
			inventario.putIfAbsent(quantita, o);
	}
	
	public void rimuoviOggetto(Oggetto ogg, int quantita)
	{
		if(ogg != null)
		{
			int res = inventario.get(ogg).getQuantita() - quantita;
			if(res <= 0)
				inventario.remove(quantita, ogg);
			else
				inventario.replace(res, ogg);
		}
	}
	
	public String getNomeOggetto(Oggetto o)
	{
		if(inventario.containsKey(o))
			return o.getStringInventario();
		else
			return null;
	}

}