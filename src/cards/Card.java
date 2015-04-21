package cards;

import user.User;

public abstract class Card {
	protected String text;
	
	public Card(String text){
		this.text = text;
	}
	
	abstract public void drawnCard(User user);
	
	public String getText(){
		return text;
	}
	
}
