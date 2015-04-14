package field;

import game.Dice;
import user.User;

public class Jail extends Field {

	public Jail(String name) {
		super(name);
	}

	@Override
	public void landOnField(User user) {
		Dice diceCup = new Dice();
		int jailFine = 1000;
		int rollCount = 0;
		
		if(user.getCurrentPosition() == 30){
			u
		}
		
	}

}
