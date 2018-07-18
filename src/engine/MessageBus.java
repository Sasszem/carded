package engine;

import java.util.HashMap;

public class MessageBus {
	
	HashMap<String, Component> components;
	
	
	
	public MessageBus() {
		this.components = new HashMap<String, Component>();
	}

	public void registerComponent(Component comp, String name)
	{
		this.components.put(name, comp);
	}
	
	public void sendMessage(Message msg)
	{
		for (Component com: components.values() )
		{
			com.handleMessage(msg);
		}
	}
}
