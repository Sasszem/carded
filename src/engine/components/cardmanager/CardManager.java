package engine.components.cardmanager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import engine.Component;
import engine.Message;
import engine.MessageBus;
import engine.messages.DataQuery;
import engine.messages.QueryResponse;


/**
 * The CardManager Component is responsible for Card data storage, retrieval and manipulation
 * @author sasszem
 *
 */
public class CardManager extends Component {

	
	/**
	 * The Decks, stored by their name
	 */
	private HashMap<String, Deck> decks;

	private MessageBus MESSAGEBUS;
	
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
			case "DataQuery":
				this.handleDataQuery(msg);
				break;
		
		}
	}

	private void handleDataQuery(Message msg) {
		DataQuery query = (DataQuery)msg;
		List<String> url = Arrays.asList(query.url.split("[.]"));
		System.out.println(query.toString()+url.toString());
		System.out.println(url.get(0));
		System.out.println(url.get(1));
		if (Objects.equals(url.get(0),"CM"))
		{

			switch (url.get(1))
			{
				case "decksList":
					List<String> data = new ArrayList<String>(this.decks.keySet());
					QueryResponse<List<String>> response = new QueryResponse<List<String>>(data, query.getId());
					this.MESSAGEBUS.sendMessage(response);
				break;
			}
		}
	}

	private void init() throws Exception {
		if (!initiated)
		{
			LOGGER.info("Initiating...");
			DecksFactory.parseFile(CardManager.decksPath, this.decks);
			
			Deck firstDeck = (Deck) this.decks.values().toArray()[0];
			
			CardsFactory.parseFile(CardManager.cardsPath, firstDeck);
			
			initiated = true;
			LOGGER.info("Init complete!");
		}
		else
			throw new Exception("CardManager already initiated");
	}

	
	public CardManager(MessageBus msgb) {
		super();
		this.MESSAGEBUS = msgb;
		msgb.registerComponent(this, "CM");
		this.decks = new HashMap<String, Deck>();
	}

}
