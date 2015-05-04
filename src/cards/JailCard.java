package cards;

import user.User;

public class JailCard extends Card{

	public JailCard (String text){
		super(text);
	}
	@Override
	public void drawnCard(User user) {
		if(user.getFreeJailCards() < 3){
		user.setFreeJailCards(user.getFreeJailCards()+1);
		}
	}

}
