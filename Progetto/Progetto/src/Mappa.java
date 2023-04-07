import java.io.*;

public class Mappa
{
	private String mappa = "";
	private char[][] mappaMovimento = new char[14][44];
	private boolean cassePresenti;
	
	public void setCassePresenti(boolean check) {this.cassePresenti = check;}
	public boolean getCassePresenti() {return this.cassePresenti;}
	
	Mappa(String path) throws IOException	{setMappa(path);}
	
	private void setMappa(String path) throws IOException
	{
		FileReader file = new FileReader("mappe\\"+path);
		BufferedReader lettore = new BufferedReader(file);		
		String riga;
		int righe=0;
		
		while(lettore != null && righe<14)
		{
			riga = lettore.readLine();
			mappa += "\t\t"+riga + "\n";
			
			for(int c=0; c<44; c++)
				mappaMovimento[righe][c] = riga.charAt(c);
			
			righe++;
		}
		
		lettore.close();
		file.close();
	}
	
	public String getMappa(){return mappa;}
	public char[][] getMappaMovimento() {return mappaMovimento;}
	
	public String trasformaDaChar(char[][] mappaInChar)
	{
		//TODO:
		/*
		 * trasformare da char a string 
		 */
		return null;
	}
	
	public char[][] trasformaDaString(String mappaInString)
	{
		//TODO:
		/*
		 * trasformare da Strign a char 
		 */
		return null;
	}

}