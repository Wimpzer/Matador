package cards;

import game.Controller;
import user.User;

public class BirthdayCard extends Card{
	private int giftAmount = 200;
	
	public BirthdayCard(String text) {
		super(text);
	}

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
