public class Artikel {
	private int artikelNummer;
	private String artikelBeziechnung;
	private double preis;
	private char waehrung;
	
	
	public Artikel(int artikelNummer, String artikelBeziechnung, double preis, char waehrung)
	{
		this.artikelNummer = artikelNummer;
		this.artikelBeziechnung = artikelBeziechnung;
		this.preis = preis;
		this.waehrung = waehrung;
	}
	
	public String toString()
	{
		return artikelBeziechnung + " " + String.format("%.2f", preis) + waehrung;
	}
	
	public String fileStorageString()
	{
		String preisStr = String.format("%.2f", preis).replace('.', ',');
		return artikelNummer + "; " + artikelBeziechnung + "; " + preisStr + " " + waehrung + ";";
	}
}
