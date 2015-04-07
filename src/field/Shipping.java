package field;

import user.User;

public class Shipping extends Ownable {

	public Shipping(String name, int rentPrice, int userNumber) {
		super(name);
		this.rentPrice = rentPrice;
		this.setOwner(userNumber);
		this.fieldPrice = 4000;
	}

	@Override
	public void landOnField(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int rent() {
		// TODO Auto-generated method stub
		return 0;
	}

}
