package engine;

import java.util.HashMap;

/**
 * The single-channel messagebus of the engine.
 * @author sasszem
 *
 */
public class MessageBus {
	
	private HashMap<String, Component> components;
	
	
	
	public MessageBus() {
		this.components = new HashMap<String, Component>();
	}

	/**
	 * Register a new Component to the bus for listening 
	 * @param comp the Component to register
	 * @param name the name of the Component
	 */
	public void registerComponent(Component comp, String name)
	{
		this.components.put(name, comp);
	}
	
	/**
	 * Send a message to all connected Components
	 * @param msg the message to send
	 */
	public void sendMessage(Message msg)
	{
		for (Component com: components.values() )
		{
			com.handleMessage(msg);
		}
	}
}
