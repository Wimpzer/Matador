package field;

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
		if(this.getOwner().get == 1)
	}
	
	@Override
	public void landOnField(User user) {
		// TODO Auto-generated method stub
		
	}
}
