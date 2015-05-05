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
				if(user.getCurrentPosition() <= 5 || user.getCurrentPosition() > 36 ){
					user.setCurrentPosition(5);
					Shipping ship = (Shipping) Controller.getBoard().getField(5);
					User shipOwner = ship.getOwner();
					if(shipOwner != null && shipOwner != user){
						shipOwner.deposit(ship.rent()*2);
						user.withdraw(ship.rent()*2);
					}
				}
				
				if(user.getCurrentPosition() <= 15 && user.getCurrentPosition() > 5 ){
					user.setCurrentPosition(15);
					Shipping ship = (Shipping) Controller.getBoard().getField(15);
					User shipOwner = ship.getOwner();
					if(shipOwner != null && shipOwner != user){
						shipOwner.deposit(ship.rent()*2);
						user.withdraw(ship.rent()*2);
					}
				}
				
				if(user.getCurrentPosition() <= 25 && user.getCurrentPosition() > 15 ){
					user.setCurrentPosition(25);
					Shipping ship = (Shipping) Controller.getBoard().getField(25);
					User shipOwner = ship.getOwner();
					if(shipOwner != null && shipOwner != user){
						shipOwner.deposit(ship.rent()*2);
						user.withdraw(ship.rent()*2);
					}
				}
				if(user.getCurrentPosition() <= 35 && user.getCurrentPosition() > 25 ){
					user.setCurrentPosition(35);
					Shipping ship = (Shipping) Controller.getBoard().getField(35);
					User shipOwner = ship.getOwner();
					if(shipOwner != null && shipOwner != user){
						shipOwner.deposit(ship.rent()*2);
						user.withdraw(ship.rent()*2);
					}
				}
				
			}
			else
			{
				user.setCurrentPosition(position-1);
				if(user.getCurrentPosition() > position-1){
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
