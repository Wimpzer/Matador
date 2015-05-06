package cards;

import user.User;

	/**
	 * The parent class of the different types of cards.
	 * @author Andreas
	 */

public abstract class Card {
	protected String text;
	
	/**
	 * Constructor that sets the text of the card.
	 * @param text
	 */
	
	public Card(String text){
		this.text = text;
	}
	
	/**
	 * Method which describes what happens when the 
	 * card is drawn. Will be specified in the different
	 * types of cards.
	 * @param user
	 */
	
	abstract public void drawnCard(User user);
	
	/**
	 * Returns the text of the drawncard.
	 * @return
	 */
	
	public String getText(){
		return text;
	}
	
}
