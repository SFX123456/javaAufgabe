import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.DefaultListModel;


public class Reader {

	public static DefaultListModel<Artikel> getArtikel()
	{
		File file = new File("./bin/ArtikeldateiNozama.txt");
		DefaultListModel<Artikel> list = new DefaultListModel<Artikel>();
        	try
	        {
        		Scanner sc = new Scanner(new FileReader(file));
            		sc.nextLine();
            		String str;
            		while(sc.hasNextLine())
	            	{
            			str = sc.nextLine();
                		String[] arr = str.split(";");
                		int artikelNummer = Integer.parseInt(arr[0]);
                		String artikelBezeichnung = arr[1].trim();
                		int index = arr[2].indexOf(",");
                		char waehrung = arr[2].charAt(index + 4);
                		String preisMitKomma = arr[2].replace(',','.');
                		double preis =Double.valueOf(preisMitKomma.substring(1,index +2)).doubleValue();
                		Artikel artikel = new Artikel(artikelNummer, artikelBezeichnung, preis, waehrung);
                		list.addElement(artikel);
            		}
            		sc.close();
        	} 
		catch (FileNotFoundException e) 
		{
            	System.out.println("Konnte Datei nicht finden");
        	}
        
       
        	return list;
	}
}
