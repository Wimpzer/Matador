package cards;

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
			}
			else if(position==16){
				//Ryk til rederi indsættes her
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
