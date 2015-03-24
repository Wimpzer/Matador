package user;

import interfaces.IUser;

public class User implements IUser {

	String userName;
	int userNumber;
	int currentPosition;
	Account accountOb = new Account();
	
	public User(String userName, int userNumber, int currentPosition) {
		this.userName = userName;
		this.userNumber = userNumber;
		this.currentPosition = currentPosition;
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
}
