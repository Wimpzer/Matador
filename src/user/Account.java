package user;

import interfaces.IAccount;

public class Account implements IAccount{

	int balance;

	@Override
	public void deposit(int amount) { //TODO: Må ikke være minus (Exception?)
		balance += amount;	
	}

	@Override
	public void withdraw(int amount) { //TODO: Må ikke være minus (Exception?)
		balance -= amount;	
	}

	@Override
	public int getBalance() {
		return balance;
	}
}
