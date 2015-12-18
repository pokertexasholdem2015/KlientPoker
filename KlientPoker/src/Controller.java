import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;




public class Controller { 

	private static View View;
	private  Klient Model;
	
	private String dane_do_wyslania = "";
	private int dane_do_wyslania2 = 0;
	
	private String dane_do_odczytania = "";
	private String dane_do_odczytania2 = "";
	
	private String[] linia1;
	private String[] linia2;
	
	private ArrayList<String> lista_wiadomosci = new ArrayList<String>();
	
	private String staty;
	
	
	Controller(){
		View = new View();
		View.setVisible(true);
		Model = new Klient();
		
		// sluchaj przyciskow
		
		
		View.przycisk_allin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doAction(2, "");
			}
		});
		View.przycisk_raise.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(View.ileraise.getText().isEmpty() || View.ileraise.getText().equals("do ilu?"))
					View.ileraise.setBackground(new Color(255,36,0)); //255;36;0
				else
					doAction(4, View.ileraise.getText());
			}
		});
		View.przycisk_fold.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doAction(5, "");
			}
		});
		
		View.przycisk_polacz.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(View.Adres_IP.getText().isEmpty()) View.Adres_IP.setText("Wpisz adres serwera.");//setTextFieldMssg("Wpisz adres serwera.");
				else
					doAction(10, View.Adres_IP.getText());
			}
		});
		
		View.przycisk_bet.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(View.ilebet.getText().isEmpty() || View.ilebet.getText().equals("ile?"))
					View.ilebet.setBackground(new Color(255,36,0)); //255;36;0
				else
					doAction(3, View.ilebet.getText());
			}
		});
		
		View.przycisk_check.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doAction(6, "");
			}
		});
		
		View.przycisk_call.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doAction(7, "");
			}
		});
		// sluchaj menubaru 
		
		View.itemWyjscie.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Model.polaczenie)
					Model.zamknijPolaczenie();
				View.dispose();
			}
		});
		
		View.itemZasady.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String wiadomosc="Zasady Gry Poker \n Dostajesz 2 karty do reki \n nastepne beda sie pojawiac na stole	\n Umiejetna ocena kart moze zagwarantowac sukces \n Mozliwe Uklady (od najnizszego) :\n 1: Najwyzsza Karta\n 2: Para\n 3: Dwie Pary\n 4: Trojka\n 5: Strit\n 6: Kolor\n 7: Full\n 8: Kareta\n 9: Poker\n po wiecej informacji o ukladach odwiedz odpowiednia strone np. na Wikipedii :)\n\n ";
				View.userInfoMassage1(wiadomosc);
				
			}
		});
		
		View.itemOgrze.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String wiadomosc="Java Poker \n Version 1.0 ";
				View.userInfoMassage1(wiadomosc);
				
			}
		});
		
		View.itemLog.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Model.polaczenie) 
					Model.wyslijDane("pokazstat ");
				View.userInfoMassage1(staty);
				
			}
		});
		
		// sluchaj czy mysz wcisnieta w pole tekstowe
		
		View.ileraise.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				View.ileraise.setBackground(Color.WHITE);
			    View.ileraise.setText("");
			  }
		});
		
		View.ilebet.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				View.ilebet.setBackground(Color.WHITE);
			    View.ilebet.setText("");
			  }
		});
		
		// sluchanie zamykania okna
		
		View.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				if(Model.polaczenie)
					Model.zamknijPolaczenie();
			}
		});
	}
	
	
	/*
	 * 1 - empty so far
	 * 2 - allin
	 * 3 - bet
	 * 4 - raise
	 * 5 - fold
	 * 10 - polacz
	 */
	public void doAction(int state, String param)
	{
		if(Model.polaczenie){
			if(state == 1)
			{
				// Musi dzialac zawsze po rundzie - Wyswietlanie kolejnych kart na stole 
				
				//Model.wyslijDane("Stolpokazkarty ");
			
				// Empty 
			
			}
			else if(state == 2)
			{
				Model.wyslijDane("allin ");
				Model.wyslijDane("pokazzetony ");
			
				Model.wyslijDane("Stolpokazkarty ");
			}
			else if(state == 3)
			{
				Model.wyslijDane("bet "+param);
				Model.wyslijDane("pokazzetony ");
				Model.wyslijDane("Stolpokazkarty ");
			}
			else if(state == 4)
			{
				Model.wyslijDane("raise "+param);
				Model.wyslijDane("pokazzetony ");
				Model.wyslijDane("Stolpokazkarty ");
			}
			else if(state == 5)
			{
				Model.wyslijDane("fold ");
				Model.wyslijDane("pokazzetony ");
				Model.wyslijDane("Stolpokazkarty ");
			}
			else if(state == 6)
			{
				Model.wyslijDane("check ");
				
				Model.wyslijDane("Stolpokazkarty ");
			}
			else if(state == 7)
			{
				Model.wyslijDane("call ");
				Model.wyslijDane("pokazzetony ");
				Model.wyslijDane("Stolpokazkarty ");
			}
		}
		if(state == 10)
		{
			if(Model.laczZserwerem(param, 3535))
			{
				Thread t = new Thread(new Runnable()  
				{  
					public void run()  
					{
						while(Model.polaczenie)
						{
							dane_do_odczytania = Model.odczytajDane();
							if(dane_do_odczytania.startsWith("MSG"))
							{
								dane_do_odczytania2 = dane_do_odczytania.substring(4);
								setTextFieldMssg(dane_do_odczytania2);
							}
							else if(dane_do_odczytania.startsWith("ZET"))
							{
								View.zetony2.setText(dane_do_odczytania.substring(4));
							}
							else if(dane_do_odczytania.startsWith("KRT"))
							{
								dane_do_odczytania2 = dane_do_odczytania.substring(4);
								linia1 = dane_do_odczytania2.split(" ");
								for(int i = 0; i < linia1.length; i++)
								{
									linia2 = linia1[i].split("/");
									View.setIcon(i, View.imgKartyURL[((13*Integer.parseInt(linia2[0]))+Integer.parseInt(linia2[1]))]);
								}
							}
							else if(dane_do_odczytania.startsWith("KRT2"))
							{
								dane_do_odczytania2 = dane_do_odczytania.substring(4);
								linia1 = dane_do_odczytania2.split(" ");
								for(int i = 0; i < linia1.length; i++)
								{
									linia2 = linia1[i].split("/");
									View.setIcon2(i, View.imgKartyURL[((13*Integer.parseInt(linia2[0]))+Integer.parseInt(linia2[1]))]);
								}
							}
							
							else if(dane_do_odczytania.startsWith("CMD"))
							{
								if(dane_do_odczytania.startsWith("CMD START"))
								{
									
									Model.wyslijDane("pokazkarty ");
									Model.wyslijDane("pokazzetony ");
									Model.wyslijDane("pokazstat ");
								}
								else if(dane_do_odczytania.startsWith("CMD START2"))
								{
									Model.wyslijDane("Stolpokazkarty");
								}
							}
							else if(dane_do_odczytania.startsWith("STA"))
							{
								staty = dane_do_odczytania.substring(4);
								staty = staty.replace("[t]", "\t");
								staty = staty.replace("[n]", "\n");
								System.out.println(staty);
							}
							// obsluga wiadomosci przychodzacych
						}
					}
				});
				t.start();
				View.Adres_IP.setBackground(new Color(50,205,50)); // 50;205;50
				View.setBackground(new Color(50,205,50));
				View.przycisk_polacz.setEnabled(false);
			}
			else
				setTextFieldMssg("Nie mozna polaczyc sie z serwerem.");
		}
	}
	
	public void setTextFieldMssg(String mssg){
	
		int index = 68;
		StringBuilder br = new StringBuilder();
		if(lista_wiadomosci.size() == 13)
			lista_wiadomosci.remove(0);
		if(mssg.length() > 68)
		{
			while(mssg.charAt(index) != ' ')
				index--;
		}
		if(index < 68) lista_wiadomosci.add(mssg.substring(0, index));
		else
			lista_wiadomosci.add(mssg);
		for(int i=0; i < lista_wiadomosci.size(); i++)
		{
			br.append(lista_wiadomosci.get(i)+"<br>");
		}
		View.wyniki.setText(br.toString());
		if(index < 68) setTextFieldMssg(mssg.substring(index+1, mssg.length()-1));
	}

	public static void main(String[] args)
	{
		new Controller();
		
	}
}