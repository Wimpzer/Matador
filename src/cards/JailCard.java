package cards;

import user.User;

	/**
	 * @author Andreas
	 */

public class JailCard extends Card{

	/**
	 * Sets the text for the given card.
	 * @param text
	 */
	
	public JailCard (String text){
		super(text);
	}
	
	/**
	 * Gives the user an extra freeJailCard, if not already in possession of three.
	 */
	
	@Override
	public void drawnCard(User user) {
		if(user.getFreeJailCards() < 3){
		user.setFreeJailCards(user.getFreeJailCards()+1);
		}
	}

}
