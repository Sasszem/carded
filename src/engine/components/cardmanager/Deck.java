package engine.components.cardmanager;

import java.util.ArrayList;
import java.util.List;

/**
 * The Deck is used to store Cards
 * @author sasszem
 *
 */
public class Deck {
	private List<Card> cards;

	
	public Deck() {
		this.cards = new ArrayList<Card>();
	}

	/**
	 * Add a Card to the Deck
	 * @param card the Card to add
	 */
	public void addCard(Card card)
	{
		this.cards.add(card);
	}
	
	/**
	 * Remove a Card from the Deck 
	 * @param card the Card to remove
	 */
	public void removeCard(Card card)
	{
		this.cards.remove(card);
	}
}
