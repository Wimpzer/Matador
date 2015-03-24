package field;

import user.User;

public abstract class Ownable extends Field {
	protected int fieldPrice;
	protected int rentPrice;
	private int ownerNumber;

	public Ownable(String name){
		super(name);
	}
	
	abstract public int rent();
	
	public void landOnField(User user){
	}
	
	public int getOwner(){
		return ownerNumber;
	}
	
	public void setOwner(int ownerNumber){
		this.ownerNumber = ownerNumber;
	}
	
	public int getFieldPrice(){
		return fieldPrice;
	}
	
}
