package cards;

import user.User;

/**
 * @author Andreas
 */

public class BonusCard extends Card {
	private int amount;

	/**
	 * Sets the text and amount for the given card.
	 * @param text
	 * @param amount The bonus for the given card.
	 */
	
	public BonusCard(String text, int amount) {
		super(text);
		this.amount = amount;
	}

	/**
	 * Deposits the amount, given to the card, into the users account.
	 */
	
	@Override
	public void drawnCard(User user) {
		user.deposit(amount);	
	}

}
