package field;

import boundary.GUIBoundary;
import cards.Card;
import game.CardPile;
import user.User;

public class Chance extends Field {

	public Chance(int fieldNumber, String name) {
		super(name);
		this.fieldNumber = fieldNumber;
	}

	@Override
	public void landOnField(User user) {
		Card drawnCard = CardPile.drawCard();
		drawnCard.drawnCard(user);
		GUIBoundary.showMessage(drawnCard.getText());
	}

}
