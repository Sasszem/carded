package engine;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * The single-channel messagebus of the engine.
 * @author sasszem
 *
 */
public class MessageBus {
	
	private HashMap<String, Component> components;
	private static Logger LOGGER = Logger.getLogger("MessageBus");
	
	
	public MessageBus() {
		this.components = new HashMap<String, Component>();
		MessageBus.LOGGER.info("Creation complete");
	}

	/**
	 * Register a new Component to the bus for listening 
	 * @param comp the Component to register
	 * @param name the name of the Component
	 */
	public void registerComponent(Component comp, String name)
	{
		if (this.components.containsKey(name))
		{
			MessageBus.LOGGER.warning("Overridden already registered component "+name);
		}
		MessageBus.LOGGER.info(String.format("Registered a new component(%s) with name %s", comp.toString(), name));
		this.components.put(name, comp);
	}
	
	/**
	 * Send a message to all connected Components
	 * @param msg the message to send
	 */
	public void sendMessage(Message msg)
	{
		MessageBus.LOGGER.info("[ Message ]"+msg.toString());
		for (Component com: components.values() )
		{
			com.handleMessage(msg);
		}
	}
	
	public void sendMessage(Message msg, String to)
	{
		if (this.components.containsKey(to))
		{
			this.components.get(to).handleMessage(msg);
			MessageBus.LOGGER.info("[ Message ]"+"[ TO: "+to+"]"+msg.toString());
		}
		else
			MessageBus.LOGGER.severe(String.format("[ Message ] No such component %s%n%s",to,new Throwable().getStackTrace()));
	}
	
}
