/**
 * 
 */
package engine.components.cardmanager;

/**
 * @author sasszem
 *
 */
public class CardException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6336609439491245397L;

	/**
	 * 
	 */
	public CardException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public CardException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CardException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CardException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
