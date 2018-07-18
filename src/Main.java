import java.util.Scanner;

import engine.Message;
import engine.MessageBus;
import engine.components.Commandline;

/**
 * 
 */

/**
 * @author laci
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
		MessageBus msgBus = new MessageBus();
		Commandline cmd = new Commandline();
		msgBus.registerComponent(cmd, "cmd");
		
		Scanner s = new Scanner(System.in);
		
		while (true)
		{
			msgBus.sendMessage(new Message(s.nextLine()));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
	}

}
