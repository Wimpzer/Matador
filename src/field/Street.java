package field;

import game.Controller;

public class Street extends Ownable{
	private int houseAmount;
	private int hotelAmount;
	private int rentHouse1;
	private int rentHouse2;
	private int rentHouse3;
	private int rentHouse4;
	private int rentHotel;
	private int housePrice;
	private String colour;
	
	public Street(int fieldNumber, String name, int fieldPrice, int housePrice, int rentPrice, int rentHouse1, int rentHouse2, int rentHouse3, int rentHouse4, int rentHotel, String colour)
	{
		super(name);
		this.fieldNumber = fieldNumber;
		this.fieldPrice = fieldPrice;
		this.rentPrice = rentPrice;
		this.housePrice=housePrice;
		this.rentHouse1=rentHouse1;
		this.rentHouse2=rentHouse2;
		this.rentHouse3 = rentHouse3;
		this.rentHouse4 = rentHouse4;
		this.rentHotel = rentHotel;
		this.colour = colour;
		
	}

	@Override
	public int rent() {
		if (getOwner() != null && Controller.getBoard().getSimilarCount(this) == 3){
			this.rentPrice = rentPrice * 2;
		}
		if ((getOwner() != null && Controller.getBoard().getSimilarCount(this) == 2) && (colour == "blue" || colour == "purple")){
			this.rentPrice = rentPrice * 2;
		}
		
		return rentPrice;
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


	public int getRentHouse1() {
		return rentHouse1;
	}


	public int getRentHouse2() {
		return rentHouse2;
	}


	public int getRentHouse3() {
		return rentHouse3;
	}


	public int getRentHouse4() {
		return rentHouse4;
	}


	public int getRentHotel() {
		return rentHotel;
	}


	public int getHousePrice() {
		return housePrice;
	}


	public String getColour() {
		return colour;
	}
	
	
	
}
