package field;

import game.Dice;
import user.User;

public class Jail extends Field {

	public Jail(int fieldNumber, String name) {
		super(name);
		this.fieldNumber = fieldNumber;
	}

	@Override
	public void landOnField(User user) {
		Dice diceCup = new Dice(); //TODO: Kan denne laves anerledes?
		int jailFine = 1000;

		if(user.getCurrentPosition() == 30){
			if(user.getInJail() == true){
				diceCup.roll();
				if(diceCup.checkEqual() == true){
					user.setInJail(false);
					user.setCurrentPosition(10 + diceCup.getSum());
				}
			}
			if(user.getJailTimeCounter() == 3){
				user.withdraw(jailFine);
				user.setInJail(false);
				user.setCurrentPosition(10 + diceCup.getSum());
			}
		}else if(user.getInJail() == false){
			if(user.getFreeJailCards() > 0){
				user.setFreeJailCards(user.getFreeJailCards() - 1);
				user.setCurrentPosition(10);
			}
			else user.setInJail(true);
		}
	}

}
