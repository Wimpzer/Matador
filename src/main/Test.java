package main;

import field.*;
import game.Board;
import user.Account;
import user.User;

public class Test {

	Board board = new Board();
	User user = new User("Tester", 1, 0);
	
	public void run(){
		
		//		account(user);
		//		fieldMove(user);
//		fieldOwner();
		houseOwner();


	}

	public void account(){

		System.out.println("Start balance: " + user.getBalance());
		System.out.println("Withdraw 5000,-");
		user.withdraw(5000);
		System.out.println("Updated balance: " + user.getBalance());
		System.out.println("Deposit 12500,-");
		user.deposit(12500);
		System.out.println("Final balance: " + user.getBalance());
	}

	public void fieldMove(){
		System.out.println("User start position: " + user.getCurrentPosition());
		System.out.println("Move 5 forward");
		user.setCurrentPosition(user.getCurrentPosition() + 5);
		System.out.println("New position: " + user.getCurrentPosition());
		System.out.println("Move 6 backwards");
		user.setCurrentPosition(user.getCurrentPosition() - 6);
		System.out.println("Final position: " + user.getCurrentPosition());
	}

	public void fieldOwner(){
		
		Field field = board.getField(3);
		System.out.println(field.getName() + " Owned by: " + ((Street) field).getOwner());
		System.out.println("Setting owner to Tester");
		((Street) field).setOwner(user);
		System.out.println("" + field.getName() + " Owned by: " + ((Street) field).getOwner().getUserName());
		System.out.println("Remove owner");
		((Street) field).setOwner(null);
		System.out.println(field.getName() + " Owned by: " + ((Street) field).getOwner());
	}
	
	public void houseOwner(){
		Street street1 = (Street) board.getField(1);
		Street street2 = (Street) board.getField(3);
		street1.setOwner(user);
		
		System.out.println("Tester owns field 2, tries to buy house");
		street1.setHouseAmount(0);
		System.out.println(street1.getName() + " has " + street1.getHouseAmount() + " houses");
		
		
		System.out.println("Set Tester to own field 4, which are blue, \nand it allows him to buy houses, since he own all blue fields");
		street2.setOwner(user);
		System.out.println("Buy house");
		street1.setHouseAmount(1);
		System.out.println(street1.getName() + " has " + street1.getHouseAmount() + " houses");
		
	}

}
