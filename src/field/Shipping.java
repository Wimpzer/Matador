package field;

public class Shipping extends Ownable {
	
	public Shipping(int fieldNumber, String name, int rentPrice) {
		super(name);
		this.fieldNumber = fieldNumber;
		this.rentPrice = rentPrice;
		this.fieldPrice = 4000;
	}

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

}
