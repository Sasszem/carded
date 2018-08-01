package engine;

/**
 * A Component which connects to the MessageBus, sends and receives messages
 * @author sasszem
 *
 */
public abstract class Component {

	
	/**
	 * Handle a single Message
	 * @param msg the message to handle
	 */
	public abstract void handleMessage(Message msg);

}
