//import javax.swing.Icon;

public class Oggetto
{
	private String nome;
	private Items item;
	private int quantita = 0;
	//private Icon icone;
	
	Oggetto(String nome, Items item, int quantita)//, String percorsoIcona)
	{
		this.nome = nome;
		this.item = item;
		this.quantita = 0;
	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public Items getItem() {return item;}
	public void setItem(Items i) {this.item = i;}
	public int getQuantita() {return quantita;}
	public void setQuantita(int quantita) {this.quantita = quantita;}

	public String getStringInventario(){return quantita+ " | " + nome + ":" + getItem();}
	
}