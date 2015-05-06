package boundary;

import java.awt.Color;

import user.User;
import desktop_resources.GUI;
import field.*;
import game.Board;

/**
 * Includes all connections between the GUI.jar and 
 * the program.
 * Methods made static to avoid having to make a new
 * object, in classes which need to use one method.
 * 
 * Description for methods, where other isn't stated,
 * is taken from the GUI.jar javadoc. Made by Ronnie
 * Dalsgaard.
 * Parameters description is not made by Ronnie Dalsgaard.
 * 
 * @author Bjarke
 *
 */

public class GUIBoundary {

	private static Color[] carColour = {Color.black, Color.blue, Color.cyan, Color.orange, Color.green, Color.pink};
	private static int carNumber = 0;

	/**
	 * Initializes the board using an array.
	 * Doesn't show the GUI.
	 * If this method isn't the first method to be called it will have no result.
	 * @param board TUI-based board.
	 */
	
	public static void createBoard(Board board){

		desktop_fields.Field[] fields = new desktop_fields.Field[40];

		for (Field field : board.getFields()) {
			if(field instanceof Start){
				Start newField = (Start) field;
				fields[field.getFieldNumber()-1] = new desktop_fields.Start.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(0, 0, 0)).setDescription("Hver gang De passere START, modtag 4000 kr.").setSubText("4000 kr.").build();
			}else if(field instanceof Street){
				Street newField = (Street) field;
				fields[field.getFieldNumber()-1] = new desktop_fields.Street.Builder().setTitle(newField.getName()).setBgColor(newField.getColour()).setFgColor(Color.getHSBColor(0, 0, 0)).setDescription(newField.getName()).setSubText((Integer.toString(newField.getFieldPrice()) + " kr.")).build();
			}else if(field instanceof Chance){
				fields[field.getFieldNumber()-1] = new desktop_fields.Chance.Builder().setFgColor(Color.getHSBColor(0, 0, 0)).build();
			}else if(field instanceof Taxes){
				if(field.getFieldNumber() == 5){
					fields[field.getFieldNumber()-1] = new desktop_fields.Tax.Builder().setTitle("").setFgColor(Color.getHSBColor(0, 0, 0)).setDescription("Betal \nindkomst\n-skat").setSubText("Betal indkomstskat: 10% eller 4000 kr.").build();
				}else if(field.getFieldNumber() == 39){
					fields[field.getFieldNumber()-1] = new desktop_fields.Tax.Builder().setTitle("2000 kr.").setFgColor(Color.getHSBColor(0, 0, 0)).setDescription("Ekstra\n-ordinær\nStatsskat:").setSubText("Ekstraordinær statsskat: Betal 2000 kr.").build();
				}
			}else if(field instanceof Shipping){
				Shipping newField = (Shipping) field;
				fields[field.getFieldNumber()-1] = new desktop_fields.Shipping.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(0, 0, 0)).setDescription(newField.getName()).setSubText(Integer.toString(newField.getFieldPrice()) + " kr.").build();			
			}else if(field instanceof Jail){
				Jail newField = (Jail) field;
				if(field.getFieldNumber() == 11){
					fields[field.getFieldNumber()-1] = new desktop_fields.Jail.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(0, 0, 0)).setDescription("Fængsel: På besøg").setSubText("På besøg").build();
				}else if(field.getFieldNumber() == 31){
					fields[field.getFieldNumber()-1] = new desktop_fields.Jail.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(0, 0, 0)).setDescription("Fængsel: De er fængslet").setSubText("De fængsles").build();
				}
			}else if(field instanceof Brewery){
				Brewery newField = (Brewery) field;
				fields[field.getFieldNumber()-1] = new desktop_fields.Brewery.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(255, 255, 255)).setDescription(newField.getName()).setSubText(Integer.toString(newField.getFieldPrice()) + " kr.").build();
			}else if(field instanceof Refuge){
				Refuge newField = (Refuge) field;
				fields[field.getFieldNumber()-1] = new desktop_fields.Refuge.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(0, 0, 0)).setDescription(newField.getName()).setSubText("Parkering").build();
			}
		}
		GUI.create(fields);
	}

	/**
	 * Displays a message to the user.
	 * Breaks the system until "OK" is pressed.
	 * @param string The string to be displayed.
	 */
	
	public static void showMessage(String string){
		GUI.showMessage(string);
	}

	/**
	 * Displays a message to the user and awaits the integer response.
	 * @param string The string to be displayed.
	 * @param min The minimum of the integer to return.
	 * @param max The maximum of the integer to return.
	 * @return
	 */
	
	public static int getUserInteger(String string, int min, int max){
		return GUI.getUserInteger(string, min, max);
	}

	/**
	 * Displays a message to the user and awaits the button pressed response.
	 * @param msg The Message to be displayed.
	 * @param buttons The options the user have.
	 * @return
	 */
	
	public static String getUserButtonPressed(String msg, String...buttons){
		return GUI.getUserButtonPressed(msg, buttons);
	}

	/**
	 * Displays a message to the user and awaits the boolean response.
	 * @param msg The message to be displayed.
	 * @param trueButton First option the user can choose - Returns true.
	 * @param falseButton Second option the user can choose - Returns false.
	 * @return
	 */
	
	public static boolean getUserLeftButtonPressed(String msg, String trueButton, String falseButton){
		return GUI.getUserLeftButtonPressed(msg, trueButton, falseButton);
	}

	/**
	 * Displays a message to the user and awaits the response.
	 * @param msg The message to be displayed.
	 * @return
	 */
	
	public static String getUserString(String msg){
		return GUI.getUserString(msg);
	}

	/**
	 * Adds a player to the board.
	 * 
	 * Using the method setCar.
	 * @param user The user which the method needs to use.
	 */
	
	public static void addPlayer(User user){
		desktop_codebehind.Car car = new desktop_codebehind.Car.Builder().primaryColor(carColour[carNumber++]).typeTractor().build();
		GUI.addPlayer(user.getUserName(), user.getBalance(), car);
		setCar(user.getCurrentPosition()+1, user.getUserName());
	}
	
	/**
	 * Sets an owner of a field.
	 * The field border will have the same color as the player.
	 * @param fieldNumber The field number where the owner should be set.
	 * @param name The name that needs to be set as owner.
	 */
	
	public static void setOwner(int fieldNumber, String name){
		GUI.setOwner(fieldNumber, name);
	}
	
	/**
	 * Removes an owner from the field.
	 * If the field has no owner, nothing happends.
	 * @param fieldNumber Field number of the field where a owner needs to be removed.
	 */
	
	public static void removeOwner(int fieldNumber){
		GUI.removeOwner(fieldNumber);
	}

	/**
	 * Sets the balance of a player if the player has been added.
	 * @param name Name of the player who balances needs to be set.
	 * @param newBalance The balance of the player.
	 */
	
	public static void setBalance(String name, int newBalance){
		GUI.setBalance(name, newBalance);
	}

	/**
	 * Removes a car from the board.
	 * If the car is not on the board, nothing happens.
	 * @param fieldNumber The field number where a car needs to be removed from.
	 * @param name The name of the car which needs to be removed.
	 */
	
	public static void removeCar(int fieldNumber, String name){
		GUI.removeCar(fieldNumber, name);
	}

	/**
	 * removeAllCars: Removes all cars belonging to the player.
	 * setCar: Places a car on the Field.
	 * All cars can be placed on the same field.
	 * A car can only be placed if the corresponding player has been added.
	 * If a car is placed on the same field multiple times, nothing more happens.
	 * A car can not be placed on multiple fields simultaneously.
	 * @param fieldNumber The field number where the car needs to be set.
	 * @param name The name of driver.
	 */
	
	public static void setCar(int fieldNumber, String name){
		GUI.removeAllCars(name);
		GUI.setCar(fieldNumber, name);
	}

	/**
	 * Shows two dice on the board.
	 * @param faceValue1 What the first dice need to show.
	 * @param faceValue2 What the second dice need to show.
	 */
	
	public static void setDice(int faceValue1, int faceValue2){
		GUI.setDice(faceValue1, faceValue2);
	}

	/**
	 * Sets houses from the street, and removes the hotel if one is present.
	 * If houseCount is out of bounds, nothing happens.
	 * If field is not a street, nothing happens.
	 * @param fieldNumber The field number of the street where the house should be placed.
	 * @param houseCount The number of houses that should be shown on the street.
	 */
	
	public static void setHouses(int fieldNumber, int houseCount){
		GUI.setHouses(fieldNumber, houseCount);
	}

	/**
	 * Sets whether or not a hotel should be on the street and removes all houses is any is present.
	 * @param fieldNumber The field number of the street where the hotel should be placed.
	 * @param hasHotel If true places a hotel, if false does not.
	 */
	
	public static void setHotel(int fieldNumber, boolean hasHotel){
		GUI.setHotel(fieldNumber, hasHotel);
	}

}