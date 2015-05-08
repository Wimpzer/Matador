package user;

import interfaces.IAccount;

/**
 * @author Bjarke
 */

public class Account implements IAccount{
	int balance;

	/**
	 * Deposits the amount into the given users account.
	 * @param amount
	 */
	
	@Override
	public void deposit(int amount) {
		if(amount < 0){
			
		}else{
			balance += amount;
		}
	}

	/**
	 * Withdraws the amount from the given users account.
	 * @param amount
	 */
	
	@Override
	public void withdraw(int amount) { 
		if(amount < 0){
			
		}else{
			balance -= amount;	
		}
	}

	/**
	 * Returns the balance of the given user.
	 */
	
	@Override
	public int getBalance() {
		return balance;
	}
	
}
