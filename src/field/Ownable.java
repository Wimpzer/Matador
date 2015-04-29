package field;

import user.User;

public abstract class Ownable extends Field {
	protected int fieldPrice;
	protected int rentPrice;
	private User owner;

	public Ownable(String name){
		super(name);
	}
	
	abstract public int rent();
	
	abstract public void setRentPrice();
	
	public void landOnField(User user){
		if(getOwner() != null && getOwner() != user){
			getOwner().deposit(rentPrice);
			user.withdraw(rentPrice);
		}
		if(getOwner() == null){
			setOwner(user);
			user.withdraw(fieldPrice);
			user.setGroundValue(user.getGroundValue()+fieldPrice);
		}
	}
		
	public User getOwner(){
		return owner;
	}
	
	public void setOwner(User user){
		this.owner = user;
	}
	
	public int getFieldPrice(){
		return fieldPrice;
	}
	
}
