package user;

import interfaces.IUser;

/**
 * Contains the needed variables for a player in the game.
 * Implements the interface IUser.
 * 
 * @author Bjarke
 */

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
	
	/**
	 * Constructor for making a new user, when
	 * making a new game.
	 * @param userName
	 * @param userNumber
	 * @param currentPosition
	 */
	
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
	
	/**
	 * Constructor for making a new user, when
	 * loading the game from database.
	 * Sets the database balance instead of the
	 * startAmount, and sets correct amount of
	 * freeJailCards.
	 * @param userName
	 * @param userNumber
	 * @param currentPosition
	 * @param balance
	 * @param jailCards
	 */
	
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
	
	/*****************************************************

	GETTERS AND SETTERS

	 *****************************************************/
	
	/**
	 * Returns the name of the given user.
	 */
	
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the name of the given user.
	 */
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Returns the number of the given user.
	 * @return
	 */
	
	public int getUserNumber() {
		return userNumber;
	}
	
	/**
	 * Sets the number of the given user.
	 * @param userNumber
	 */
	
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	/**
	 * Returns the position of the given user.
	 */
	
	public int getCurrentPosition() {
		return currentPosition;
	}
	
	/**
	 * Sets the position of the given user.
	 */
	
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	/**
	 * Calls the deposit method in account.
	 */
	
	@Override
	public void deposit(int amount) {
		accountOb.deposit(amount);
	}
	
	/**
	 * Calls the withdraw method in account.
	 */
	
	@Override
	public void withdraw(int amount) {
		accountOb.withdraw(amount);
	}
	
	/**
	 * Calls the getBalance method in account.
	 */
	
	@Override
	public int getBalance() {
		return accountOb.getBalance();
	}

	/**
	 * Return the amount of owned brewerys by the given user.
	 * @return
	 */
	
	public int getOwnedBrewery() {
		return ownedBrewery;
	}

	/**
	 * Sets the amount of owned brewerys by the given user.
	 * @param ownedBrewery
	 */
	
	public void setOwnedBrewery(int ownedBrewery) {
		this.ownedBrewery = ownedBrewery;
	}

	/**
	 * Return the amount of owned shippings by the given user.
	 * @return
	 */
	
	public int getOwnedShipping() {
		return ownedShipping;
	}

	/**
	 * Sets the amount of owned brewerys by the given user.
	 * @param ownedShipping
	 */
	
	public void setOwnedShipping(int ownedShipping) {
		this.ownedShipping = ownedShipping;
	}

	/**
	 * Returns the amount of owned jailCards by the given user.
	 * @return
	 */
	
	public int getFreeJailCards() {
		return freeJailCards;
	}

	/**
	 * Sets the amount of owned jailCards by the given user.
	 * @param freeJailCards
	 */
	
	public void setFreeJailCards(int freeJailCards) {
		this.freeJailCards = freeJailCards;
	}

	/**
	 * Returns the time the given player have been in user.
	 * @return
	 */
	
	public int getJailTimeCounter() {
		return jailTimeCounter;
	}

	/**
	 * Sets the time the given player have been in user.
	 * @param jailTimeCounter
	 */
	
	public void setJailTimeCounter(int jailTimeCounter) {
		this.jailTimeCounter = jailTimeCounter;
	}

	/**
	 * Returns if given user is in jail or not.
	 * @return
	 */
	
	public boolean getInJail() {
		return inJail;
	}

	/**
	 * Sets if the given user is in jail or not.
	 * @param inJail
	 */
	
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}
	
	/**
	 * Returns the value the given user is worth.
	 * @return
	 */
	
	public int getGroundValue(){
		return groundValue;
	}
	
	/**
	 * Sets the value the given user is worth.
	 * @param groundValue
	 */
	
	public void setGroundValue(int groundValue){
		this.groundValue = groundValue;
	}
	
	/**
	 * Returns the value the given user is worth, including cash.
	 * @return
	 */
	
	public int getTotalUserValue(){
		return groundValue + accountOb.getBalance();
	}
	
}
