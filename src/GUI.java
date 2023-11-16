import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldKundenname;
	private JButton butonBestellung;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JList listLeft;
	private JList listRight;
	
	public JLabel getLblNewLabel() 
	{
		return lblNewLabel;
	}

	public JTextField getTextFieldKundenname() 
	{
		return textFieldKundenname;
	}

	public JButton getBtnLeft() 
	{
		return btnNewButton;
	}

	public JButton getBtnRight() 
	{
		return btnNewButton_1;
	}
	
	protected JList getListLeft() 
	{
		return listLeft;
	}
	
	protected JList getListRight() 
	{
		return listRight;
	}
	
	protected JButton getButonBestellung() 
	{
		return butonBestellung;
	}


	public GUI() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textBoxWarenkorb = new JLabel("Warenkorb");
		textBoxWarenkorb.setBounds(322, 38, 87, 14);
		contentPane.add(textBoxWarenkorb);
		
		btnNewButton = new JButton("buttonRight");
		btnNewButton.setBounds(180, 104, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("buttonLeft");
		btnNewButton_1.setBounds(180, 152, 89, 23);
		contentPane.add(btnNewButton_1);
		
		listLeft = new JList();
		listLeft.setBounds(5, 106, 170, 92);
		contentPane.add(listLeft);
		
		listRight = new JList<Artikel>();
		listRight.setBounds(300, 104, 170, 100);
		contentPane.add(listRight);
		
		JLabel labelKundenname = new JLabel("Kundenname");
		labelKundenname.setBounds(52, 209, 71, 14);
		contentPane.add(labelKundenname);
		
		textFieldKundenname = new JTextField();
		textFieldKundenname.setBounds(134, 206, 86, 20);
		contentPane.add(textFieldKundenname);
		textFieldKundenname.setColumns(10);
		
		butonBestellung = new JButton("Bestellung abschicken");
		butonBestellung.setBounds(268, 205, 156, 23);
		contentPane.add(butonBestellung);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(5, 5, 300, 90);
		contentPane.add(lblNewLabel);
		setVisible(true);
	}

}
