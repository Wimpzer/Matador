package cards;

import user.User;

	/**
	 * 
	 * @author Andreas
	 */

public class FineCard extends Card {
	private int amount;
	
	/**
	 * Sets the text and amount for the given card.
	 * @param text
	 * @param amount The fine for the given card.
	 */
	
	public FineCard(String text, int amount){
		super(text);
		this.amount = amount;
	}

	/**
	 * Withdraws the amount, given to the card, into the users account.
	 */
	
	@Override
	public void drawnCard(User user) {
		user.withdraw(amount);
		
	}

}
