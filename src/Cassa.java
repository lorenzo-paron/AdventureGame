import java.util.*;

public class Cassa implements Apribile
{
	private ArrayList<Oggetto> oggetti;
	private Mappa posizione;
	
	Cassa(Mappa posizione)
	{
		this.posizione = posizione;
		oggetti = new ArrayList<Oggetto>();
	}
		
	public ArrayList<Oggetto> getTuttiOggetti() {return oggetti;}
	public Oggetto getOggettoInPos(int pos) {return oggetti.get(pos);}
	public void setOggetto(Oggetto og) {oggetti.add(og);}
	public void removeOggetto(Oggetto og) {oggetti.remove(og);}
	public Mappa getPosizione() {return posizione;}
	public void setPosizione(Mappa posizione) {this.posizione = posizione;}

	@Override
	public void apri() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void chiudi() {
		// TODO Auto-generated method stub
		
	}
	
}