import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import engine.Message;
import engine.MessageBus;
import engine.components.Commandline;
import engine.components.cardmanager.CardManager;


/**
 * @author sasszem
 * The main class of the app.
 */
public class Main {

	static {
	      InputStream stream;
		try {
			stream = new FileInputStream("./logging.properties");
			LogManager.getLogManager().readConfiguration(stream);

		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Logger LOGGER = Logger.getLogger("Main");
	
	public Main() {
	}

	public void mainLoop()
	{
		MessageBus msgBus = new MessageBus();
		Commandline cmd = new Commandline(msgBus);
		new CardManager(msgBus);
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		
		Main.LOGGER.info("Init complete, entering main loop...");
		
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
		m.mainLoop();
	}

}
