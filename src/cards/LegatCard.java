package cards;

import user.User;

	/**
	 * @author Andreas
	 */

public class LegatCard extends Card{

	/**
	 * Sets the text for the given card.
	 * @param text
	 */
	
	public LegatCard(String text) {
		super(text);
	}

	/**
	 * Deposits 40.000 into the users account, if he's totalUserValue is less than 15.000
	 */
	
	@Override
	public void drawnCard(User user) {
		if(user.getTotalUserValue() < 15000){
			user.deposit(40000);
		}
		
	}

}
