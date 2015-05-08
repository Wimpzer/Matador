package field;

import user.User;

	/**
	 * The parent class for all fields, which can be owned.
	 * @author Frederik
	 */

public abstract class Ownable extends Field {
	protected int fieldPrice;
	protected int rentPrice;
	protected boolean fieldActive;
	private User owner;

	/**
	 * Constructor for setting the name of the given field.
	 * @param name
	 */
	
	public Ownable(String name){
		super(name);
	}
	
	abstract public int rent();
	
	abstract public void setRentPrice();
	
	abstract public boolean getFieldActive();
	
	abstract public void setFieldActive(boolean fieldActive);
	
	/**
	 * Checks if the field are owned or not and determines if the
	 * player buys the field or pays the rent.
	 */
	
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
	
	/**
	 * Returns the owner for the given field.
	 * @return
	 */
	
	public User getOwner(){
		return owner;
	}
	
	/**
	 * Sets the owner for the given field.
	 * @param user
	 */
	
	public void setOwner(User user){
		this.owner = user;
	}
	
	/**
	 * Returns the price for the given field.
	 * @return
	 */
	
	public int getFieldPrice(){
		return fieldPrice;
	}
	
}
