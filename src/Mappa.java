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
				s+="\t\t";
				for(int c = 0; c<44; c++) {
					s+=mappaMovimento[i][c];
				}
				s+="\n";
			}
		
		
		return s;
	}
	
	public char[][] trasformaDaString(String mappaInString, Personaggio p)
	{
		int cnt = 0;
		int posizioneX = p.getPosizioneX();
		int posizioneY = p.getPosizioneY();
		char[][] mappa = new char[14][44];
		for(int i = 0; i<14; i++) {
			for(int c = 0; c<44; c++) {
				while(mappaInString.charAt(cnt) == '\t' || mappaInString.charAt(cnt) == '\n') {
					cnt++;
				}
				mappa[i][c] = mappaInString.charAt(cnt);
				cnt++;
			}
		}
		
		mappa[posizioneY][posizioneX] = ' ';
		mappaMovimento = mappa;
		return mappa;
	}
	
	public char[][] spostaPediana(char[][] mappa, Personaggio p) {

		int posizioneX = p.getPosizioneX();
		int posizioneY = p.getPosizioneY();
		System.out.println(posizioneY + ", "+ posizioneX);
		mappa[posizioneY][posizioneX] = 'P';
		mappaMovimento = mappa;
		return mappa;
	}
	

}