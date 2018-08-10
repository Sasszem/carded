/**
 * 
 */
package engine.components.lua;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import engine.Component;
import engine.Message;
import engine.MessageBus;

/**
 * @author laci
 *
 */
public class LuaComponent extends Component {

	private static final String LUA_FILE_NAME = "./data/main.lua";
	
	private Globals globals = JsePlatform.standardGlobals();
	
	/**
	 * @param mESSAGEBUS
	 */
	public LuaComponent(MessageBus mESSAGEBUS) {
		super(mESSAGEBUS);
		this.MESSAGEBUS.registerComponent(this, "lua");
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see engine.Component#handleMessage(engine.Message)
	 */
	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.type)
		{
		case "init":
			this.init();
			break;
		case "mainLoop":
			this.mainLoop();
			break;
		}
	}
	
	private void init()
	{
		globals.get("dofile").call(LuaComponent.LUA_FILE_NAME);
	}
	
	private void mainLoop()
	{
		LuaValue mainLoop = globals.get("mainLoop");
		mainLoop.call();
	}
 
}
