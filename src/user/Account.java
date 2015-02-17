package user;

import interfaces.IAccount;

public class Account implements IAccount{

	int balance;

	@Override
	public void deposit(int amount) { //TODO: M� ikke v�re minus (Exception?)
		balance += amount;	
	}

	@Override
	public void withdraw(int amount) { //TODO: M� ikke v�re minus (Exception?)
		balance -= amount;	
	}

	@Override
	public int getBalance() {
		return balance;
	}
}
