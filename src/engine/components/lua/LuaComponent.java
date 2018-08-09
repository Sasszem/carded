/**
 * 
 */
package engine.components.lua;

import engine.Component;
import engine.Message;
import engine.MessageBus;

/**
 * @author laci
 *
 */
public class LuaComponent extends Component {

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

	}

}
