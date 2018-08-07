package engine.components.cardmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The Deck is used to store Cards
 * @author sasszem
 *
 */
public class Deck {
	private List<Card> cards;

	private String name;
	
	private static Logger LOGGER = Logger.getLogger("CardManager][Deck");
	
	public Deck(String name) {
		this.cards = new ArrayList<Card>();
		this.name =name;
	}

	/**
	 * Add a Card to the Deck
	 * @param card the Card to add
	 */
	public void addCard(Card card)
	{
		this.cards.add(card);
		Deck.LOGGER.info("Added Card#"+card.getId()+" to Deck \""+this.name+"\"");
	}
	
	/**
	 * Remove a Card from the Deck 
	 * @param card the Card to remove
	 */
	public void removeCard(Card card)
	{
		this.cards.remove(card);
		Deck.LOGGER.info("Removed Card#"+card.getId()+" from Deck \""+this.name+"\"");

	}

	public String getName() {
		return name;
	}

	public List<Card> listCards() {
		// TODO Auto-generated method stub
		return this.cards;
	}
}
