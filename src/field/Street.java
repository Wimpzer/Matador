package field;

import java.awt.Color;

import game.Controller;

	/**
	 * @author Andreas, Bjarke, Frederik and Joakim
	 */

public class Street extends Ownable{
	private int houseAmount;
	private int hotelAmount;
	private int rentHouse1;
	private int rentHouse2;
	private int rentHouse3;
	private int rentHouse4;
	private int rentHotel;
	private int housePrice;
	private Color colour;
	private int oldRentPrice;
	
	/**
	 * Constructor for setting the number, name, price, houseprice, rent, rent for houses, rent for hotel, and colour.
	 * @param fieldNumber
	 * @param name
	 * @param fieldPrice
	 * @param housePrice
	 * @param rentPrice
	 * @param rentHouse1
	 * @param rentHouse2
	 * @param rentHouse3
	 * @param rentHouse4
	 * @param rentHotel
	 * @param colour
	 */
	
	public Street(int fieldNumber, String name, int fieldPrice, int housePrice, int rentPrice, int rentHouse1, int rentHouse2, int rentHouse3, int rentHouse4, int rentHotel, Color colour)
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
		setFieldActive(true);
	}

	/**
	 * Checks how many streets the owner, for the field that the use landed on,
	 * owns of the same colour, and doubles the rent if the owner owns all the
	 * fields with same colour.
	 */
	
	@Override
	public int rent() {
		if (getOwner() != null && Controller.getBoard().getSimilarCount(this) == 3){
			oldRentPrice = rentPrice;
			this.rentPrice = rentPrice * 2;
		}else if ((getOwner() != null && Controller.getBoard().getSimilarCount(this) == 2) && (colour.equals(((Street)Controller.getBoard().getField(1)).getColour()) || colour.equals(((Street)Controller.getBoard().getField(39)).getColour()))){
			oldRentPrice = rentPrice;
			this.rentPrice = rentPrice * 2;
		}
		
		return rentPrice;
	}

	/**
	 * Changes the rent if the owner owns all the fields matching the colour
	 * of the given field.
	 */
	
	public void setRentPrice(){
		if (getOwner() != null && Controller.getBoard().getSimilarCount(this) == 3){
			rentPrice = oldRentPrice;
		}else if ((getOwner() != null && Controller.getBoard().getSimilarCount(this) == 2) && (colour.equals(((Street)Controller.getBoard().getField(1)).getColour()) || colour.equals(((Street)Controller.getBoard().getField(39)).getColour()))){
			rentPrice = oldRentPrice;
		}
	}

	/**
	 * Returns the amount of houses on the given field.
	 * @return
	 */
	
	public int getHouseAmount() {
		return houseAmount;
	}

	/**
	 * Sets the amount of houses on the given field.
	 * @param houseAmount
	 */

	public void setHouseAmount(int houseAmount) {
		this.houseAmount = houseAmount;
	}

	/**
	 * Returns the amount of hotels on the given field.
	 * @return
	 */

	public int getHotelAmount() {
		return hotelAmount;
	}

	/**
	 * Sets the amount of hotels on the given field.
	 * @param hotelAmount
	 */

	public void setHotelAmount(int hotelAmount) {
		this.hotelAmount = hotelAmount;
	}

	/**
	 * Returns the rent for the given field.
	 * @return
	 */
	
	public int getRent(){
		return rentPrice;
	}

	/**
	 * Returns the rent, if one house is placed, for the given field.
	 * @return
	 */
	
	public int getRentHouse1() {
		return rentHouse1;
	}

	/**
	 * Returns the rent, if two house is placed, for the given field.
	 * @return
	 */

	public int getRentHouse2() {
		return rentHouse2;
	}

	/**
	 * Returns the rent, if three house is placed, for the given field.
	 * @return
	 */

	public int getRentHouse3() {
		return rentHouse3;
	}

	/**
	 * Returns the rent, if four house is placed, for the given field.
	 * @return
	 */

	public int getRentHouse4() {
		return rentHouse4;
	}

	/**
	 * Returns the rent, if one hotel is placed, for the given field.
	 * @return
	 */

	public int getRentHotel() {
		return rentHotel;
	}

	/**
	 * Returns the price for placing a house on the given field.
	 * @return
	 */

	public int getHousePrice() {
		return housePrice;
	}

	/**
	 * Returns the colour of the given field.
	 * @return
	 */

	public Color getColour() {
		return colour;
	}

	/**
	 * Returns the value fieldActive, which determine if the
	 * field are pawned or not.
	 */
	
	@Override
	public boolean getFieldActive() {
		return fieldActive;
	}

	/**
	 * Sets the value fieldActive, which determine if the
	 * field are pawned or not.
	 * @param fieldActive
	 */
	
	@Override
	public void setFieldActive(boolean fieldActive) {
		this.fieldActive = fieldActive;
	}
	
	
	
}
