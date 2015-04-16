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
		int rollCount = 0;

		if(user.getCurrentPosition() == 30){

			if(user.getFreeJailCards() > 0){
				user.setFreeJailCards(user.getFreeJailCards() - 1);
				user.setCurrentPosition(10);
			}else {
				user.setInJail(true);
				while(rollCount < 3)
				{
					diceCup.roll();
					diceCup.checkEqual();

					if(diceCup.checkEqual() == false){
						rollCount++;
					} else {
						user.setInJail(false);
					}
				}
				if(rollCount == 3)
				{
					user.withdraw(jailFine);
					user.setInJail(false);
				}

				user.setCurrentPosition(10 + diceCup.getSum());

			}
		}
	}

}