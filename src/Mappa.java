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
		String s = "";
		for(int i = 0; i<14; i++) {
			for(int c = 0; c<44; c++) {
				s+=mappaMovimento[i][c];
			}
		}
		return s;
	}
	
	public char[][] trasformaDaString(String mappaInString)
	{
		int cnt = 0;
		char[][] mappaMovimento = new char[14][44];
		for(int i = 0; i<14; i++) {
			for(int c = 0; c<44; c++) {
				mappaMovimento[i][c] = mappaInString.charAt(cnt);
				cnt++;
			}
		}
		return mappaMovimento;
	}

}