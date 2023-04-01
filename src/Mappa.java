import java.io.*;

public class Mappa
{
	private String mappa = "";
	private boolean cassePresenti;
	
	public void setCassePresenti(boolean check) {this.cassePresenti = check;}
	public boolean getCassePresenti() {return this.cassePresenti;}
	
	Mappa(String path) throws IOException	{setMappa(path);}
	
	private void setMappa(String path) throws IOException
	{
		FileReader file = new FileReader("mappe\\"+path);
		BufferedReader lettore = new BufferedReader(file);		
		String riga;
		int cnt=0;
		
		while(lettore != null && cnt<14)
		{
			riga = lettore.readLine();
			mappa += "\t\t"+riga + "\n";
			cnt++;
		}
		
		//System.out.println(mappa);
		lettore.close();
		file.close();
	}
	
	public String getMappa()
	{
		return mappa;
	}

}