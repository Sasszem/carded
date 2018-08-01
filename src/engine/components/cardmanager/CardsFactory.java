package engine.components.cardmanager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * CardsFactory loads and parses the contents of a Card descriptor file, creates the cards and places them in a Deck
 * @author sasszem
 *
 */
public class CardsFactory {
	
	private static int id = 1;
	
	/**
	 * Loads the contents of a card description file, creates the described Cards and inserts them into a target Deck
	 * @param path The path to the file to load
	 * @param target The Deck to insert the Cards into
	 * @throws FileNotFoundException when the specified file does not exists 
	 */
	public static void parseFile(String path, Deck target) throws FileNotFoundException
	{		
		// Load JSON
		JSONTokener tokener = new JSONTokener(new FileReader(path));
		JSONArray data = new JSONArray(tokener);
		
		for (Object rawCardData: data)
		{
			JSONObject cardData = (JSONObject) rawCardData;
			
			Card card = new Card(id++);
			
			for (String key: cardData.keySet())
			{
				try {
					card.setAttribute(key, (String)cardData.get(key));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CardException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			card.finishCreation();
			target.addCard(card);
		}
	}
}
