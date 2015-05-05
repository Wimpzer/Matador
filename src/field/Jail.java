package field;

import boundary.GUIBoundary;
import game.Dice;
import user.User;

public class Jail extends Field {

	public Jail(int fieldNumber, String name) {
		super(name);
		this.fieldNumber = fieldNumber;
	}

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
				GUIBoundary.showMessage("Du er blevet nødsaget til at betale 1000 kr. i kaution");
			}
		}
	}
}
