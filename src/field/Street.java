package field;

import user.User;

public class Street extends Ownable{
	private int houseAmount;
	private int hotelAmount;
	private int rentHouse1;
	private int rentHouse2;
	private int rentHouse3;
	private int rentHouse4;
	private int rentHotel;
	private int housePrice;
	String colour;
	
	
	public Street(int fieldNumber, String name, int fieldPrice, int housePrice, int rentPrice, int rentHouse1, int rentHouse2, int rentHouse3, int rentHouse4,
			int rentHotel, String colour){
		super(name);
		this.fieldNumber = fieldNumber;
		this.fieldPrice = fieldPrice;
		this.housePrice = housePrice;
		this.rentPrice = rentPrice;
		this.rentHouse1 = rentHouse1;
		this.rentHouse2 = rentHouse2;
		this.rentHouse3 = rentHouse3;
		this.rentHouse4 = rentHouse4;
		this.rentHotel = rentHotel;
		this.colour = colour;
		
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
