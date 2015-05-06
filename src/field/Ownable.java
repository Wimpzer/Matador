package field;

import user.User;

	/**
	 * The parent class for all fields, which can be owned.
	 * 
	 * @author Bjarke
	 */

public abstract class Ownable extends Field {
	protected int fieldPrice;
	protected int rentPrice;
	protected boolean fieldActive;
	private User owner;

	public Ownable(String name){
		super(name);
	}
	
	abstract public int rent();
	
	abstract public void setRentPrice();
	
	abstract public boolean getFieldActive();
	
	abstract public void setFieldActive(boolean fieldActive);
	
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
