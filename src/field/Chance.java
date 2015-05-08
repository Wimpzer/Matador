package field;

import boundary.GUIBoundary;
import cards.Card;
import game.CardPile;
import user.User;

	/**
	 * @author Andreas, Bjarke
	 */

public class Chance extends Field {

	/**
	 * Constructor for setting the number and name for the given field.
	 * @param fieldNumber
	 * @param name
	 */
	
	public Chance(int fieldNumber, String name) {
		super(name);
		this.fieldNumber = fieldNumber;
	}

	/**
	 * Draws a card and executes the method drawnCard, that 
	 * determines what the given card do.
	 */
	
	@Override
	public void landOnField(User user) {
		Card drawnCard = CardPile.drawCard();
		drawnCard.drawnCard(user);
		GUIBoundary.showMessage(drawnCard.getText());
	}

}
