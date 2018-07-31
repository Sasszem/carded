package engine.components.cardmanager;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		this.cards = new ArrayList<Card>();
	}

	public void addCard(Card card)
	{
		this.cards.add(card);
	}
	
	public void removeCard(Card card)
	{
		this.cards.remove(card);
	}
}
