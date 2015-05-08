package field;

import game.Controller;

	/**
	 * @author Frederik
	 */

public class Brewery extends Ownable {
	private int rentPrice;
	
	/**
	 * Constructor for setting the number, name and price for the given field.
	 * @param fieldNumber
	 * @param name
	 * @param fieldPrice
	 */
	
	public Brewery(int fieldNumber, String name, int fieldPrice) {
		super(name);
		this.fieldNumber = fieldNumber;
		this.fieldPrice = fieldPrice;
		setFieldActive(true);
	}
	
	/**
	 * Checks how many brewery the owner, for the field that the use landed on,
	 * owns, and multiply the diceSum with either 100 or 200.
	 */
	
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
	
	@Override
	public void setRentPrice() {
	}

	/**
	 * Returns the value fieldActive, which determine if the
	 * field are pawned or not.
	 */
	
	@Override
	public boolean getFieldActive() {
		return fieldActive;
	}

	/**
	 * Sets the value fieldActive, which determine if the
	 * field are pawned or not.
	 * @param fieldActive
	 */
	
	@Override
	public void setFieldActive(boolean fieldActive) {
		this.fieldActive = fieldActive;
	}

}
