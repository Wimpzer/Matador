package field;

import boundary.GUIBoundary;
import game.Dice;
import user.User;

	/**
	 * @author Bjarke and Frederik
	 */

public class Jail extends Field {

	/**
	 * Constructor for setting the number and name for the given field.
	 * @param fieldNumber
	 * @param name
	 */
	
	public Jail(int fieldNumber, String name) {
		super(name);
		this.fieldNumber = fieldNumber;
	}

	/**
	 * Checks if inJail is true or false, to determine if he just got
	 * in jail or not.
	 * If false checks first for jailCards, else sets inJail true.
	 * If true, it will roll the dice and determine if the player gets
	 * out in this turn or not.
	 * If jailTimeCounter is three, after the dice roll, it will withdraw
	 * the jailFine and set the player free.
	 */
	
	@Override
	public void landOnField(User user) {
		Dice diceCup = new Dice();
		int jailFine = 1000;

		GUIBoundary.showMessage("Du har været i fængsel i " + user.getJailTimeCounter() + " runder");
		if(user.getCurrentPosition() == 30){
			if(user.getInJail() == true){
				diceCup.roll();
				GUIBoundary.setDice(diceCup.getFaceValue1(), diceCup.getFaceValue2());
				if(diceCup.checkEqual() == true){
					user.setInJail(false);
					user.setJailTimeCounter(0);
					user.setCurrentPosition(10 + diceCup.getSum());
				}
			}		
			else if(user.getInJail() == false){
				if(user.getFreeJailCards() > 0){
					user.setFreeJailCards(user.getFreeJailCards() - 1);
					user.setCurrentPosition(10);
				}
				else{
					user.setInJail(true);
				}
			}
			if(user.getJailTimeCounter() == 3){
				user.withdraw(jailFine);
				user.setInJail(false);
				user.setJailTimeCounter(0);
				user.setCurrentPosition(10 + diceCup.getSum());
				GUIBoundary.showMessage("Du er blevet nødsaget til at betale " + jailFine + " kr. i kaution");
			}
		}
	}
}
