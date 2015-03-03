package user;

import interfaces.IAccount;

public class Account implements IAccount{

	int balance;

	@Override
	public void deposit(int amount) {
		if(amount < 0){
			System.out.println("Minus"); //TODO: Smid Syso ud i brugergr�nsefladen
		}else{
			balance += amount;
		}
	}

	@Override
	public void withdraw(int amount) { 
		if(amount < 0){
			System.out.println("Minus"); //TODO: Smid Syso ud i brugergr�nsefladen
		}else{
			balance -= amount;	
		}
	}

	@Override
	public int getBalance() {
		return balance;
	}
}