package engine.components;

import engine.Message;
import engine.Component;

/**
 * The Commandline component prints all messages it receives, and sends messages entered in it.
 * @author sasszem
 *
 */
public class Commandline extends Component {

	public Commandline() {
		// TODO Auto-generated constructor stub
	}
	
	public void handleMessage(Message msg)
	{
		System.out.println(msg.type);
	}
	
	public Message parseMessage(String[] line)
	{
		if (line[0].equals("init"))
			return new Message("init");
		return null;
	}
}
