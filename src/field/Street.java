package field;

import user.User;

public class Street extends Ownable{
	private String color;
	int rent, price, housePrice, rentHouse1, rentHouse2, rentHouse3, rentHouse4, rentHotel;
	
	public Street(int number, String name, int price, int housePrice, int rent, int rentHouse1, int rentHouse2, int rentHouse3, int rentHouse4, int rentHotel)
	{
		super(name);
		this.rentPrice = rentPrice;
		this.fieldPrice = fieldPrice;
		this.setOwner(owner);
		this.color = color;
	}

	
		// TODO Auto-generated constructor stub
	}

	@Override
	public int rent() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addStreet(Street field) {
		// TODO Auto-generated method stub
		
	}
	
}
