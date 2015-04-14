package field;

import game.Controller;
import user.User;


public class Brewery extends Ownable {

	public Brewery(String name, int rentPrice, User user) {
		super(name);
		this.fieldPrice = 3000;
		this.rentPrice = rentPrice;
		this.setOwner(user);
	}

	@Override
	public int rent() {
		if(this.getOwner().getOwnedBrewery() == 1){
			rentPrice = Controller.getSum() * 100;
		}
		if(this.getOwner().getOwnedBrewery() == 2){
			rentPrice = Controller.getSum() * 200;
		}
	}
	

}
