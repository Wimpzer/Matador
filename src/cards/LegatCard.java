package cards;

import user.User;

public class LegatCard extends Card{

	public LegatCard(String text) {
		super(text);
	}

	@Override
	public void drawnCard(User user) {
		if(user.getTotalUserValue() < 15000){
			user.deposit(40000);
		}
		
	}

}
