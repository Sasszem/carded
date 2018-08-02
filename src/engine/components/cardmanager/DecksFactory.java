package engine.components.cardmanager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONTokener;

public class DecksFactory {
	
	/**
	 * Loads the contents of a deck description file, creates the described Decks and inserts them into a target HashMap
	 * @param path The path to the file to load
	 * @param decks The HashMap to insert the decks into
	 * @throws FileNotFoundException when the specified file does not exists 
	 */
	
	private static Logger LOGGER = Logger.getLogger("CardManager][DecksFactory");
	
	public static void parseFile(String path, HashMap<String, Deck> decks) throws FileNotFoundException
	{
		// Load JSON
		JSONTokener tokener = new JSONTokener(new FileReader(path));
		JSONArray data = new JSONArray(tokener);
		
		for (Object deckNameRaw: data)
		{
			String name = (String) deckNameRaw;
			
			Deck deck = new Deck(name);
			
			decks.put(name, deck);
			DecksFactory.LOGGER.info("Created new Deck with name\""+name+"\"");
		}
	}
}
