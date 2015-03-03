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
	
	public void landOnField(User user){
		if(getOwner() != null && getOwner() != user){
			getOwner().deposit(rentPrice);
			user.withdraw(rentPrice);
		}else if(getOwner() == null){
			setOwner(user);
			user.withdraw(fieldPrice);
		}
	}
	
	public User getOwner(){
		return owner;
	}
	
	public void setOwner(User owner){
		this.owner = owner;
	}
	
	public int getFieldPrice(){
		return fieldPrice;
	}
	
}
