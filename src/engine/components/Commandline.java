package engine.components;

import engine.Message;
import engine.MessageBus;
import engine.messages.DataQuery;
import engine.Component;

/**
 * The Commandline component prints all messages it receives, and sends messages entered in it.
 * @author sasszem
 *
 */
public class Commandline extends Component {
		
	public Commandline(MessageBus bus) {
		super(bus);
		bus.registerComponent(this, "Commandline");
	}
	
	public void handleMessage(Message msg)
	{
		//System.out.println(msg.type);
	}
	
	public void parseLine(String[] line)
	{
		Message msg = this.parseMessage(line);
		this.MESSAGEBUS.sendMessage(msg);
	}
	public Message parseMessage(String[] line)
	{
		switch(line[0])
		{
		case "GET":
			DataQuery msg = new DataQuery(line[1]);
			return msg;
		default:
			return new Message(line[0]);
		}
	}
}
