package cards;

import game.Controller;
import user.User;

public class PropertyCard extends Card{
	private int payHouse;
	private int payHotel;
	
	public PropertyCard(String text, int payHouse, int payHotel) {
		super(text);
		this.payHouse = payHouse;
		this.payHotel = payHotel;
	}

	@Override
	public void drawnCard(User user) {
		//TODO Få antallet af huse og hoteller ejet af user
		Controller.getHotelAmount(user);
		Controller.getHouseAmount(user);
	}

}
