package cards;

import user.User;

public class FineCard extends Card {
	private int amount;
	
	public FineCard(String text, int amount){
		super(text);
		this.amount = amount;
	}

	@Override
	public void drawnCard(User user) {
		user.withdraw(amount);
		
	}

}
