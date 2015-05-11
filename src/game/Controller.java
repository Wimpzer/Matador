package game;

import java.sql.SQLException;
import java.util.ArrayList;

import boundary.GUIBoundary;
import database.Database;
import desktop_resources.GUI;
import user.User;
import field.*;

	/**
	 * This is the controller which includes the flow of the game.
	 * @author Bjarke
	 */

public class Controller {
	static ArrayList<User> users = new ArrayList<User>();
	static Board board = new Board();
	CardPile cardPile = new CardPile();
	static Dice diceCup = new Dice();
	Database databaseOb = new Database();
	HouseShopping houseShoppingOb = new HouseShopping();

	int userTurn = 0;

	/**
	 * The method called by the main class to begin a new game.
	 */
	
	public void run(){
		GUIBoundary.createBoard(board);
		try {
			startMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			game();
		} catch (Exception e) {
			try {
				System.out.println("Spillet blev lukket ned grundet en fejl. - Spillet er gemt.");
				saveGame();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}	

	/**
	 * Gives the player ability to load an old game from the database, or start a new game.
	 * If new game is started the player is asked for how many playing and the names
	 * of these.
	 * @throws SQLException
	 */
	
	public void startMenu() throws SQLException{
		boolean input = GUIBoundary.getUserLeftButtonPressed("Start nyt spil eller hent seneste gemte", "Nyt spil", "Seneste gemte");

		if(input == true){
			GUIBoundary.showMessage("Velkommen til spillet");
			int userAmount = GUIBoundary.getUserInteger("Indtast antal spillere", 2, 6);
			for (int i = 0; i < userAmount; i++) {
				int j = i+1;
				String userName = GUIBoundary.getUserString("Indtast navn på bruger nr. " + j);
				users.add(new User(userName, j, 0));
				GUIBoundary.addPlayer(users.get(i));
			}			
		}else if(input == false){
			loadGame();
		}
	}

	/**
	 * Loads the game from the database, by the help of database class, by loading all
	 * the stored info into the new, program, created game.
	 * @throws SQLException
	 */
	
	private void loadGame() throws SQLException {
		databaseOb.connectDatabase();
		users = databaseOb.loadGameUser();
		for (User user : users) {
			GUIBoundary.addPlayer(user);
		}
		userTurn = databaseOb.loadUserTurn();
		Brewery[] breweryArray = databaseOb.loadBrewery(users);
		Street[] streetArray = databaseOb.loadStreet(users);
		Shipping[] shippingArray = databaseOb.loadShipping(users);
		int breweryCounter = 0;
		int streetCounter = 0;
		int shippingCounter = 0;
		for (Field field : board.getFields()) {
			if(field instanceof Street){
				field.setFieldNumber(streetArray[streetCounter].getFieldNumber());
				((Street) field).setOwner(streetArray[streetCounter].getOwner());
				((Street) field).setHouseAmount(streetArray[streetCounter].getHouseAmount());
				((Street) field).setHotelAmount(streetArray[streetCounter++].getHotelAmount());
				if(((Street) field).getOwner() != null){
					GUIBoundary.setOwner(field.getFieldNumber(), ((Street) field).getOwner().getUserName());
				}
			} else if(field instanceof Brewery){
				field.setFieldNumber(breweryArray[breweryCounter].getFieldNumber());
				((Brewery) field).setOwner(breweryArray[breweryCounter++].getOwner());
				if(((Brewery) field).getOwner() != null){
					GUIBoundary.setOwner(field.getFieldNumber(), ((Brewery) field).getOwner().getUserName());
				}
			} else if(field instanceof Shipping){
				field.setFieldNumber(shippingArray[shippingCounter].getFieldNumber());
				((Shipping) field).setOwner(shippingArray[shippingCounter++].getOwner());

				if(((Shipping) field).getOwner() != null){
					GUIBoundary.setOwner(field.getFieldNumber(), ((Shipping) field).getOwner().getUserName());
				}
			}
		}

		GUIBoundary.showMessage("Dit gamle spil er hentet");
	}

	/**
	 * Includes the while-loop which will keep the game going until only one player is left.
	 * Besides the while-loop it allows the user to do pick one of five options to begin
	 * his turn.
	 */
	
	public void game(){
		while(users.size() > 1){
			User user = users.get(userTurn);

			String input = GUIBoundary.getUserButtonPressed(user.getUserName() + "'s tur.", "Slå", "Køb hus/hotel", "Byd på en gade", "Pantsæt", "Gem spil");
			if(input.equals("Slå")){
				takeTurn(user);
			}else if(input.equals("Køb hus/hotel")){
				buyHouse(user);
			}else if(input.equals("Byd på en gade")){
				try {
					streetBid(user);
				} catch (NullPointerException e) {
					GUIBoundary.showMessage("Der skete en fejl under bud af gade");
				}
			}else if(input.equals("Pantsæt")){
				pawnOrBuy(user);
			}else if(input.equals("Gem spil")){
				try {
					saveGame();
				} catch (SQLException e) {
					GUIBoundary.showMessage("Der skete en fejl under nedskrivningen af dit spil.");
				}
			}
		}
		GUIBoundary.showMessage(users.get(0).getUserName() + " har vundet spillet!");
	}

	/**
	 * Checks if the user is in jail or not, and do accordingly here after if he is.
	 * If the user is not in jail, it will call playerMove, and after checks which
	 * kind of field the user landed on.
	 * Will update the GUI with balance and location of the given user.
	 * At the end of the turn the method will check whether the users balance is still
	 * positive and if he should stay in the game.
	 * Ends up with updating the GUI with balances of all players.
	 * @param user The current user whose turn it is.
	 */
	
	private void takeTurn(User user) {
		{
			if (user.getInJail() == true) {
				user.setJailTimeCounter(user.getJailTimeCounter() + 1);
				board.getField(30).landOnField(user);
				GUIBoundary.setCar(user.getCurrentPosition()+1, user.getUserName());
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
				GUI.removeAllCars(user.getUserName());
				GUIBoundary.setCar(user.getCurrentPosition()+1, user.getUserName());
			}

			GUIBoundary.setBalance(user.getUserName(), user.getBalance());

			if(user.getBalance() <= 0){
				GUIBoundary.showMessage(user.getUserName() + " er gået fallit. Spillet er slut for dig");
				GUIBoundary.removeCar(user.getCurrentPosition()+1, user.getUserName());
				for (Field field : board.getFields()) {
					if(field instanceof Ownable){
						Ownable ownable = (Ownable) field;
						if(ownable.getOwner() == user){
							ownable.setOwner(null);
							GUIBoundary.removeOwner(ownable.getFieldNumber());
						}
					}
				}
				users.remove(userTurn);
			}else{
				users.set(userTurn, user);
			}

			for (int i = 0; i < users.size(); i++) {
				GUIBoundary.setBalance(users.get(i).getUserName(), users.get(i).getBalance());
			}

			if(userTurn >= users.size()-1){
				userTurn = 0;
			}else{
				userTurn++;
			}
		}
	}

	/**
	 * Allows the user to pick if he wants to buy or sell his houses on his owned streets.
	 * Depending on the users option will call the method belonging.
	 * @param user The current user whose turn it is.
	 */
	
	private void buyHouse(User user){

		boolean choice = GUIBoundary.getUserLeftButtonPressed("Køb eller sælg hus", "Køb", "Sælg");

		if(choice){
			try{
				houseShoppingOb.buyHouse(user, getBoard());
			}catch(NullPointerException e){
				GUIBoundary.showMessage("Du ejer ikke nok grunde af en farve");
			}
		}else{
			try {
				houseShoppingOb.sellHouse(user, board);	
			} catch (NullPointerException e) {
				GUIBoundary.showMessage("Du har ingen huse på dine grunde");
			}
		}
		GUIBoundary.setBalance(user.getUserName(), user.getBalance());
	}

	/**
	 * Will let the user pick another players own able fields to bid on.
	 * After picking the field, he will have to choose how much to bet
	 * where after the chosen player will have to accept or not.
	 * Updates both users balance and owner rights.
	 * @param user The current user whose turn it is.
	 */
	
	private void streetBid(User user) {
		String[] buttons = new String[users.size()];

		for (int i = 0; i < users.size(); i++)
			buttons[i] = Integer.toString(users.get(i).getUserNumber());

		String userNumber = GUIBoundary.getUserButtonPressed("Vælg hvilken spillers grund du vil byde på", buttons);

		int size = 0;
		String[] temp = new String[22];

		for (Field field : board.getFields()) 
			if(field instanceof Ownable)
				if(((Ownable) field).getOwner() != null)
					if(Integer.toString(((Ownable) field).getOwner().getUserNumber()).equals(userNumber))
						temp[size++] = field.getName();



		String[] fieldButtons = new String[size];

		for (int i = 0; i < fieldButtons.length; i++)
			fieldButtons[i] = temp[i];

		String fieldName = GUIBoundary.getUserButtonPressed("Vælg hvilken grund du vil byde på", fieldButtons);

		Ownable chosenField = null;

		for (Field field : board.getFields())
			if(field.getName().equals(fieldName))
				chosenField = (Ownable) field;

		boolean noHouses = true;

		if(chosenField instanceof Street){
			if(((Street) chosenField).getHouseAmount() > 0 || ((Street) chosenField).getHotelAmount() == 1){
				GUIBoundary.showMessage("Grunde med huse eller hotel kan ikke købes");
				noHouses = false;
			}
		}

		if(noHouses){
			int fieldBid = GUIBoundary.getUserInteger("Hvor meget vil du byde på " + fieldName, 0, 10000);

			boolean acceptedBid = false;
			User chosenUser = null;

			for (User oneUser : users)
				if(Integer.toString(oneUser.getUserNumber()).equals(userNumber)){
					chosenUser = oneUser;
					acceptedBid = GUIBoundary.getUserLeftButtonPressed("Acceptere du " + chosenUser.getUserName() + " budet på " + fieldBid + " for " + fieldName, "Ja", "Nej");
				}



			if(acceptedBid == true && chosenField != null){
				chosenField.setOwner(user);
				GUIBoundary.setOwner(chosenField.getFieldNumber(), user.getUserName());
				chosenUser.deposit(fieldBid);
				chosenUser.setGroundValue(chosenUser.getGroundValue() - chosenField.getFieldPrice());
				GUIBoundary.setBalance(chosenUser.getUserName(), chosenUser.getBalance());
				user.withdraw(fieldBid);
				user.setGroundValue(user.getGroundValue() - chosenField.getFieldPrice());
				GUIBoundary.setBalance(user.getUserName(), user.getBalance());

				GUIBoundary.showMessage("Ejerskabet er hermed overbragt");
			}
		}
	}

	/**
	 * Allows the user to pick if he wants to pawn or re-buy his fields.
	 * Depending on the users option will call the method belonging.
	 * @param user The current user whose turn it is.
	 */
	
	private void pawnOrBuy(User user){
		boolean pawnOrBuy = GUIBoundary.getUserLeftButtonPressed("Vil du pantsætte eller tilbagekøbe?", "Pantsæt", "Tilbagekøbe");

		if(pawnOrBuy == true){
			try {
				pawn(user);
			} catch (NullPointerException e) {
				GUIBoundary.showMessage("Du har ingen grunde til at pantsætte");
			}
		}else{
			try {
				buy(user);
			} catch (Exception e) {
				GUIBoundary.showMessage("Du har ingen pantsatte grunde");
			}
		}
	}

	/**
	 * Will let the user pick which own able field of his he wants to pawn.
	 * @param user The current user whose turn it is.
	 */
	
	private void pawn(User user) {
		String[] temp = new String[40];
		int size = 0;

		for (Field field : board.getFields())
			if(field instanceof Ownable){
				Ownable ownable = (Ownable) field;
				if(ownable.getOwner() == user && ownable.getFieldActive() == true)
					temp[size++] = field.getName();
			}

		String[] buttons = new String[size];

		for (int i = 0; i < buttons.length; i++)
			buttons[i] = temp[i];

		String fieldName = GUIBoundary.getUserButtonPressed("Hvilken grund vil du pantsætte?", buttons);

		Ownable chosenField = null;

		for (Field field : board.getFields())
			if(field.getName().equals(fieldName))
				chosenField = (Ownable) field;

		boolean choice = false;

		if(chosenField instanceof Street){
			if(((Street) chosenField).getHouseAmount() > 0 || ((Street) chosenField).getHotelAmount() == 1)
				GUIBoundary.showMessage("Du kan ikke pantsætte grunde med huse eller hoteller");
			else
				choice = GUIBoundary.getUserLeftButtonPressed("Pantsætning af " + chosenField.getName() + " vil give dig " + chosenField.getFieldPrice()/2, "Pantsæt", "Annuler");		
		}else
			choice = GUIBoundary.getUserLeftButtonPressed("Pantsætning af " + chosenField.getName() + " vil give dig " + chosenField.getFieldPrice()/2, "Pantsæt", "Annuler");

		if(choice == true){
			chosenField.setFieldActive(false);
			user.deposit(chosenField.getFieldPrice()/2);
			user.setGroundValue(user.getGroundValue() - chosenField.getFieldPrice()-2);
			GUIBoundary.setBalance(user.getUserName(), user.getBalance());
		}
	}

	/**
	 * Will let the user pick which pawned fields of his he wants to re-buy.
	 * @param user The current user whose turn it is.
	 */
	
	private void buy(User user) {
		String[] temp = new String[40];
		int size = 0;

		for (Field field : board.getFields())
			if(field instanceof Ownable){
				Ownable ownable = (Ownable) field;
				if(ownable.getOwner() == user && ownable.getFieldActive() == false)
					temp[size++] = field.getName();
			}

		String[] buttons = new String[size];

		for (int i = 0; i < buttons.length; i++)
			buttons[i] = temp[i];

		String fieldName = GUIBoundary.getUserButtonPressed("Hvilken grund vil du tilbagekøbe?", buttons);

		Ownable chosenField = null;

		for (Field field : board.getFields())
			if(field.getName().equals(fieldName))
				chosenField = (Ownable) field;

		boolean choice = GUIBoundary.getUserLeftButtonPressed("Tilbagekøbning af " + chosenField.getName() + " vil give dig " + chosenField.getFieldPrice()/2, "Tilbagekøb", "Annuler");

		if(choice == true){
			chosenField.setFieldActive(true);
			user.withdraw(chosenField.getFieldPrice()/2);
			user.setGroundValue(user.getGroundValue() + chosenField.getFieldPrice()-2);
			GUIBoundary.setBalance(user.getUserName(), user.getBalance());
		}
	}

	/**
	 * Saves the game with help of the database class.
	 * @throws SQLException
	 */
	
	private void saveGame() throws SQLException {
		int breweryAmount = 0;
		Brewery[] breweryFields = new Brewery[2];
		int shippingAmount = 0;
		Shipping[] shippingFields = new Shipping[4];
		int streetAmount = 0;
		Street[] streetFields = new Street[22];

		for(Field field : board.fields){
			if(field instanceof Brewery){
				Brewery brewery = (Brewery) field;
				breweryFields[breweryAmount++] = brewery;
			}else if(field instanceof Shipping){
				Shipping shipping = (Shipping) field;
				shippingFields[shippingAmount++] = shipping;
			}else if(field instanceof Street){
				Street street = (Street) field;
				streetFields[streetAmount++] = street;
			}
		}

		databaseOb.saveGame(users, breweryFields, shippingFields, streetFields, userTurn);
	}

	/**
	 * Rolls the dice cup and moves the user the amount of eyes show on the dices.
	 * If the user passes start he gets 4000,-.
	 * @param user The current user whose turn it is.
	 */
	
	private void playerMove(User user) {
		diceCup.roll();
		GUIBoundary.setDice(diceCup.getFaceValue1(), diceCup.getFaceValue2());
		if(user.getCurrentPosition()+diceCup.getSum() > 39){
			user.setCurrentPosition(user.getCurrentPosition() + diceCup.getSum()-40);
			user.deposit(4000);
			GUIBoundary.setBalance(user.getUserName(), user.getBalance());
		}else{
			user.setCurrentPosition(user.getCurrentPosition() + diceCup.getSum());
		}
		GUIBoundary.setCar(user.getCurrentPosition()+1, user.getUserName());
	}

	/**
	 * Checks whether or not the field the user are on is a Street.
	 * If so checks if it's owned or not.
	 * Allows the user to buy the field if not owned, else it will
	 * pay the rent to the current owner, if not the user himself.
	 * @param user The current user whose turn it is.
	 */
	
	private void instanceOfStreet(User user) {
		if(board.getField(user.getCurrentPosition()) instanceof Street){
			if(((Street) board.getField(user.getCurrentPosition())).getOwner() == null){
				boolean input = GUIBoundary.getUserLeftButtonPressed("Feltet er frit, vil du købe det?", "Ja", "Nej");
				if(input == true){
					if(((Street)board.getField(user.getCurrentPosition())).getFieldPrice() > user.getBalance()){
						boolean inputSure = GUIBoundary.getUserLeftButtonPressed("Købet vil få dig til at gå falit, er du sikker?", "Ja", "Nej");
						if(inputSure == true){
							boughtField(user, "Street");
						}
					}else{					
						boughtField(user, "Street");
					}
				}
			}else if(((Street) board.getField(user.getCurrentPosition())).getOwner() == user){
				GUIBoundary.showMessage("Du ejer allerede dette felt");
			}else{
				if(((Street) board.getField(user.getCurrentPosition())).getFieldActive() == true)
					payRent(user);
			}
		}
	}

	/**
	 * Checks whether or not the field the user are on is a Brewery.
	 * If so checks if it's owned or not.
	 * Allows the user to buy the field if not owned, else it will
	 * pay the rent to the current owner, if not the user himself.
	 * @param user The current user whose turn it is.
	 */
	
	private void instanceOfBrewery(User user) {
		if(board.getField(user.getCurrentPosition()) instanceof Brewery){
			if(((Brewery) board.getField(user.getCurrentPosition())).getOwner() == null){
				boolean input = GUIBoundary.getUserLeftButtonPressed("Feltet er frit, vil du købe det?", "Ja", "Nej");
				if(input == true){
					if(((Brewery)board.getField(user.getCurrentPosition())).getFieldPrice() > user.getBalance()){
						boolean inputSure = GUIBoundary.getUserLeftButtonPressed("Købet vil få dig til at gå falit, er du sikker?", "Ja", "Nej");
						if(inputSure == true){
							boughtField(user, "Brewery");
						}
					}else{					
						boughtField(user, "Brewery");
					}
				}
			}else if(((Brewery) board.getField(user.getCurrentPosition())).getOwner() == user){
				GUIBoundary.showMessage("Du ejer allerede dette felt");
			}else{
				if(((Brewery) board.getField(user.getCurrentPosition())).getFieldActive() == true)
					payRent(user);
			}
		}
	}

	/**
	 * Checks whether or not the field the user are on is a Shipping.
	 * If so checks if it's owned or not.
	 * Allows the user to buy the field if not owned, else it will
	 * pay the rent to the current owner, if not the user himself.
	 * @param user The current user whose turn it is.
	 */
	
	private void instanceOfShipping(User user) {
		if(board.getField(user.getCurrentPosition()) instanceof Shipping){
			if(((Shipping) board.getField(user.getCurrentPosition())).getOwner() == null){
				boolean input = GUIBoundary.getUserLeftButtonPressed("Feltet er frit, vil du købe det?", "Ja", "Nej");
				if(input == true){
					if(((Shipping)board.getField(user.getCurrentPosition())).getFieldPrice() > user.getBalance()){
						boolean inputSure = GUIBoundary.getUserLeftButtonPressed("Købet vil få dig til at gå falit, er du sikker?", "Ja", "Nej");
						if(inputSure == true){
							boughtField(user, "Shipping");
						}
					}else{					
						boughtField(user, "Shipping");
					}
				}
			}else if(((Shipping) board.getField(user.getCurrentPosition())).getOwner() == user){
				GUIBoundary.showMessage("Du ejer allerede dette felt");
			}else{
				if(((Shipping) board.getField(user.getCurrentPosition())).getFieldActive() == true)
					payRent(user);
			}
		}
	}

	/**
	 * Checks whether or not the field the user are on is Taxes.
	 * If so it will withdraw the taxes, amount depending on which
	 * of the two taxes the user landed on.
	 * @param user The current user whose turn it is.
	 */
	
	private void instanceOfTaxes(User user){
		if(board.getField(user.getCurrentPosition()) instanceof Taxes){
			if(user.getCurrentPosition() == 4){
				boolean input = GUIBoundary.getUserLeftButtonPressed("Betal indkomstskat: 10% eller 4000 kr.", "10 %", "4000 kr.");
				if(input == true){
					int tax = (int) (user.getBalance()*0.1);
					user.withdraw(tax);
				}else{
					board.getField(user.getCurrentPosition()).landOnField(user);
				}
			}else if(user.getCurrentPosition() == 38){
				GUIBoundary.showMessage("Ekstraordinær statsskat: Betal 2000 kr.");
				board.getField(user.getCurrentPosition()).landOnField(user);
			}

		}
	}

	/**
	 * Method called if the user decides to buy the field.
	 * Will update the needed variables. 
	 * @param user The current user whose turn it is.
	 * @param fieldType Used for determine if field is a instance of shipping or brewery.
	 */
	
	private void boughtField(User user, String fieldType) {
		GUIBoundary.showMessage("Du har købt feltet " + board.getField(user.getCurrentPosition()).getName());
		if(fieldType.equals("Shipping"))
			user.setOwnedShipping(user.getOwnedShipping()+1);
		if(fieldType.equals("Brewery"))
			user.setOwnedBrewery(user.getOwnedBrewery()+1);
		((Ownable) board.getField(user.getCurrentPosition())).landOnField(user);
		GUIBoundary.setOwner(user.getCurrentPosition()+1, user.getUserName());
	}

	/**
	 * Method called if the user lands on a field that is owned.
	 * Will pay the correct rent, depending on houses or hotels
	 * and if all fields of the same colour are owned.
	 * @param user The current user whose turn it is.
	 */
	
	private void payRent(User user) {
		if(board.getField(user.getCurrentPosition()) instanceof Street && (((Street) board.getField(user.getCurrentPosition())).getHouseAmount() > 0 || ((Street) board.getField(user.getCurrentPosition())).getHotelAmount() == 1)){
			int houseAmount = ((Street) board.getField(user.getCurrentPosition())).getHouseAmount();
			int extraRent = 0;
			if(houseAmount == 1)
				extraRent = ((Street) board.getField(user.getCurrentPosition())).getRentHouse1();
			else if(houseAmount == 2)
				extraRent = ((Street) board.getField(user.getCurrentPosition())).getRentHouse2();
			else if(houseAmount == 3)
				extraRent = ((Street) board.getField(user.getCurrentPosition())).getRentHouse3();
			else if(houseAmount == 4)
				extraRent = ((Street) board.getField(user.getCurrentPosition())).getRentHouse4();
			else if(((Street) board.getField(user.getCurrentPosition())).getHotelAmount() == 1)
				extraRent = ((Street) board.getField(user.getCurrentPosition())).getRentHotel();
			GUIBoundary.showMessage("Feltet ejes af " + ((Ownable)board.getField(user.getCurrentPosition())).getOwner().getUserName() + ". Betal leje af: " + extraRent);
			user.withdraw(extraRent);
			((Ownable) board.getField(user.getCurrentPosition())).getOwner().deposit(extraRent);
		}else{
			((Ownable) board.getField(user.getCurrentPosition())).rent();
			board.getField(user.getCurrentPosition()).landOnField(user);
			GUIBoundary.showMessage("Feltet ejes af " + ((Ownable)board.getField(user.getCurrentPosition())).getOwner().getUserName() + ". Betal leje af: " + ((Ownable) board.getField(user.getCurrentPosition())).rent());
			((Ownable) board.getField(user.getCurrentPosition())).setRentPrice();
		}
	}

	/**
	 * Method used if field class needs to know the sum of the
	 * dices.
	 * @return The sum of the two dices in the dice cup.
	 */
	
	public static int getSum(){
		return diceCup.getSum();
	}

	/**
	 * Counts the amount of houses a certain user owns
	 * @param user The user the game needs to know the amount of owned houses.
	 * @return The amount of owned houses.
	 */
	
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

	/**
	 * Counts the amount of hotels a certain user owns
	 * @param user The user the game needs to know the amount of owned hotels.
	 * @return The amount of owned hotels.
	 */
	
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

	/**
	 * Method used if another class needs to know the users.
	 * @return Returns the list of users.
	 */
	
	public static ArrayList<User> getUserList(){
		return users;
	}

	/**
	 * Method used if another class needs to know the board.
	 * @return Returns the game board.
	 */
	
	public static Board getBoard(){
		return board;
	}

}
