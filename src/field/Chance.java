package field;

import game.CardPile;
import user.User;

public class Chance extends Field {

	public Chance(int fieldNumber, String name) {
		super(name);
		this.fieldNumber = fieldNumber;
	}

	@Override
	public void landOnField(User user) {
		CardPile.drawCard();
	}

}
