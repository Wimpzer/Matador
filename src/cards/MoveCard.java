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
		
		
	}
	
}
