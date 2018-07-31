package engine.components.cardmanager;

import java.util.HashMap;

public class Card {
	private Deck deck;
	private Integer id;
	private HashMap<String, String> attributes;
	private Boolean created = false;
	
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	public Deck getDeck()
	{
		return this.deck;
	}
	
	public String getAttribute(String key)
	{
		return this.attributes.get(key);
	}

	public Card(Integer id) {
		super();
		this.id = id;
		this.attributes = new HashMap<String, String>();
	}
	
	public Integer getId()
	{
		return this.id;
	}

	public void setAttribute(String key, String value) throws CardException {
		if (!this.created)
		{
			this.attributes.put(key, value);
		}
		else
		{
			throw new CardException("Creation of Card#"+this.id+" is already over, attributes field is not writeable!");
		}
	}

	public void finishCreation() {
		// TODO Auto-generated method stub
		
	}
	public void moveTo(Deck deck)
	{
		this.deck.removeCard(this);
		deck.addCard(this);
		this.setDeck(deck);
	}
}
