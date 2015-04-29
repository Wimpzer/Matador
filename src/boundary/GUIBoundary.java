package boundary;

import java.awt.Color;

import user.User;
import desktop_resources.GUI;
import field.*;
import game.Board;

public class GUIBoundary {

	private static Color[] carColour = {Color.black, Color.blue, Color.cyan, Color.orange, Color.green, Color.pink};
	private static int carNumber = 0;

	public static void createBoard(Board board){

		desktop_fields.Field[] fields = new desktop_fields.Field[40];

		for (Field field : board.getFields()) {
			if(field instanceof Start){
				Start newField = (Start) field;
				fields[field.getFieldNumber()-1] = new desktop_fields.Start.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(6, 71, 85)).setDescription("Hver gang De passere START, modtag 4000 kr.").setSubText("Modtag 4000 kr.").build();
				break;
			}else if(field instanceof Street){
				Street newField = (Street) field;
				fields[field.getFieldNumber()-1] = new desktop_fields.Street.Builder().setTitle(newField.getName()).setBgColor(newField.getColour()).setFgColor(Color.getHSBColor(207, 39, 89)).setDescription(newField.getName()).setSubText(Integer.toString(newField.getFieldNumber())).build();
				break;
			}else if(field instanceof Chance){
				fields[field.getFieldNumber()-1] = new desktop_fields.Chance.Builder().setFgColor(Color.getHSBColor(38, 54, 71)).build();
				break;
			}else if(field instanceof Taxes){
				Taxes newField = (Taxes) field;
				if(field.getFieldNumber() == 5){
					fields[field.getFieldNumber()-1] = new desktop_fields.Tax.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(207, 39, 89)).setDescription("Betal indkomstskat: 10% eller 4000 kr.").setSubText(Integer.toString(newField.getFieldNumber())).build();
				}else if(field.getFieldNumber() == 39){
					fields[field.getFieldNumber()-1] = new desktop_fields.Tax.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(207, 39, 89)).setDescription("Ekstraordinær statsskat: Betal 2000 kr.").setSubText(Integer.toString(newField.getFieldNumber())).build();
				}
				break;
			}else if(field instanceof Shipping){
				Shipping newField = (Shipping) field;
				fields[field.getFieldNumber()-1] = new desktop_fields.Shipping.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(207, 39, 89)).setDescription(newField.getName()).setSubText(Integer.toString(newField.getFieldNumber())).build();
				break;
			}else if(field instanceof Jail){
				Jail newField = (Jail) field;
				if(field.getFieldNumber() == 11){
					fields[field.getFieldNumber()-1] = new desktop_fields.Jail.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(207, 39, 89)).setDescription("På besøg").setSubText(Integer.toString(newField.getFieldNumber())).build();
				}else if(field.getFieldNumber() == 31){

					fields[field.getFieldNumber()-1] = new desktop_fields.Jail.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(207, 39, 89)).setDescription("De fængsles").setSubText(Integer.toString(newField.getFieldNumber())).build();
				}
				break;
			}else if(field instanceof Brewery){
				Brewery newField = (Brewery) field;
				fields[field.getFieldNumber()-1] = new desktop_fields.Brewery.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(207, 39, 89)).setDescription(newField.getName()).setSubText(Integer.toString(newField.getFieldNumber())).build();
				break;
			}else if(field instanceof Refuge){
				Refuge newField = (Refuge) field;
				fields[field.getFieldNumber()-1] = new desktop_fields.Refuge.Builder().setTitle(newField.getName()).setFgColor(Color.getHSBColor(207, 39, 89)).setDescription(newField.getName()).setSubText(Integer.toString(newField.getFieldNumber())).build();
				break;
			}
		}
		GUI.create(fields);
	}

	public static void showMessage(String string){
		GUI.showMessage(string);
	}

	public static int getUserInteger(String string, int min, int max){
		return GUI.getUserInteger(string, min, max);
	}

	public static String getUserButtonPressed(String msg, String...buttons){
		return GUI.getUserButtonPressed(msg, buttons);

	}

	public static boolean getUserLeftButtonPressed(String msg, String trueButton, String falseButton){
		return GUI.getUserLeftButtonPressed(msg, trueButton, falseButton);
	}

	public static String getUserString(String msg){
		return GUI.getUserString(msg);
	}

	public static void addPlayer(User user){
		desktop_codebehind.Car car = new desktop_codebehind.Car.Builder().primaryColor(carColour[carNumber++]).typeTractor().build();
		GUI.addPlayer(user.getUserName(), user.getBalance());
		setCar(user.getCurrentPosition()+1, user.getUserName());
	}

	public static void setOwner(int fieldNumber, String name){
		GUI.setOwner(fieldNumber, name);
	}

	public static void removeOwner(int fieldNumber){
		GUI.removeOwner(fieldNumber);
	}

	public static void setBalance(String name, int newBalance){
		GUI.setBalance(name, newBalance);
	}

	public static void removeCar(int fieldNumber, String name){
		GUI.removeCar(fieldNumber, name);
	}

	public static void setCar(int fieldNumber, String name){
		GUI.setCar(fieldNumber, name);
	}

	public static void setDice(int faceValue1, int faceValue2){
		GUI.setDice(faceValue1, faceValue2);
	}

	public static void setHouses(int fieldNumber, int houseCount){
		GUI.setHouses(fieldNumber, houseCount);
	}

	public static void setHotel(int fieldNumber, boolean hasHotel){
		GUI.setHotel(fieldNumber, hasHotel);
	}

}