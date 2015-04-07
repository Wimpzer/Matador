package field;

import user.User;


public class Brewery extends Ownable {

	public Brewery(String name, int rentPrice, int userNumber) {
		super(name);
		this.fieldPrice = 3000;
		this.rentPrice = rentPrice;
		this.setOwner(userNumber);
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
