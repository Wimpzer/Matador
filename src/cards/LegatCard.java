package cards;

import user.User;

public class LegatCard extends Card{

	public LegatCard(String text) {
		super(text);
	}

	@Override
	public void drawnCard(User user) {
		//TODO getTotalPlayerValue?
//		if(user.getTotalPlayerValue() < 15000){
//			user.deposit(15000);
//		}
		
	}

}
