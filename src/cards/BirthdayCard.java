package cards;

import user.User;

public class BirthdayCard extends Card{
	private int giftAmount;
	
	public BirthdayCard(String text) {
		super(text);
	}

	@Override
	public void drawnCard(User user) {
		// TODO Hent antallet af spillere, gør igennem User array og træk 200,- fra hver.
//		user.deposit(giftAmount * users.length);
//		for(int y: users)
	}
	
	

}
