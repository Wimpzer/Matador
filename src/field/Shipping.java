package field;

import user.User;

public class Shipping extends Ownable {

	public Shipping(String name, int rentPrice, User owner) {
		super(name);
		this.rentPrice = rentPrice;
		this.setOwner(owner);
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
