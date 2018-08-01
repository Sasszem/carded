package engine;

/**
 * Basic Message class, used in inter-systems communication
 */
public class Message {
	/**
	 * The type of the message, used to determine the handling action
	 */
	public String type;
	
	
	public Message(String type) {
		super();
		this.type = type;
	}
}
