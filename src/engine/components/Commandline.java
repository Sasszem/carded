package engine.components;

import engine.Message;
import engine.Component;

public class Commandline extends Component {

	public Commandline() {
		// TODO Auto-generated constructor stub
	}
	
	public void handleMessage(Message msg)
	{
		System.out.println(msg.type);
	}
}
