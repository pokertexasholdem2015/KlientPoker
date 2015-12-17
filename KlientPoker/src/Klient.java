import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Klient {
	
	static Socket socket = null;
	static PrintWriter dane_wychodzace = null;
	static BufferedReader dane_przychodzace = null;
	boolean polaczenie = false;
	
	
	void zamknijPolaczenie()
	{
		try {
			System.out.println("Polaczenie zamkniete.");
			socket.close();
			dane_wychodzace.close();
			dane_przychodzace.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}

	
	boolean laczZserwerem(String ip, int port){
		try{
			socket = new Socket(ip,port);
			dane_przychodzace = new BufferedReader (new InputStreamReader (socket.getInputStream()));
			dane_wychodzace = new PrintWriter (socket.getOutputStream(), true);	
			polaczenie = true;
			return true;
		}
		catch(IOException e)
		{
			System.out.println ("Nie udalo sie podlaczyc");
			return false;
			//System.exit(0);
		}
	}
	
	public String odczytajDane(){
		if(!polaczenie) return "Brak polaczenia";
		try{
			return dane_przychodzace.readLine();
		}
		catch(IOException e){
			//socket.close();
			polaczenie = false;
			return "Polaczenie zostalo przerwane";
			//System.exit(0);
		}
		//return "Error";
	}
	
	public boolean wyslijDane(String mssg){
		if(polaczenie)
			dane_wychodzace.println(mssg);

		return false;
		}
			
		
}