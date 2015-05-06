package cards;

import game.Controller;
import user.User;

/**
 * @author Andreas
 */

public class BirthdayCard extends Card{
	private int giftAmount = 200;
	
	/**
	 * Sets the text for the given card.	
	 * @param text
	 */
	
	public BirthdayCard(String text) {
		super(text);
	}

	/**
	 * Deposits the giftAmount times the number of players, minus the user it self,
	 * into the users account.
	 * Where after it withdraws the giftAmount from each player, except the
	 * user it self.
	 */
	
	@Override
	public void drawnCard(User user) {
		user.deposit(giftAmount * Controller.getUserList().size()-1);
		for(User u: Controller.getUserList()){
			if(u != user){
				u.withdraw(giftAmount);
			}
		}
	}
	
	

}
