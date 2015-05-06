package cards;

import game.Controller;
import user.User;

	/**
	 * 
	 * @author Andreas
	 */

public class PropertyCard extends Card{
	private int payHouse;
	private int payHotel;
	
	/**
	 * Sets the text, payHouse and payHotel for the given card.
	 * @param text
	 * @param payHouse The amount for owning a house.
	 * @param payHotel The amount for owning a hotel.
	 */
	
	public PropertyCard(String text, int payHouse, int payHotel) {
		super(text);
		this.payHouse = payHouse;
		this.payHotel = payHotel;
	}

	/**
	 * Withdraw the payHouse and payHotel times the amount of owned, by the user, houses or hotels.
	 */
	
	@Override
	public void drawnCard(User user) {
		user.withdraw((Controller.getHotelAmount(user) * payHouse) + (Controller.getHouseAmount(user) * payHotel));
	}

}
