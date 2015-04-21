package field;

import game.Controller;


public class Brewery extends Ownable {
	private int rentPrice;
	
	public Brewery(int fieldNumber, String name, int fieldPrice) {
		super(name);
		this.fieldNumber = fieldNumber;
		this.fieldPrice = fieldPrice;
	}

	@Override
	public int rent() {
		if(this.getOwner().getOwnedBrewery() == 1){
			rentPrice = Controller.getSum() * 100;
			super.rentPrice = Controller.getSum() * 100;
		}else if(this.getOwner().getOwnedBrewery() == 2){
			rentPrice = Controller.getSum() * 200;
			super.rentPrice = Controller.getSum() * 100;
		}
		return rentPrice;
	}

}
