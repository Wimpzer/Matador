package game;

import java.util.ArrayList;
import desktop_resources.*;
import user.User;
import field.*;

public class Controller {
	ArrayList<User> users = new ArrayList<User>();
	Board board = new Board();
	static Dice diceCup = new Dice();
	int playerTurn = 0;

	public void run(){
		//				startMenu();
		testMenu();
		game();
	}

	//TEST MENU
	public void testMenu(){
		users.add(new User("Bjarke", 1, 0));
		GUI.addPlayer(users.get(0).getUserName(), users.get(0).getBalance());
		GUI.setCar(1, "Bjarke");
		users.add(new User("Joakim", 2, 0));
		GUI.addPlayer(users.get(1).getUserName(), users.get(1).getBalance());
		GUI.setCar(1, "Joakim");
	}	

	public void startMenu(){
		boolean input = GUI.getUserLeftButtonPressed("Start nyt spil eller hent seneste gemte", "Nyt spil", "Seneste gemte");

		if(input == true){
			GUI.showMessage("Velkommen til spillet");
			int userAmount = GUI.getUserInteger("Indtast antal spillere", 2, 6);
			for (int i = 0; i < userAmount; i++) {
				int j = i+1;
				String userName = GUI.getUserString("Indtast navn på bruger nr. " + j);
				users.add(new User(userName, j, 0));
				GUI.addPlayer(users.get(i).getUserName(), users.get(i).getBalance());
				GUI.setCar(1, userName);
			}			
		}else if(input == false){
			GUI.showMessage("Dit gamle spil er hentet");
		}
	}

	public void game(){
		while(users.size() > 1){
			User user = users.get(playerTurn);
			if (user.getInJail() == true) {
				user.setJailTimeCounter(user.getJailTimeCounter() + 1);
				board.getFields()[30].landOnField(user);
				if (user.getJailTimeCounter() == 3) {
					user.withdraw(1000);
					user.setInJail(false);
				}
			}else{
				playerMove(user);
				instanceOfShipping(user);
				instanceOfBrewery(user);
				instanceOfStreet(user);
				if(board.getFields()[user.getCurrentPosition()] instanceof Start || board.getFields()[user.getCurrentPosition()] instanceof Refuge || board.getFields()[user.getCurrentPosition()] instanceof Jail || board.getFields()[user.getCurrentPosition()] instanceof Taxes || board.getFields()[user.getCurrentPosition()] instanceof Chance){
					board.getFields()[user.getCurrentPosition()].landOnField(user);
				}
			}

			GUI.setBalance(user.getUserName(), user.getBalance());

			if(user.getBalance() <= 0){
				GUI.showMessage(user.getUserName() + "er gået fallit. Spillet er slut for dig");
				users.remove(playerTurn);
			}else{
				users.set(playerTurn, user);
			}

			for (int i = 0; i < users.size(); i++) {
				GUI.setBalance(users.get(i).getUserName(), users.get(i).getBalance());
			}
			
			if(playerTurn == users.size()-1){
				playerTurn = 0;
			}else{
				playerTurn++;
			}
		}
		GUI.showMessage(users.get(0).getUserName() + " har vundet spillet!");
	}

	private void playerMove(User user) {
		GUI.showMessage("Det er spiller " + user.getUserNumber() + "'s tur" + " - Slå med terninger");
		diceCup.roll();
		GUI.setDice(diceCup.getFaceValue1(), diceCup.getFaceValue2());
		GUI.removeCar(user.getCurrentPosition()+1, user.getUserName());
		if(user.getCurrentPosition()+diceCup.getSum() > 39){
			user.setCurrentPosition(user.getCurrentPosition() + diceCup.getSum()-40);
			user.deposit(4000);
		}else{
			user.setCurrentPosition(user.getCurrentPosition() + diceCup.getSum());
		}
		GUI.setCar(user.getCurrentPosition()+1, user.getUserName());
	}

	private void instanceOfStreet(User user) {
		if(board.getFields()[user.getCurrentPosition()] instanceof Street){
			if(((Street) board.getFields()[user.getCurrentPosition()]).getOwner() == null){
				boolean input = GUI.getUserLeftButtonPressed("Feltet er frit, vil du købe det?", "Ja", "Nej");
				if(input == true){
					GUI.showMessage("Du har købt feltet " + board.getFields()[user.getCurrentPosition()].getName());
					user.setOwnedShipping(user.getOwnedShipping()+1);
					((Ownable) board.getFields()[user.getCurrentPosition()]).landOnField(user);
				}
			}else{
				GUI.showMessage("Feltet ejes af " + ((Ownable)board.getFields()[user.getCurrentPosition()]).getOwner().getUserName());
				((Ownable) board.getFields()[user.getCurrentPosition()]).rent();
				board.getFields()[user.getCurrentPosition()].landOnField(user);
			}
		}
	}

	private void instanceOfBrewery(User user) {
		if(board.getFields()[user.getCurrentPosition()] instanceof Brewery){
			if(((Brewery) board.getFields()[user.getCurrentPosition()]).getOwner() == null){
				boolean input = GUI.getUserLeftButtonPressed("Feltet er frit, vil du købe det?", "Ja", "Nej");
				if(input == true){
					GUI.showMessage("Du har købt feltet " + board.getFields()[user.getCurrentPosition()].getName());
					user.setOwnedShipping(user.getOwnedShipping()+1);
					((Ownable) board.getFields()[user.getCurrentPosition()]).landOnField(user);
				}
			}else{
				GUI.showMessage("Feltet ejes af " + ((Ownable)board.getFields()[user.getCurrentPosition()]).getOwner().getUserName());
				((Ownable) board.getFields()[user.getCurrentPosition()]).rent();
				board.getFields()[user.getCurrentPosition()].landOnField(user);
			}
		}
	}

	private void instanceOfShipping(User user) {
		if(board.getFields()[user.getCurrentPosition()] instanceof Shipping){
			if(((Shipping) board.getFields()[user.getCurrentPosition()]).getOwner() == null){
				boolean input = GUI.getUserLeftButtonPressed("Feltet er frit, vil du købe det?", "Ja", "Nej");
				if(input == true){
					GUI.showMessage("Du har købt feltet " + board.getFields()[user.getCurrentPosition()].getName());
					user.setOwnedShipping(user.getOwnedShipping()+1);
					((Ownable) board.getFields()[user.getCurrentPosition()]).landOnField(user);
				}
			}else{
				GUI.showMessage("Feltet ejes af " + ((Ownable)board.getFields()[user.getCurrentPosition()]).getOwner().getUserName());
				((Ownable) board.getFields()[user.getCurrentPosition()]).rent();
				board.getFields()[user.getCurrentPosition()].landOnField(user);
			}
		}
	}

	public static int getSum(){ //TODO: Skal denne være static ?
		return diceCup.getSum();
	}
}
