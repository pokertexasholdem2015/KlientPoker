
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class View extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JMenuBar MenuBar;
	private JMenu menuPlik, menuPomoc; //, menuOpcjeGry
	JMenuItem itemWyjscie, itemOgrze, itemZasady, itemLog; //itemGra1, itemGra2, 

	
	

	
	JTextField ilebet = new JTextField("ile?");
	JTextField ileraise = new JTextField("do ilu?"); 
	JTextPane wyniki = new JTextPane();
	JTextPane Adres_IP = new JTextPane();
	JLabel zetony2 = new JLabel("0");
	private JLabel zetony = new JLabel("Ilosc zetonow:");
 
	private JLabel etykieta2 = new JLabel("Karty na stole");
	private JLabel etykieta3 = new JLabel("Twoje Karty");

	
	
	final String[] imgKartyURL = { "images/1.png","images/2.png","images/3.png","images/4.png","images/5.png","images/6.png","images/7.png","images/8.png",
			 "images/9.png","images/10.png","images/11.png","images/12.png","images/13.png","images/14.png" , "images/15.png",
			 "images/16.png","images/17.png","images/18.png", "images/19.png","images/20.png","images/21.png","images/22.png",
			 "images/23.png","images/24.png","images/25.png", "images/26.png","images/27.png","images/28.png","images/29.png",
			 "images/30.png","images/31.png","images/32.png","images/33.png","images/34.png","images/35.png","images/36.png",
			 "images/37.png","images/38.png","images/39.png","images/40.png","images/41.png","images/42.png","images/43.png",
			 "images/44.png","images/45.png","images/46.png","images/47.png","images/48.png","images/49.png","images/50.png",
			 "images/51.png" , "images/52.png", "images/back.png",  };
	
	private JLabel karty1[] = new JLabel[2];
	private JLabel karty2[] = new JLabel[5];

	
	JButton przycisk_check = new JButton("Check");

	JButton przycisk_allin = new JButton("All-In");
	JButton przycisk_raise = new JButton("Raise");
	JButton przycisk_fold = new JButton("Fold");
	JButton przycisk_polacz = new JButton("Polacz");
	JButton przycisk_bet = new JButton("Bet");
	JButton przycisk_call = new JButton("Call");
	
	JTextArea info = new JTextArea("");
	
	
	View(){
		
		MenuBar = new JMenuBar();
		//menuOpcjeGry = new JMenu("Gra");
		menuPlik = new JMenu("Plik");
		menuPomoc = new JMenu("Pomoc");
		itemLog = new JMenuItem("Statystyki");
		itemZasady = new JMenuItem("Zasady Gry");
		itemOgrze = new JMenuItem("O Grze");
		itemWyjscie = new JMenuItem("Wyjscie");
		//itemGra1 = new JMenuItem("Stworz Boty");
		//itemGra2 = new JMenuItem("gra2");
		
		
		
		
		karty2[0] = new JLabel("", new ImageIcon(imgKartyURL[52]), JLabel.CENTER);
		karty2[1] = new JLabel("", new ImageIcon(imgKartyURL[52]), JLabel.CENTER);
		karty2[2] = new JLabel("", new ImageIcon(imgKartyURL[52]), JLabel.CENTER);
		karty2[3] = new JLabel("", new ImageIcon(imgKartyURL[52]), JLabel.CENTER);
		karty2[4] = new JLabel("", new ImageIcon(imgKartyURL[52]), JLabel.CENTER);
		
		karty1[0] = new JLabel("", new ImageIcon(imgKartyURL[52]), JLabel.CENTER);
		karty1[1] = new JLabel("", new ImageIcon(imgKartyURL[52]), JLabel.CENTER);

		
		this.setJMenuBar(MenuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 750);
		this.setTitle("AWWWWWesome Java Poker");
		this.setLayout(null);
		this.add(etykieta2);
		this.add(etykieta3);
		
		
		
		for(int i = 0; i < 2; i++)
			this.add(karty1[i]);

		
		for(int i = 0; i < 5; i++)
			this.add(karty2[i]);
		
		
		this.add(wyniki);
		this.add(zetony2);
		this.add(zetony);
		this.add(Adres_IP);
		
	
		przycisk_allin.setBounds(600, 420, 108, 32);
		przycisk_raise.setBounds(600, 460, 108, 32);
		przycisk_fold.setBounds(600, 500, 108, 32);
		przycisk_bet.setBounds(600, 540, 108, 32);
		przycisk_check.setBounds(600, 580, 108, 32);
		przycisk_call.setBounds(600, 620, 108, 32);
		this.add(przycisk_call);
		this.add(przycisk_bet);
		this.add(przycisk_allin);
		this.add(przycisk_fold);
		this.add(przycisk_raise);
		this.add(przycisk_check);
		
		przycisk_polacz.setBounds(335, 325, 100, 30);
		this.add(przycisk_polacz);
		
		this.add(ileraise);
		this.ileraise.setBounds(720, 460, 60, 32);
		this.add(ilebet);
		this.ilebet.setBounds(720, 540, 60, 32);
		this.zetony.setBounds(190, 540, 200, 32);
		this.zetony2.setBounds(200, 540, 150, 32);
		this.zetony2.setHorizontalAlignment(SwingConstants.RIGHT);
		this.zetony2.setForeground(Color.RED);
		this.wyniki.setBounds(20, 370, 550, 250);
		this.Adres_IP.setBounds(20, 325, 300, 30);
		this.etykieta2.setBounds(360, 17, 92, 32);
		this.etykieta3.setBounds(650, 250, 92, 32);
	
		
		
		this.karty2[0].setBounds(40, 80, 140, 100);
		this.karty2[1].setBounds(180, 80, 140, 100);
		this.karty2[2].setBounds(320, 80, 140, 100);
		this.karty2[3].setBounds(460, 80, 140, 100);
		this.karty2[4].setBounds(600, 80, 140, 100);
		
		///// karty gracza////
		this.karty1[0].setBounds(560, 290, 140, 100);
		this.karty1[1].setBounds(670, 290, 140, 100);
		
		this.Adres_IP.setBackground(new Color(238,59,59)); // 238;59;59
		
		this.wyniki.setEditable(false);
		this.wyniki.setBackground(Color.BLACK);
		this.wyniki.setContentType("text/html");
		this.wyniki.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
		Font foncik = new Font("Tahoma", Font.BOLD, 15);
		this.wyniki.setFont(foncik);
		this.wyniki.setForeground(Color.red);
		this.add(MenuBar);
		this.setBackground(Color.DARK_GRAY);
		MenuBar.add(menuPlik);
		MenuBar.add(menuPomoc);
		//menuOpcjeGry.add(itemGra1);
		//menuOpcjeGry.add(itemGra2);
		//menuPlik.add(menuOpcjeGry);
		menuPlik.add(itemLog);
		menuPlik.addSeparator();
		menuPlik.add(itemWyjscie);
		menuPomoc.add(itemZasady);
		menuPomoc.add(itemOgrze);
		this.setResizable(false);
		
	}

	
	public void userErrorMassage1(String mssg){
		
		JOptionPane.showMessageDialog(this, mssg , "Error", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void userInfoMassage1(String mssg){
		
		info.setText(mssg);
		info.setBackground(new Color(237,237,237)); // 248;248;255
		JOptionPane.showMessageDialog(this, info , "Info", JOptionPane.INFORMATION_MESSAGE);	
	}
	
	
	public void setIcon(int number, String imageURL)
	{
		if (imageURL != null) {
			this.karty2[number%5].setIcon(new ImageIcon(imageURL));
		}
	}
	
	public void setIcon2(int number, String imageURL)
	{
		if (imageURL != null) {
			this.karty1[number%2].setIcon(new ImageIcon(imageURL));
		}
	}
}
	
	