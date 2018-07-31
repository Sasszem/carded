package engine.components.cardmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import engine.Component;
import engine.Message;

public class CardManager extends Component {

	private HashMap<String, Deck> decks;

	private static boolean initiated = false;
	private static Logger LOGGER = Logger.getLogger("CardManager");
	
	private final static String decksPath = "./data/decks.json";
	private final static String cardsPath = "./data/cards.json";
	
	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.type)
		{
			case "init": try {
				this.init();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		}
	}

	private void init() throws Exception {
		if (!initiated)
		{
			LOGGER.info("Initiating...");
			DecksFactory.parseFile(CardManager.decksPath, this.decks);
			CardsFactory.parseFile(CardManager.cardsPath, (Deck) this.decks.values().toArray()[0]);
			initiated = true;
			LOGGER.info("Init complete!");
		}
		else
			throw new Exception("CardManager already initiated");
	}

	public CardManager() {
		super();
		try {
			CardManager.LOGGER.addHandler(new FileHandler("./logs/cardManager.log", true));
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.decks = new HashMap<String, Deck>();
	}

}