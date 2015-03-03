package field;

import user.User;


public class Brewery extends Ownable {

	public Brewery(String name, int rentPrice, User owner) {
		super(name);
		this.fieldPrice = 3000;
		this.rentPrice = rentPrice;
		this.setOwner(owner);
	}

	@Override
	public int rent() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void landOnField(User user) {
		// TODO Auto-generated method stub
		
	}
}
