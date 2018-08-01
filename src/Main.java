import java.util.Scanner;

import engine.Message;
import engine.MessageBus;
import engine.components.Commandline;
import engine.components.cardmanager.CardManager;


/**
 * @author sasszem
 * The main class of the app.
 */
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
		MessageBus msgBus = new MessageBus();
		Commandline cmd = new Commandline();
		CardManager cm = new CardManager();
		msgBus.registerComponent(cmd, "cmd");
		msgBus.registerComponent(cm, "cm");
		Scanner s = new Scanner(System.in);
		
		while (true)
		{
			Message msg = cmd.parseMessage(s.nextLine().split(" ")); 
			if (msg != null)
				msgBus.sendMessage(msg);
		}
	}

	/**
	 * The main function
	 * @param args command-line args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
	}

}
