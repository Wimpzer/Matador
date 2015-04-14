package field;

import user.User;

public class Street extends Ownable{
	private String color;
	private int houseAmount;
	private int hotelAmount;
	
	public Street(String name, int rentPrice, int fieldPrice, User user, String color){
		super(name);
		this.rentPrice = rentPrice;
		this.fieldPrice = fieldPrice;
		this.setOwner(user);
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


	public int getHouseAmount() {
		return houseAmount;
	}


	public void setHouseAmount(int houseAmount) {
		this.houseAmount = houseAmount;
	}


	public int getHotelAmount() {
		return hotelAmount;
	}


	public void setHotelAmount(int hotelAmount) {
		this.hotelAmount = hotelAmount;
	}
	
	
	
}
