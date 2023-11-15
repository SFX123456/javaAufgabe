import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class Controller 
{
	private GUI gui;
	private DefaultListModel<Artikel> listLeft;
	private DefaultListModel<Artikel> listRight;
	private static int bestellNummer = 1;
	public Controller()
	{
		gui = new GUI();
		setIcon();
		listLeft = Reader.getArtikel();
		listRight = new DefaultListModel<Artikel>();
		setModels(listLeft, listRight);
		setUpEventHandlers();
		
	}
	
	private void setModels(DefaultListModel<Artikel> listLeft, DefaultListModel<Artikel> listRight)
	{
		gui.getListLeft().setModel(listLeft);
		gui.getListRight().setModel(listRight);
	}
	
	private void setIcon()
	{
		ImageIcon imageIcon = new ImageIcon("./bin/nozamaLogo.png");
		gui.getLblNewLabel().setIcon(imageIcon);
	}
	
	private void setUpEventHandlers()
	{
		ActionListener rightClicked = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				var artikelRight = (Artikel) gui.getListRight().getSelectedValue();
				listLeft.addElement(artikelRight);
				listRight.removeElement(artikelRight);
				
			}
	
		};
		
		ActionListener leftClicked = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				var artikelLeft = (Artikel) gui.getListLeft().getSelectedValue();
				listRight.addElement(artikelLeft);
				listLeft.removeElement(artikelLeft);
				
			}
	
		};
		
		ActionListener bestellungButton = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				bestellen();
				
			}
	
		};
		
		
		gui.getBtnLeft().addActionListener(leftClicked);
		gui.getBtnRight().addActionListener(rightClicked);
		gui.getButonBestellung().addActionListener(bestellungButton);
	}
	
	private void bestellen()
	{
		String kundenName = gui.getTextFieldKundenname().getText();
		String path = "./bin/" + kundenName + bestellNummer + ".txt";
		bestellNummer++;
		File file = new File(path);
		PrintWriter writer;
		try
		{
			FileWriter fw = new FileWriter(file);
			writer = new PrintWriter(fw);
			writer.println("Artikelnummer; Artikelbezeichnung; Preis;");
			for(int i = 0; i < listRight.getSize(); i++)
			{
				String artikelStr = listRight.get(i).fileStorageString();
				writer.println(artikelStr);
			}
			writer.close();
		}
		catch(Exception e)
		{
			System.out.println("Couldnt create File");
		}
	}
	
	
}
