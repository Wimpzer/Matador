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

//		System.out.println("JailTimeCounter: " + user.getJailTimeCounter());
		if(user.getCurrentPosition() == 30){
			if(user.getInJail() == true){
				diceCup.roll();
//				System.out.println("roll(): " + diceCup.getSum());
				if(diceCup.checkEqual() == true){
					user.setInJail(false);
					user.setJailTimeCounter(0);
					user.setCurrentPosition(10 + diceCup.getSum());
//					System.out.println("Equal = true");
				}
			}		
			else if(user.getInJail() == false){
				if(user.getFreeJailCards() > 0){
					user.setFreeJailCards(user.getFreeJailCards() - 1);
					user.setCurrentPosition(10);
				}
				else{
					user.setInJail(true);
//					System.out.println("InJail = false, sæt true");
				}
			}
			if(user.getJailTimeCounter() == 3){
				user.withdraw(jailFine);
				user.setInJail(false);
				user.setJailTimeCounter(0);
				user.setCurrentPosition(10 + diceCup.getSum());
//				System.out.println("Paying my way out");
			}
		}
	}
}
