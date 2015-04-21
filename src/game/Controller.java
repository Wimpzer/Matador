package game;

import java.util.ArrayList;

import boundary.GUIController;
import desktop_resources.*;
import user.User;
import field.*;

public class Controller {
	static ArrayList<User> users = new ArrayList<User>();
	static Board board = new Board();
	static Dice diceCup = new Dice();
	int playerTurn = 0;

	public void run(){
		//						startMenu();
		testMenu();
		game();
	}

	//TEST MENU
	public void testMenu(){
//		GUIController.createBoard(board);
		users.add(new User("Bjarke", 1, 0));
		GUIController.addPlayer(users.get(0));
		users.add(new User("Joakim", 2, 0));
		GUI.addPlayer(users.get(1).getUserName(), users.get(1).getBalance());
		GUI.setCar(users.get(0).getCurrentPosition()+1, "Joakim");
		users.add(new User("Andreas", 3, 0));
		GUI.addPlayer(users.get(2).getUserName(), users.get(2).getBalance());
		GUI.setCar(users.get(0).getCurrentPosition()+1, "Andreas");
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
				GUI.setCar(users.get(0).getCurrentPosition(), userName);
			}			
		}else if(input == false){
			GUI.showMessage("Dit gamle spil er hentet");
		}
	}

	public void game(){
		while(users.size() > 1){
			User user = users.get(playerTurn);
			if (user.getInJail() == true) { //TODO: Må man købe når man kommer ud?
				user.setJailTimeCounter(user.getJailTimeCounter() + 1);
				board.getField(30).landOnField(user);
				GUI.removeCar(31, user.getUserName());
				GUI.setCar(user.getCurrentPosition()+1, user.getUserName());
			}else{
				playerMove(user);
				if(board.getField(user.getCurrentPosition()) instanceof Jail){
					board.getField(user.getCurrentPosition()).landOnField(user);
				}
			}
			instanceOfShipping(user);
			instanceOfBrewery(user);
			instanceOfStreet(user);
			instanceOfTaxes(user);
			if(board.getField(user.getCurrentPosition()) instanceof Start || board.getField(user.getCurrentPosition()) instanceof Refuge || board.getField(user.getCurrentPosition()) instanceof Chance){
				board.getField(user.getCurrentPosition()).landOnField(user);
			}

			GUI.setBalance(user.getUserName(), user.getBalance());

			if(user.getBalance() <= 0){
				GUI.showMessage(user.getUserName() + " er gået fallit. Spillet er slut for dig");
				GUI.removeCar(user.getCurrentPosition()+1, user.getUserName());
				for (Field field : board.getFields()) {
					if(field instanceof Ownable){
						Ownable ownable = (Ownable) field;
						if(ownable.getOwner() == user){
							ownable.setOwner(null);
							GUI.removeOwner(ownable.getFieldNumber());
						}
					}
				}
				users.remove(playerTurn);
			}else{
				users.set(playerTurn, user);
			}

			for (int i = 0; i < users.size(); i++) {
				GUI.setBalance(users.get(i).getUserName(), users.get(i).getBalance());
			}

			if(playerTurn >= users.size()-1){
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
		if(board.getField(user.getCurrentPosition()) instanceof Street){
			if(((Street) board.getField(user.getCurrentPosition())).getOwner() == null){
				boolean input = GUI.getUserLeftButtonPressed("Feltet er frit, vil du købe det?", "Ja", "Nej");
				if(input == true){
					if(((Street)board.getField(user.getCurrentPosition())).getFieldPrice() > user.getBalance()){
						boolean inputSure = GUI.getUserLeftButtonPressed("Købet vil få dig til at gå falit, er du sikker?", "Ja", "Nej");
						if(inputSure == true){
							boughtField(user, "Street");
						}
					}else{					
						boughtField(user, "Street");
					}
				}
			}else if(((Street) board.getField(user.getCurrentPosition())).getOwner() == user){
				GUI.showMessage("Du ejer allerede dette felt");
			}else{
				payRent(user);
			}
		}
	}

	private void instanceOfBrewery(User user) {
		if(board.getField(user.getCurrentPosition()) instanceof Brewery){
			if(((Brewery) board.getField(user.getCurrentPosition())).getOwner() == null){
				boolean input = GUI.getUserLeftButtonPressed("Feltet er frit, vil du købe det?", "Ja", "Nej");
				if(input == true){
					if(((Brewery)board.getField(user.getCurrentPosition())).getFieldPrice() > user.getBalance()){
						boolean inputSure = GUI.getUserLeftButtonPressed("Købet vil få dig til at gå falit, er du sikker?", "Ja", "Nej");
						if(inputSure == true){
							boughtField(user, "Brewery");
						}
					}else{					
						boughtField(user, "Brewery");
					}
				}
			}else if(((Brewery) board.getField(user.getCurrentPosition())).getOwner() == user){
				GUI.showMessage("Du ejer allerede dette felt");
			}else{
				payRent(user);
			}
		}
	}

	private void instanceOfShipping(User user) {
		if(board.getField(user.getCurrentPosition()) instanceof Shipping){
			if(((Shipping) board.getField(user.getCurrentPosition())).getOwner() == null){
				boolean input = GUI.getUserLeftButtonPressed("Feltet er frit, vil du købe det?", "Ja", "Nej");
				if(input == true){
					if(((Shipping)board.getField(user.getCurrentPosition())).getFieldPrice() > user.getBalance()){
						boolean inputSure = GUI.getUserLeftButtonPressed("Købet vil få dig til at gå falit, er du sikker?", "Ja", "Nej");
						if(inputSure == true){
							boughtField(user, "Shipping");
						}
					}else{					
						boughtField(user, "Shipping");
					}
				}
			}else if(((Shipping) board.getField(user.getCurrentPosition())).getOwner() == user){
				GUI.showMessage("Du ejer allerede dette felt");
			}else{
				payRent(user);
			}
		}
	}

	private void instanceOfTaxes(User user){
		if(board.getField(user.getCurrentPosition()) instanceof Taxes){
			if(user.getCurrentPosition() == 4){
				boolean input = GUI.getUserLeftButtonPressed("Betal indkomstskat: 10% eller 4000 kr.", "10 %", "4000 kr.");
				if(input == true){
					int tax = (int) (user.getBalance()*0.1);
					user.withdraw(tax);
				}else{
					board.getField(user.getCurrentPosition()).landOnField(user);
				}
			}else if(user.getCurrentPosition() == 38){
				GUI.showMessage("Ekstraordinær statsskat: Betal 2000 kr.");
				board.getField(user.getCurrentPosition()).landOnField(user);
			}

		}
	}

	private void boughtField(User user, String fieldType) {
		GUI.showMessage("Du har købt feltet " + board.getField(user.getCurrentPosition()).getName());
		if(fieldType.equals("Shipping"))
			user.setOwnedShipping(user.getOwnedShipping()+1);
		if(fieldType.equals("Brewery"))
			user.setOwnedBrewery(user.getOwnedBrewery()+1);
		((Ownable) board.getField(user.getCurrentPosition())).landOnField(user);
		GUI.setOwner(user.getCurrentPosition()+1, user.getUserName());
	}

	private void payRent(User user) { //TODO: Virker ikke ordenligt!
		GUI.showMessage("Feltet ejes af " + ((Ownable)board.getField(user.getCurrentPosition())).getOwner().getUserName() + ". Betal leje af: " + ((Ownable) board.getField(user.getCurrentPosition())).rent());
		((Ownable) board.getField(user.getCurrentPosition())).rent();
		board.getField(user.getCurrentPosition()).landOnField(user);
	}

	public static int getSum(){ //TODO: Skal denne være static ?
		return diceCup.getSum();
	}

	public static int getHouseAmount(User user){
		int amount = 0;

		for (Field field : board.getFields()) {
			if(field instanceof Street){
				Street street = (Street) field;
				amount += street.getHouseAmount();
			}
		}
		return amount;
	}

	public static int getHotelAmount(User user){
		int amount = 0;

		for (Field field : board.getFields()) {
			if(field instanceof Street){
				Street street = (Street) field;
				amount += street.getHotelAmount();
			}
		}
		return amount;
	}

	public static ArrayList<User> getUserList(){
		return users;
	}

	public static Board getBoard(){
		return board;
	}

}
