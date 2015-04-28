package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import user.User;
import field.*;

/**
 * @author Bjarke
 *
 */

public class Database {

	String url = "jdbc:mysql://82.211.212.144:3306";
	String DBuser = "user";
	String DBpassword = "123QWEasd";
	Connection conn;
	Statement stt;

	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, DBuser, DBpassword);
		}catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void connectDatabase() throws SQLException{
		PreparedStatement connectDatabase = conn.prepareStatement("USE matador");
		connectDatabase.execute();
	}

	/**
	 * Methods for saving the game
	 * 
	 * @param users
	 * @param fields
	 * @param userTurn
	 * @throws SQLException
	 */

	public void deleteAll() throws SQLException{
		PreparedStatement deleteAll;
		String deleteAllString = "DELETE FROM brewery";
		deleteAll = conn.prepareStatement(deleteAllString);
		deleteAll.execute();

		deleteAllString = "DELETE FROM shipping";
		deleteAll = conn.prepareStatement(deleteAllString);
		deleteAll.execute();

		deleteAllString = "DELETE FROM street";
		deleteAll = conn.prepareStatement(deleteAllString);
		deleteAll.execute();

		deleteAllString = "DELETE FROM controller";
		deleteAll = conn.prepareStatement(deleteAllString);
		deleteAll.execute();

		deleteAllString = "DELETE FROM user";
		deleteAll = conn.prepareStatement(deleteAllString);
		deleteAll.execute();
	}

	public void saveGame(ArrayList<User> users, Brewery[] breweryFields, Shipping[] shippingFields, Street[] streetFields, int userTurn) throws SQLException{
		connectDatabase();
		deleteAll();
		saveBank();
		saveUsers(users);
		saveBrewery(breweryFields);
		saveShipping(shippingFields);
		saveStreet(streetFields);
		saveUserTurn(userTurn);
	}

	private void saveUsers(ArrayList<User> users) throws SQLException{
		PreparedStatement saveUsers;
		String saveUsersString = "INSERT INTO user (userNumber, userName, currentPosition, balance) VALUES (?, ?, ?, ?)";

		saveUsers = conn.prepareStatement(saveUsersString);

		for (int i = 0; i < users.size(); i++) {
			saveUsers.setInt(1, users.get(i).getUserNumber());
			saveUsers.setString(2, users.get(i).getUserName());
			saveUsers.setInt(3, users.get(i).getCurrentPosition());
			saveUsers.setInt(4, users.get(i).getBalance());
			saveUsers.executeUpdate();
		}
	}

	private void saveBank() throws SQLException{
		PreparedStatement saveUsers;
		String saveUsersString = "INSERT INTO user (userNumber, userName, currentPosition, balance) VALUES (?, ?, ?, ?)";

		saveUsers = conn.prepareStatement(saveUsersString);

		saveUsers.setInt(1, 0);
		saveUsers.setString(2, "Bank");
		saveUsers.setInt(3, 0);
		saveUsers.setInt(4, 0);
		saveUsers.executeUpdate();
	}

	//For streets
	private void saveStreet(Street[] fields) throws SQLException{
		PreparedStatement saveGame;
		String saveGameString = "INSERT INTO street (fieldNumber, ownerNumber, houseAmount, hotelAmount) VALUES (?, ?, ?, ?)";

		saveGame = conn.prepareStatement(saveGameString);

		for (int i = 0; i < fields.length; i++) {
			saveGame.setInt(1, fields[i].getFieldNumber());
			if(fields[i].getOwner() != null){
				saveGame.setInt(2, fields[i].getOwner().getUserNumber());
			}else{
				saveGame.setInt(2, 0);
			}
			saveGame.setInt(3, fields[i].getHouseAmount());
			saveGame.setInt(4, fields[i].getHotelAmount());
			saveGame.executeUpdate();
		}
	}

	//For Brewery
	private void saveBrewery(Brewery[] fields) throws SQLException{
		PreparedStatement saveGame;
		String saveGameString = "INSERT INTO brewery (fieldNumber, ownerNumber) VALUES (?, ?)";

		saveGame = conn.prepareStatement(saveGameString);

		for (int i = 0; i < fields.length; i++) {
			saveGame.setInt(1, fields[i].getFieldNumber());
			if(fields[i].getOwner() != null){
				saveGame.setInt(2, fields[i].getOwner().getUserNumber());
			}else{
				saveGame.setInt(2, 0);
			}
			saveGame.executeUpdate();
		}
	}

	//For shipping
	private void saveShipping(Shipping[] fields) throws SQLException{
		PreparedStatement saveGame;
		String saveGameString = "INSERT INTO shipping (fieldNumber, ownerNumber) VALUES (?, ?)";

		saveGame = conn.prepareStatement(saveGameString);

		for (int i = 0; i < fields.length; i++) {
			saveGame.setInt(1, fields[i].getFieldNumber());
			if(fields[i].getOwner() != null){
				saveGame.setInt(2, fields[i].getOwner().getUserNumber());
			}else{
				saveGame.setInt(2, 0);
			}
			saveGame.executeUpdate();
		}
	}

	private void saveUserTurn(int userTurn) throws SQLException {
		PreparedStatement saveGame;
		String saveGameString = "INSERT INTO controller (userTurn) VALUES (?)";

		saveGame = conn.prepareStatement(saveGameString);
		saveGame.setInt(1, userTurn);

		saveGame.executeUpdate();
	}

	/**
	 * Methods for loading the game
	 * 
	 * @return
	 * @throws SQLException
	 */

	public ArrayList<User> loadGameUser() throws SQLException{
		int userNumber;
		String userName;
		int currentPosition;
		int balance;
		ArrayList<User> users = new ArrayList<User>();

		PreparedStatement loadGameUser;
		String loadGameUserString = "SELECT * FROM user";

		loadGameUser = conn.prepareStatement(loadGameUserString);

		ResultSet res = loadGameUser.executeQuery();

		while(res.next()){
			if(res.getInt("userNumber") != 0){
			userNumber = res.getInt("userNumber");
			userName = res.getString("userName");
			currentPosition = res.getInt("currentPosition");
			balance = res.getInt("balance");
			User user = new User(userName, userNumber, currentPosition);
			user.deposit(balance);
			users.add(user);
			}
		}		
		return users;
	}

	//for street
	public Street[] loadStreet(ArrayList<User> users) throws SQLException{
		int fieldNumber;
		int ownerNumber;
		int houseAmount;
		int hotelAmount;
		int i = 0;
		Street[] fields = new Street[22];

		PreparedStatement loadFields;
		String loadFieldsString = "SELECT * FROM street";

		loadFields = conn.prepareStatement(loadFieldsString);

		ResultSet res = loadFields.executeQuery();

		while(res.next()){
			fieldNumber = res.getInt("fieldNumber");
			ownerNumber = res.getInt("ownerNumber");
			houseAmount = res.getInt("houseAmount");
			hotelAmount = res.getInt("hotelAmount");
			
			fields[i] = new Street(fieldNumber, "", 0, 0, 0, 0, 0, 0, 0, 0, null);
			fields[i].setHouseAmount(houseAmount);
			fields[i].setHotelAmount(hotelAmount);

			for (User user : users) {
				if(ownerNumber == user.getUserNumber()){
					fields[i].setOwner(user);
				}
			}
			i++;
		}

		return fields;
	}

	//for brewery
	public Brewery[] loadBrewery(ArrayList<User> users) throws SQLException{
		int fieldNumber;
		int ownerNumber;
		int i = 0;
		Brewery[] fields = new Brewery[2];

		PreparedStatement loadFields;
		String loadFieldsString = "SELECT * FROM brewery";

		loadFields = conn.prepareStatement(loadFieldsString);

		ResultSet res = loadFields.executeQuery();

		while(res.next()){
			fieldNumber = res.getInt("fieldNumber");
			ownerNumber = res.getInt("ownerNumber");

			fields[i] = new Brewery(fieldNumber, " ", 0);

			for (User user : users) {
				if(ownerNumber == user.getUserNumber()){
					fields[i].setOwner(user);
				}
			}
			i++;
		}

		return fields;
	}

	//for shipping
	public Shipping[] loadShipping(ArrayList<User> users) throws SQLException{
		int fieldNumber;
		int ownerNumber;
		int i = 0;
		Shipping[] fields = new Shipping[4];

		PreparedStatement loadFields;
		String loadFieldsString = "SELECT * FROM shipping";

		loadFields = conn.prepareStatement(loadFieldsString);

		ResultSet res = loadFields.executeQuery();

		while(res.next()){
			fieldNumber = res.getInt("fieldNumber");
			ownerNumber = res.getInt("ownerNumber");

			fields[i] = new Shipping(fieldNumber, " ", 0);

			for (User user : users) {
				if(ownerNumber == user.getUserNumber()){
					fields[i].setOwner(user);
				}
			}

			i++;
		}

		return fields;
	}

	public int loadUserTurn() throws SQLException{
		int userTurn = 0;

		PreparedStatement loadUserTurn;
		String loadUserTurnString = "SELECT userTurn FROM controller";

		loadUserTurn = conn.prepareStatement(loadUserTurnString);

		ResultSet res = loadUserTurn.executeQuery();

		while(res.next()){
			userTurn = res.getInt("userTurn");
		}

		return userTurn;
	}

}

