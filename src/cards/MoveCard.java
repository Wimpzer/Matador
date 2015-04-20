package cards;

import field.Shipping;
import game.Controller;
import user.User;

public class MoveCard extends Card {
	private int move;
	private int position;
	private int bonus;

	public MoveCard(String text, int move, int position){
		super(text);
		this.move = move;
		this.position = position;
	}

	@Override
	public void drawnCard(User user) {
		if(move==0){
			if(position==31){
				user.setInJail(true);
				user.setCurrentPosition(30);
			}
			else if(position==16){
				//Ryk til rederi indsættes her
				Shipping ship = (Shipping) Controller.getBoard().getField(5);
				User usership = ship.getOwner();
				if(usership == null){
					
				}else if(usership == user){
					
				}else{
					usership.deposit(ship.rent()*2);
				}
			}
			else
			{
				user.setCurrentPosition(position);
				if(user.getCurrentPosition() > position){
					user.deposit(4000);
				}
			}
		}
		else
		{
			user.setCurrentPosition(user.getCurrentPosition() + move);
		}

	}

}
