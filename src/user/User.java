package user;

import interfaces.IUser;

public class User implements IUser {

	String userName;
	int userNumber;
	int currentPosition;
	Account accountOb = new Account();
	int startAmount = 30000;
	private int ownedBrewery;
	private int ownedShipping;
	private int freeJailCards;
	private int jailTimeCounter;
	private boolean inJail;
	private int groundValue;
	
	public User(String userName, int userNumber, int currentPosition) {
		this.userName = userName;
		this.userNumber = userNumber;
		this.currentPosition = currentPosition;
		deposit(startAmount);
		this.ownedBrewery = 0;
		this.ownedShipping = 0;
		this.freeJailCards = 0;
		this.jailTimeCounter = 0;
		this.inJail = false;
	}
	
	public User(String userName, int userNumber, int currentPosition, int balance, int jailCards){
		this.userName = userName;
		this.userNumber = userNumber;
		this.currentPosition = currentPosition;
		deposit(balance);
		this.ownedBrewery = 0;
		this.ownedShipping = 0;
		this.freeJailCards = jailCards;
		this.jailTimeCounter = 0;
		this.inJail = false;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	@Override
	public void deposit(int amount) {
		accountOb.deposit(amount);
	}
	@Override
	public void withdraw(int amount) {
		accountOb.withdraw(amount);
	}
	@Override
	public int getBalance() {
		return accountOb.getBalance();
	}

	public int getOwnedBrewery() {
		return ownedBrewery;
	}

	public void setOwnedBrewery(int ownedBrewery) {
		this.ownedBrewery = ownedBrewery;
	}

	public int getOwnedShipping() {
		return ownedShipping;
	}

	public void setOwnedShipping(int ownedShipping) {
		this.ownedShipping = ownedShipping;
	}

	public int getFreeJailCards() {
		return freeJailCards;
	}

	public void setFreeJailCards(int freeJailCards) {
		this.freeJailCards = freeJailCards;
	}

	public int getJailTimeCounter() {
		return jailTimeCounter;
	}

	public void setJailTimeCounter(int jailTimeCounter) {
		this.jailTimeCounter = jailTimeCounter;
	}

	public boolean getInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}
	
	public int getGroundValue(){
		return groundValue;
	}
	
	public void setGroundValue(int groundValue){
		this.groundValue = groundValue;
	}
	
	public int getTotalUserValue(){
		return groundValue + accountOb.getBalance();
	}
	
}
