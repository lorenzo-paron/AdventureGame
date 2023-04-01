//import javax.swing.Icon;

public class Oggetto
{
	private String nome;
	private Items item;
	//private Icon icone;
	
	Oggetto(String nome, Items item)//, String percorsoIcona)
	{
		this.nome = nome;
		this.item = item;
	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public Items getItem() {return item;}
	public void setItem(Items i) {this.item = i;}
	
}