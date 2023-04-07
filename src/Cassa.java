import java.util.*;

public class Cassa implements Apribile
{	
	//cambia da arraylista a hasmap -- vedi Personaggio
	private HashMap<Integer,Oggetto> oggetti;
	private Mappa posizione;
	
	Cassa(Mappa posizione)
	{
		this.posizione = posizione;
		oggetti = new HashMap<Integer, Oggetto>();
	}
	
	public void removeOggetto(Oggetto og) {oggetti.remove(og);}
	public Mappa getPosizione() {return posizione;}
	public void setPosizione(Mappa posizione) {this.posizione = posizione;}
	public Oggetto getOggettoInPos(int pos) {return oggetti.get(pos);}

	public void aggiugiOggetto(Oggetto o, int quantita)
	{
		if(o!=null && quantita>0)	
			oggetti.putIfAbsent(quantita, o);
	}
	
	public void rimuoviOggetto(Oggetto ogg, int quantita)
	{
		if(ogg != null)
		{
			int res = oggetti.get(ogg).getQuantita() - quantita;
			if(res == 0)
				oggetti.remove(quantita, ogg);
			else
				oggetti.replace(res, ogg);
		}
	}
	
	public String getNomeOggetto(Oggetto o)
	{
		if(oggetti.containsKey(o))
			return o.getStringInventario();
		else
			return null;
	}
	
	@Override
	public void apri() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void chiudi() {
		// TODO Auto-generated method stub
		
	}
	
}