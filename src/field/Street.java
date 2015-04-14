package field;

import user.User;

public class Street extends Ownable{
	private String color;
	int rent, price, housePrice, rentHouse1, rentHouse2, rentHouse3, rentHouse4, rentHotel;
	
	public Street(int number, String name, int price, int housePrice, int rent, int rentHouse1, int rentHouse2, int rentHouse3, int rentHouse4, int rentHotel, String colorS)
	{
		super(number, name); 
		this.price = price;
		this.rent = rent;
		this.housePrice=housePrice;
		this.rentHouse1=rentHouse1;
		this.rentHouse2=rentHouse2;
		this.rentHouse3 = rentHouse3;
		this.rentHouse4 = rentHouse4;
		this.rentHotel = rentHotel;
		
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
