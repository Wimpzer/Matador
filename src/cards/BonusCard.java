package cards;

import user.User;

public class BonusCard extends Card {
	private int amount;

	public BonusCard(String text, int amount) {
		super(text);
		this.amount = amount;
	}

	@Override
	public void drawnCard(User user) {
		user.deposit(amount);	
	}

}
