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

	public void saveGame(User[] users, Brewery[] breweryFields, Shipping[] shippingFields, Street[] streetFields, int userTurn) throws SQLException{
		saveUsers(users);
		saveBrewery(breweryFields);
		saveShipping(shippingFields);
		saveStreet(streetFields);
		saveUserTurn(userTurn);
	}

	private void saveUsers(User[] users) throws SQLException{
		PreparedStatement saveUsers;
		String saveUsersString = "INSERT INTO user (userNumber, userName, currentPosition, balance) VALUES (?, ?, ?, ?)";

		saveUsers = conn.prepareStatement(saveUsersString);

		for (int i = 0; i < users.length; i++) {
			saveUsers.setInt(1, users[i].getUserNumber());
			saveUsers.setString(2, users[i].getUserName());
			saveUsers.setInt(3, users[i].getCurrentPosition());
			saveUsers.setInt(4, users[i].getBalance());
			saveUsers.executeUpdate();
		}
	}

	//For streets
	private void saveStreet(Street[] fields) throws SQLException{
		PreparedStatement saveGame;
		String saveGameString = "INSERT INTO street (fieldNumber, ownerNumber, houseAmount, hotelAmount) VALUES (?, ?, ?, ?)";

		saveGame = conn.prepareStatement(saveGameString);

		for (int i = 0; i < fields.length; i++) {
			saveGame.setInt(1, i);
			saveGame.setInt(2, fields[i].getOwner());
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
			saveGame.setInt(1, i);
			saveGame.setInt(2, fields[i].getOwner());
			saveGame.executeUpdate();
		}
	}
	
	//For shipping
	private void saveShipping(Shipping[] fields) throws SQLException{
		PreparedStatement saveGame;
		String saveGameString = "INSERT INTO shipping (fieldNumber, ownerNumber) VALUES (?, ?)";

		saveGame = conn.prepareStatement(saveGameString);

		for (int i = 0; i < fields.length; i++) {
			saveGame.setInt(1, i);
			saveGame.setInt(2, fields[i].getOwner());
			saveGame.executeUpdate();
		}
	}

	private void saveUserTurn(int userTurn) throws SQLException {
		stt.executeUpdate("INSERT INTO controller " + "(userTurn) VALUES ('" + userTurn + "')");
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
			userNumber = res.getInt("userNumber");
			userName = res.getString("userName");
			currentPosition = res.getInt("currentPosition");
			balance = res.getInt("balance");
			User user = new User(userName, userNumber, currentPosition);
			user.deposit(balance);
			users.add(user);
		}		
		return users;
	}

	public Street[] loadStreet() throws SQLException{
		int ownerNumber;
		int houseAmount;
		int hotelAmount;
		Ownable[] fields = new Ownable[40];

		PreparedStatement loadFields;
		String loadFieldsString = "SELET * FROM ownable";

		loadFields = conn.prepareStatement(loadFieldsString);

		ResultSet res = loadFields.executeQuery();

		while(res.next()){
			ownerNumber = res.getInt("ownerNumber");
			houseAmount = res.getInt("houseAmount");
			hotelAmount = res.getInt("hotelAmount");
			fields[res.getInt("fieldNumber")].setOwner(ownerNumber);
			fields[res.getInt("fieldNumber")].setHouseAmount(houseAmount);
			fields[res.getInt("fieldNumber")].setHotelAmount(hotelAmount);
		}
		
		return fields;
	}

}

