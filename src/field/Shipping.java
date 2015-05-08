package field;

	/**
	 * @author Frederik
	 */

public class Shipping extends Ownable {
	
	/**
	 * Constructor for setting the number, name and rentprice for the given field.
	 * @param fieldNumber
	 * @param name
	 * @param rentPrice
	 */
	
	public Shipping(int fieldNumber, String name, int rentPrice) {
		super(name);
		this.fieldNumber = fieldNumber;
		this.rentPrice = rentPrice;
		this.fieldPrice = 4000;
		setFieldActive(true);
	}

	/**
	 * Determines the rent by finding out how many shipping fields the owner, 
	 * of the field which the user landed on, has.
	 */
	
	@Override
	public int rent() {
		if(this.getOwner().getOwnedShipping() == 1){
			rentPrice = 500;
		}
		
		if(this.getOwner().getOwnedShipping() == 2){
			rentPrice = 1000;
		}
		
		if(this.getOwner().getOwnedShipping() == 3){
			rentPrice = 2000;
		}
		
		if(this.getOwner().getOwnedShipping() == 4){
			rentPrice = 4000;
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
