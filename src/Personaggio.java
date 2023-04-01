import java.util.*;
public class Personaggio
{
	private char pedina;
	private int vita = 50;
	private int forza = 10;
	private int attacco = 5;
	private int difesa = 5;
	private int esperienza = 0;
	private ArrayList<Oggetto> inventario = new ArrayList<Oggetto>();
	private Mappa luogo;
	
	Personaggio(char pedina)
	{
		this.pedina = pedina;
		
	}

	public char getPedina() {
		return pedina;
	}

	public void setPedina(char pedina) {
		this.pedina = pedina;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getForza() {
		return forza;
	}

	public void setForza(int forza) {
		this.forza = forza;
	}

	public int getAttacco() {
		return attacco;
	}

	public void setAttacco(int attacco) {
		this.attacco = attacco;
	}

	public int getDifesa() {
		return difesa;
	}

	public void setDifesa(int difesa) {
		this.difesa = difesa;
	}

	public int getEsperienza() {
		return esperienza;
	}

	public void setEsperienza(int esperienza) {
		this.esperienza = esperienza;
	}

	public ArrayList<Oggetto> getInventario() {
		return inventario;
	}

	public void setInventario(ArrayList<Oggetto> inventario) {
		this.inventario = inventario;
	}

	public Mappa getLuogo() {
		return luogo;
	}

	public void setLuogo(Mappa luogo) {
		this.luogo = luogo;
	}
	
}