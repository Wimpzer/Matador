package field;

import user.User;

public class Street extends Ownable{
	private String color;
	
	public Street(String name, int rentPrice, int fieldPrice, int userNumber, String color){
		super(name);
		this.rentPrice = rentPrice;
		this.fieldPrice = fieldPrice;
		this.setOwner(userNumber);
		this.color = color;
	}

	
		// TODO Auto-generated constructor stub

	@Override
	public int rent() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addStreet(Street field) {
		// TODO Auto-generated method stub
		
	}
	
}
