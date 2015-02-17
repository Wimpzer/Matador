package user;

import interfaces.IUser;

public class User implements IUser {

	String userName;
	int currentPosition;
	Account accountOb = new Account();
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
