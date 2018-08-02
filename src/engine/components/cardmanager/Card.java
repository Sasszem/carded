package engine.components.cardmanager;

import java.util.HashMap;
import java.util.logging.Logger;


/**
 * The Card type is used to store the attributes of a single card. Cards are stored in Decks
 * @author sasszem
 *
 */
public class Card {
	private Deck deck;
	private Integer id;
	private HashMap<String, String> attributes;
	private Boolean created = false;
	
	private static Logger LOGGER = Logger.getLogger("CardManager][Card");
	
	/**
	 * Set the current Deck the Card is in. Used when moving a Card from one deck to another
	 * @param deck - the new Deck
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	/**
	 * Get the current Deck the Card is in. Used when moving a Card from one deck to another
	 * @return the current deck the card is in
	 */
	public Deck getDeck()
	{
		return this.deck;
	}
	
	/**
	 * 
	 * @param key the name of the quarried attribute
	 * @return the attribute as a String
	 */
	public String getAttribute(String key)
	{
		return this.attributes.get(key);
	}

	/**
	 * Create a new Card. Should only be called from CardsFactory
	 * @param id the new Card's id
	 */
	public Card(Integer id) {
		super();
		this.id = id;
		this.attributes = new HashMap<String, String>();
		Card.LOGGER.info("New Card created with ID "+id);
	}
	
	/**
	 * Get the Card's ID
	 * @return the card's id
	 */
	public Integer getId()
	{
		return this.id;
	}

	/**
	 * Set the Card's attributes. Should be only called from CardsFactory, during the Card creation.
	 * @param key name of the attribute
	 * @param value value of the attribute
	 * @throws CardException if you try to set attributes of an already created card
	 */
	public void setAttribute(String key, String value) throws CardException {
		if (!this.created)
		{
			this.attributes.put(key, value);
			Card.LOGGER.info("Set \""+key +"\" attribute of Card#"+this.id+" to "+value);
		}
		else
		{
			Card.LOGGER.severe("Attempted to write the attributes of a finished Card!");
			throw new CardException("Creation of Card#"+this.id+" is already over, attributes field is not writeable!");
		}
	}

	/**
	 * End the creation of the card. Makes the card's attributes read-only(except the Deck)
	 */
	public void finishCreation() {
		// TODO Auto-generated method stub
		this.created = true;
		Card.LOGGER.info("Finished the creation of Card#"+this.id);
	}
	
	/**
	 * Move the Card from its current Deck to another
	 * @param deck the target Deck
	 */
	public void moveTo(Deck deck)
	{
		this.deck.removeCard(this);
		String oldName = this.deck.getName();
		deck.addCard(this);
		this.setDeck(deck);
		Card.LOGGER.info("Moved Card#"+id+" from Deck \""+oldName+"\" to Deck \""+deck.getName()+"\"");
	}
}
