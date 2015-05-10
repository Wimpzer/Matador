package game;

import java.awt.Color;

import boundary.GUIBoundary;
import field.Field;
import field.Street;
import user.User;

/**
 * Withholds all the methods needed when a user wants to
 * buy or sell houses or hotel.
 * @author Bjarke
 */

public class HouseShopping {

	/**
	 * This method is called from the controller when a user
	 * wants to buy a house or hotel.
	 * It allows the player to pick what colour of field he wants
	 * to build houses or hotel on.
	 * Calls a method which uses the users option as a variable.
	 * @param user The current user whose turn it is.
	 * @param board The gameboard as a whole.
	 */
	
	public void buyHouse(User user, Board board){
		int blueMatch, pinkMatch, greenMatch, grayMatch, redMatch, whiteMatch, yellowMatch, purpleMatch;
		blueMatch = pinkMatch = greenMatch = grayMatch = redMatch = whiteMatch = yellowMatch = purpleMatch = 0;
		int amount = 0;

		String[] buttons = countColourMatches(blueMatch, pinkMatch, greenMatch,
				grayMatch, redMatch, whiteMatch, yellowMatch, purpleMatch,
				amount, board, user);

		String colourInput = GUIBoundary.getUserButtonPressed("Vælg grundfarve du vil købe hus på", buttons);

		colourInputSwitch(user, board, colourInput);
	}

	private String[] countColourMatches(int blueMatch, int pinkMatch,
			int greenMatch, int grayMatch, int redMatch, int whiteMatch,
			int yellowMatch, int purpleMatch, int amount, Board board, User user) {

		for (Field field : board.fields) {
			if(field instanceof Street){
				Street street = (Street) field;
				if(street.getOwner() == user){
					if(street.getColour().equals(new Color(35, 104, 173))){
						blueMatch = board.getSimilarCount(street);
						if(blueMatch == 2)
							amount++;
					}else if(street.getColour().equals(new Color(223, 110, 30))){
						pinkMatch = board.getSimilarCount(street);
						if(pinkMatch == 3)
							amount++;
					}else if(street.getColour().equals(new Color(188, 185, 32))){
						greenMatch = board.getSimilarCount(street);
						if(greenMatch == 3)
							amount++;
					}else if(street.getColour().equals(new Color(163, 171, 174))){
						grayMatch = board.getSimilarCount(street);
						if(grayMatch == 3)
							amount++;
					}else if(street.getColour().equals(new Color(217, 71, 96))){
						redMatch = board.getSimilarCount(street);
						if(redMatch == 3)
							amount++;
					}else if(street.getColour().equals(new Color(221, 215, 219))){
						whiteMatch = board.getSimilarCount(street);
						if(whiteMatch == 3)
							amount++;
					}else if(street.getColour().equals(new Color(255, 255, 0))){
						yellowMatch = board.getSimilarCount(street);
						if(yellowMatch == 3)
							amount++;
					}else if(street.getColour().equals(new Color(115, 77, 136))){
						purpleMatch = board.getSimilarCount(street);
						if(purpleMatch == 2)
							amount++;
					}
				}
			}
		}

		String[] buttons = buttonsSize(blueMatch, pinkMatch, greenMatch,
				grayMatch, redMatch, whiteMatch, yellowMatch, purpleMatch,
				amount);
		return buttons;
	}
	
	private String[] buttonsSize(int blueMatch, int pinkMatch, int greenMatch,
			int grayMatch, int redMatch, int whiteMatch, int yellowMatch,
			int purpleMatch, int amount) {
		String[] buttons = new String[amount];
		int nextIndex = 0;

		if(blueMatch == 2){
			buttons[nextIndex] = "Blue";
			nextIndex++;
		}
		if(pinkMatch == 3){
			buttons[nextIndex] = "Pink";
			nextIndex++;
		}
		if(greenMatch == 3){
			buttons[nextIndex] = "Green";
			nextIndex++;
		}
		if(grayMatch == 3){
			buttons[nextIndex] = "Gray";
			nextIndex++;
		}
		if(redMatch == 3){
			buttons[nextIndex] = "Red";
			nextIndex++;
		}
		if(whiteMatch == 3){
			buttons[nextIndex] = "White";
			nextIndex++;
		}
		if(yellowMatch == 3){
			buttons[nextIndex] = "Yellow";
			nextIndex++;
		}
		if(purpleMatch == 2){
			buttons[nextIndex] = "Purple";
			nextIndex++;
		}
		return buttons;
	}
	
	private void colourInputSwitch(User user, Board board, String colourInput) {
		switch (colourInput) {
		case "Blue":
			blueYesNo(user, board);
			break;

		case "Pink":
			pinkYesNo(user, board);
			break;

		case "Green":
			greenYesNo(user, board);
			break;

		case "Gray":
			grayYesNo(user, board);
			break;

		case "Red":
			redYesNo(user, board);
			break;

		case "White":
			whiteYesNo(user, board);
			break;

		case "Yellow":
			yellowYesNo(user, board);
			break;

		case "Purple":
			purpleYesNo(user, board);
			break;

		default:
			break;
		}
	}

	private void blueYesNo(User user, Board board) {
		boolean blueYesNo = GUIBoundary.getUserLeftButtonPressed("Køb af hus på følgende farve koster: " + ((Street) board.getField(1)).getHousePrice(), "Køb hus", "Annuler");
		if(blueYesNo == true){
			String[] blueButtons = {"Rødovrevej", "Hvidovrevej"};
			String blueInput = GUIBoundary.getUserButtonPressed("Vælg hvilken grund du vil købe hus på", blueButtons);
			switch (blueInput) {
			case "Rødovrevej":
				Street roedovrevej = (Street) board.getField(1);
				if(roedovrevej.getHouseAmount() == 4){
					roedovrevej.setHotelAmount(1);
					roedovrevej.setHouseAmount(0);
					GUIBoundary.setHotel(2, true);
				}else if(roedovrevej.getHotelAmount() == 1){
					break;
				}else{
					roedovrevej.setHouseAmount(roedovrevej.getHouseAmount()+1);
					GUIBoundary.setHouses(2, roedovrevej.getHouseAmount());
				}
				user.withdraw(roedovrevej.getHousePrice());
				user.setGroundValue(user.getGroundValue()+roedovrevej.getHousePrice());
				break;

			case "Hvidovrevej":
				Street hvidovrevej = (Street) board.getField(3);
				if(hvidovrevej.getHouseAmount() == 4){
					hvidovrevej.setHotelAmount(1);
					hvidovrevej.setHouseAmount(0);
					GUIBoundary.setHotel(4, true);
				}else if(hvidovrevej.getHotelAmount() == 1){
					break;
				}else{
					hvidovrevej.setHouseAmount(hvidovrevej.getHouseAmount()+1);
					GUIBoundary.setHouses(4, hvidovrevej.getHouseAmount());
				}
				user.withdraw(hvidovrevej.getHousePrice());
				user.setGroundValue(user.getGroundValue()+hvidovrevej.getHousePrice());
				break;

			default:
				break;
			}
		}
	}

	private void pinkYesNo(User user, Board board) {
		boolean pinkYesNo = GUIBoundary.getUserLeftButtonPressed("Køb af hus på følgende farve koster: " + ((Street) board.getField(6)).getHousePrice(), "Køb hus", "Annuler");
		if(pinkYesNo == true){
			String[] pinkButtons = {"Roskildevej", "Valby Langgade", "Allegade"};
			String pinkInput = GUIBoundary.getUserButtonPressed("Vælg hvilken grund du vil købe hus på", pinkButtons);
			switch (pinkInput) {
			case "Roskildevej":
				Street roskildevej = (Street) board.getField(6);
				if(roskildevej.getHouseAmount() == 4){
					roskildevej.setHotelAmount(1);
					roskildevej.setHouseAmount(0);
					GUIBoundary.setHotel(7, true);
				}else if(roskildevej.getHotelAmount() == 1){
					break;
				}else{
					roskildevej.setHouseAmount(roskildevej.getHouseAmount()+1);
					GUIBoundary.setHouses(7, roskildevej.getHouseAmount());
				}
				user.withdraw(roskildevej.getHousePrice());
				user.setGroundValue(user.getGroundValue()+roskildevej.getHousePrice());
				break;

			case "Valby Langgade":
				Street valbyLanggade = (Street) board.getField(8);
				if(valbyLanggade.getHouseAmount() == 4){
					valbyLanggade.setHotelAmount(1);
					valbyLanggade.setHouseAmount(0);
					GUIBoundary.setHotel(9, true);
				}else if(valbyLanggade.getHotelAmount() == 1){
					break;
				}else{
					valbyLanggade.setHouseAmount(valbyLanggade.getHouseAmount()+1);
					GUIBoundary.setHouses(9, valbyLanggade.getHouseAmount());
				}
				user.withdraw(valbyLanggade.getHousePrice());
				user.setGroundValue(user.getGroundValue()+valbyLanggade.getHousePrice());
				break;

			case "Allegade":
				Street allegade = (Street) board.getField(9);
				if(allegade.getHouseAmount() == 4){
					allegade.setHotelAmount(1);
					allegade.setHouseAmount(0);
					GUIBoundary.setHotel(10, true);
				}else if(allegade.getHotelAmount() == 1){
					break;
				}else{
					allegade.setHouseAmount(allegade.getHouseAmount()+1);
					GUIBoundary.setHouses(10, allegade.getHouseAmount());
				}
				user.withdraw(allegade.getHousePrice());
				user.setGroundValue(user.getGroundValue()+allegade.getHousePrice());
				break;

			default:
				break;
			}
		}
	}

	private void greenYesNo(User user, Board board) {
		boolean greenYesNo = GUIBoundary.getUserLeftButtonPressed("Køb af hus på følgende farve koster: " + ((Street) board.getField(11)).getHousePrice(), "Køb hus", "Annuler");
		if(greenYesNo == true){
			String[] greenButtons = {"Frederiksberg Alle", "Bulowsvej", "Gammel Kongevej"};
			String greenInput = GUIBoundary.getUserButtonPressed("Vælg hvilken grund du vil købe hus på", greenButtons);
			switch (greenInput) {
			case "Frederiksberg Alle":
				Street frederiksbergAlle = (Street) board.getField(11);
				if(frederiksbergAlle.getHouseAmount() == 4){
					frederiksbergAlle.setHotelAmount(1);
					frederiksbergAlle.setHouseAmount(0);
					GUIBoundary.setHotel(12, true);
				}else if(frederiksbergAlle.getHotelAmount() == 1){
					break;
				}else{
					frederiksbergAlle.setHouseAmount(frederiksbergAlle.getHouseAmount()+1);
					GUIBoundary.setHouses(12, frederiksbergAlle.getHouseAmount());
				}
				user.withdraw(frederiksbergAlle.getHousePrice());
				user.setGroundValue(user.getGroundValue()+frederiksbergAlle.getHousePrice());
				break;

			case "Bulowsvej":
				Street bulowsvej = (Street) board.getField(13);
				if(bulowsvej.getHouseAmount() == 4){
					bulowsvej.setHotelAmount(1);
					bulowsvej.setHouseAmount(0);
					GUIBoundary.setHotel(14, true);
				}else if(bulowsvej.getHotelAmount() == 1){
					break;
				}else{
					bulowsvej.setHouseAmount(bulowsvej.getHouseAmount()+1);
					GUIBoundary.setHouses(14, bulowsvej.getHouseAmount());
				}
				user.withdraw(bulowsvej.getHousePrice());
				user.setGroundValue(user.getGroundValue()+bulowsvej.getHousePrice());
				break;

			case "Gammel Kongevej":
				Street gammelKongevej = (Street) board.getField(14);
				if(gammelKongevej.getHouseAmount() == 4){
					gammelKongevej.setHotelAmount(1);
					gammelKongevej.setHouseAmount(0);
					GUIBoundary.setHotel(15, true);
				}else if(gammelKongevej.getHotelAmount() == 1){
					break;
				}else{
					gammelKongevej.setHouseAmount(gammelKongevej.getHouseAmount()+1);
					GUIBoundary.setHouses(15, gammelKongevej.getHouseAmount());
				}
				user.withdraw(gammelKongevej.getHousePrice());
				user.setGroundValue(user.getGroundValue()+gammelKongevej.getHousePrice());
				break;

			default:
				break;
			}
		}
	}

	private void grayYesNo(User user, Board board) {
		boolean greyYesNo = GUIBoundary.getUserLeftButtonPressed("Køb af hus på følgende farve koster: " + ((Street) board.getField(16)).getHousePrice(), "Køb hus", "Annuler");
		if(greyYesNo == true){
			String[] grayButtons = {"Bernstorffsvej", "Hellerupvej", "Strandvejen"};
			String grayInput = GUIBoundary.getUserButtonPressed("Vælg hvilken grund du vil købe hus på", grayButtons);
			switch (grayInput) {
			case "Bernstorffsvej":
				Street bernstorffsvej = (Street) board.getField(16);
				if(bernstorffsvej.getHouseAmount() == 4){
					bernstorffsvej.setHotelAmount(1);
					bernstorffsvej.setHouseAmount(0);
					GUIBoundary.setHotel(17, true);
				}else if(bernstorffsvej.getHotelAmount() == 1){
					break;
				}else{
					bernstorffsvej.setHouseAmount(bernstorffsvej.getHouseAmount()+1);
					GUIBoundary.setHouses(17, bernstorffsvej.getHouseAmount());
				}
				user.withdraw(bernstorffsvej.getHousePrice());
				user.setGroundValue(user.getGroundValue()+bernstorffsvej.getHousePrice());
				break;

			case "Hellerupvej":
				Street hellerupvej = (Street) board.getField(18);
				if(hellerupvej.getHouseAmount() == 4){
					hellerupvej.setHotelAmount(1);
					hellerupvej.setHouseAmount(0);
					GUIBoundary.setHotel(19, true);
				}else if(hellerupvej.getHotelAmount() == 1){
					break;
				}else{
					hellerupvej.setHouseAmount(hellerupvej.getHouseAmount()+1);
					GUIBoundary.setHouses(19, hellerupvej.getHouseAmount());
				}
				user.withdraw(hellerupvej.getHousePrice());
				user.setGroundValue(user.getGroundValue()+hellerupvej.getHousePrice());
				break;

			case "Strandvejen":
				Street strandvejen = (Street) board.getField(19);
				if(strandvejen.getHouseAmount() == 4){
					strandvejen.setHotelAmount(1);
					strandvejen.setHouseAmount(0);
					GUIBoundary.setHotel(20, true);
				}else if(strandvejen.getHotelAmount() == 1){
					break;
				}else{
					strandvejen.setHouseAmount(strandvejen.getHouseAmount()+1);
					GUIBoundary.setHouses(20, strandvejen.getHouseAmount());
				}
				user.withdraw(strandvejen.getHousePrice());
				user.setGroundValue(user.getGroundValue()+strandvejen.getHousePrice());
				break;

			default:
				break;
			}
		}
	}

	private void redYesNo(User user, Board board) {
		boolean redYesNo = GUIBoundary.getUserLeftButtonPressed("Køb af hus på følgende farve koster: " + ((Street) board.getField(21)).getHousePrice(), "Køb hus", "Annuler");
		if(redYesNo == true){
			String[] redButtons = {"Trianglen", "Østerbrogade", "Grønningen"};
			String redInput = GUIBoundary.getUserButtonPressed("Vælg hvilken grund du vil købe hus på", redButtons);
			switch (redInput) {
			case "Trianglen":
				Street trianglen = (Street) board.getField(21);
				if(trianglen.getHouseAmount() == 4){
					trianglen.setHotelAmount(1);
					GUIBoundary.setHotel(22, true);
				}else if(trianglen.getHotelAmount() == 1){
					break;
				}else{
					trianglen.setHouseAmount(trianglen.getHouseAmount()+1);
					GUIBoundary.setHouses(22, trianglen.getHouseAmount());
				}
				user.withdraw(trianglen.getHousePrice());
				user.setGroundValue(user.getGroundValue()+trianglen.getHousePrice());
				break;

			case "Østerbrogade":
				Street oesterbrogade = (Street) board.getField(23);
				if(oesterbrogade.getHouseAmount() == 4){
					oesterbrogade.setHotelAmount(1);
					oesterbrogade.setHouseAmount(0);
					GUIBoundary.setHotel(24, true);
				}else if(oesterbrogade.getHotelAmount() == 1){
					break;
				}else{
					oesterbrogade.setHouseAmount(oesterbrogade.getHouseAmount()+1);
					GUIBoundary.setHouses(24, oesterbrogade.getHouseAmount());
				}
				user.withdraw(oesterbrogade.getHousePrice());
				user.setGroundValue(user.getGroundValue()+oesterbrogade.getHousePrice());
				break;

			case "Grønningen":
				Street groenningen = (Street) board.getField(24);
				if(groenningen.getHouseAmount() == 4){
					groenningen.setHotelAmount(1);
					groenningen.setHouseAmount(0);
					GUIBoundary.setHotel(25, true);
				}else if(groenningen.getHotelAmount() == 1){
					break;
				}else{
					groenningen.setHouseAmount(groenningen.getHouseAmount()+1);
					GUIBoundary.setHouses(25, groenningen.getHouseAmount());
				}
				user.withdraw(groenningen.getHousePrice());
				user.setGroundValue(user.getGroundValue()+groenningen.getHousePrice());
				break;

			default:
				break;
			}
		}
	}

	private void whiteYesNo(User user, Board board) {
		boolean whiteYesNo = GUIBoundary.getUserLeftButtonPressed("Køb af hus på følgende farve koster: " + ((Street) board.getField(26)).getHousePrice(), "Køb hus", "Annuler");
		if(whiteYesNo == true){
			String[] whiteButtons = {"Bredgade", "Kgs. Nytorv", "Østergade"};
			String whiteInput = GUIBoundary.getUserButtonPressed("Vælg hvilken grund du vil købe hus på", whiteButtons);
			switch (whiteInput) {
			case "Bredgade":
				Street bredgade = (Street) board.getField(26);
				if(bredgade.getHouseAmount() == 4){
					bredgade.setHotelAmount(1);
					bredgade.setHouseAmount(0);
					GUIBoundary.setHotel(27, true);
				}else if(bredgade.getHotelAmount() == 1){
					break;
				}else{
					bredgade.setHouseAmount(bredgade.getHouseAmount()+1);
					GUIBoundary.setHouses(27, bredgade.getHouseAmount());
				}
				user.withdraw(bredgade.getHousePrice());
				user.setGroundValue(user.getGroundValue()+bredgade.getHousePrice());
				break;

			case "Kgs. Nytorv":
				Street kgsNytorv = (Street) board.getField(27);
				if(kgsNytorv.getHouseAmount() == 4){
					kgsNytorv.setHotelAmount(1);
					kgsNytorv.setHouseAmount(0);
					GUIBoundary.setHotel(28, true);
				}else if(kgsNytorv.getHotelAmount() == 1){
					break;
				}else{
					kgsNytorv.setHouseAmount(kgsNytorv.getHouseAmount()+1);
					GUIBoundary.setHouses(28, kgsNytorv.getHouseAmount());
				}
				user.withdraw(kgsNytorv.getHousePrice());
				user.setGroundValue(user.getGroundValue()+kgsNytorv.getHousePrice());
				break;

			case "Østergade":
				Street oestergade = (Street) board.getField(29);
				if(oestergade.getHouseAmount() == 4){
					oestergade.setHotelAmount(1);
					oestergade.setHouseAmount(0);
					GUIBoundary.setHotel(30, true);
				}else if(oestergade.getHotelAmount() == 1){
					break;
				}else{
					oestergade.setHouseAmount(oestergade.getHouseAmount()+1);
					GUIBoundary.setHouses(30, oestergade.getHouseAmount());
				}
				user.withdraw(oestergade.getHousePrice());
				user.setGroundValue(user.getGroundValue()+oestergade.getHousePrice());
				break;

			default:
				break;
			}
		}
	}

	private void yellowYesNo(User user, Board board) {
		boolean yellowYesNo = GUIBoundary.getUserLeftButtonPressed("Køb af hus på følgende farve koster: " + ((Street) board.getField(31)).getHousePrice(), "Køb hus", "Annuler");
		if(yellowYesNo == true){
			String[] yellowButtons = {"Amagertorv", "Vimmelskaftet", "Nygade"};
			String yellowInput = GUIBoundary.getUserButtonPressed("Vælg hvilken grund du vil købe hus på", yellowButtons);
			switch (yellowInput) {
			case "Amagertorv":
				Street amagertorv = (Street) board.getField(31);
				if(amagertorv.getHouseAmount() == 4){
					amagertorv.setHotelAmount(1);
					amagertorv.setHouseAmount(0);
					GUIBoundary.setHotel(32, true);
				}else if(amagertorv.getHotelAmount() == 1){
					break;
				}else{
					amagertorv.setHouseAmount(amagertorv.getHouseAmount()+1);
					GUIBoundary.setHouses(32, amagertorv.getHouseAmount());
				}
				user.withdraw(amagertorv.getHousePrice());
				user.setGroundValue(user.getGroundValue()+amagertorv.getHousePrice());
				break;

			case "Vimmelskaftet":
				Street vimmelskaftet = (Street) board.getField(32);
				if(vimmelskaftet.getHouseAmount() == 4){
					vimmelskaftet.setHotelAmount(1);
					vimmelskaftet.setHouseAmount(0);
					GUIBoundary.setHotel(33, true);
				}else if(vimmelskaftet.getHotelAmount() == 1){
					break;
				}else{
					vimmelskaftet.setHouseAmount(vimmelskaftet.getHouseAmount()+1);
					GUIBoundary.setHouses(33, vimmelskaftet.getHouseAmount());
				}
				user.withdraw(vimmelskaftet.getHousePrice());
				break;

			case "Nygade":
				Street nygade = (Street) board.getField(34);
				if(nygade.getHouseAmount() == 4){
					nygade.setHotelAmount(1);
					nygade.setHouseAmount(0);
					GUIBoundary.setHotel(35, true);
				}else if(nygade.getHotelAmount() == 1){
					break;
				}else{
					nygade.setHouseAmount(nygade.getHouseAmount()+1);
					GUIBoundary.setHouses(35, nygade.getHouseAmount());
				}
				user.withdraw(nygade.getHousePrice());
				user.setGroundValue(user.getGroundValue()+nygade.getHousePrice());
				break;

			default:
				break;
			}
		}
	}

	private void purpleYesNo(User user, Board board) {
		boolean purpleYesNo = GUIBoundary.getUserLeftButtonPressed("Køb af hus på følgende farve koster: " + ((Street) board.getField(37)).getHousePrice(), "Køb hus", "Annuler");
		if(purpleYesNo == true){
			String[] purpleButtons = {"Frederiksberggade", "Rådhuspladsen"};
			String purpleInput = GUIBoundary.getUserButtonPressed("Vælg hvilken grund du vil købe hus på", purpleButtons);
			switch (purpleInput) {
			case "Frederiksberggade":
				Street frederiksberggade = (Street) board.getField(37);
				if(frederiksberggade.getHouseAmount() == 4){
					frederiksberggade.setHotelAmount(1);
					frederiksberggade.setHouseAmount(0);
					GUIBoundary.setHotel(38, true);
				}else if(frederiksberggade.getHotelAmount() == 1){
					break;
				}else{
					frederiksberggade.setHouseAmount(frederiksberggade.getHouseAmount()+1);
					GUIBoundary.setHouses(38, frederiksberggade.getHouseAmount());
				}
				user.withdraw(frederiksberggade.getHousePrice());
				user.setGroundValue(user.getGroundValue()+frederiksberggade.getHousePrice());
				break;

			case "Rådhuspladsen":
				Street raedhuspladsen = (Street) board.getField(39);
				if(raedhuspladsen.getHouseAmount() == 4){
					raedhuspladsen.setHotelAmount(1);
					raedhuspladsen.setHouseAmount(0);
					GUIBoundary.setHotel(40, true);
				}else if(raedhuspladsen.getHotelAmount() == 1){
					break;
				}else{
					raedhuspladsen.setHouseAmount(raedhuspladsen.getHouseAmount()+1);
					GUIBoundary.setHouses(40, raedhuspladsen.getHouseAmount());
				}
				user.withdraw(raedhuspladsen.getHousePrice());
				user.setGroundValue(user.getGroundValue()+raedhuspladsen.getHousePrice());
				break;

			default:
				break;
			}
		}
	}

	/**
	 * This is method called from the controller when a user
	 * wants to sell a house or hotel.
	 * Checks if the user got any houses or hotel on his owned
	 * fields, if so allows him to sell one of those.
	 * @param user The current user whose turn it is.
	 * @param board
	 */
	
	public void sellHouse(User user, Board board){
		String[] temp = new String[22];
		int size = 0;
		
		for (Field field : board.getFields()) {
			if(field instanceof Street){
				Street street = (Street) field;
				if(street.getOwner() == user && (street.getHouseAmount() > 0 || street.getHotelAmount() == 1)){
					temp[size++] = street.getName();
				}
			}
		}
		
		String[] buttons = new String[size];
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = temp[i];
		}
		
		String fieldName = GUIBoundary.getUserButtonPressed("Vælg hvilken grund at sælge hus fra", buttons);
		
		Street chosenField = null;
		
		for (Field field : board.getFields())
			if(field.getName().equals(fieldName))
				chosenField = (Street) field;
			
		boolean accept = GUIBoundary.getUserLeftButtonPressed("Salg af hus på " + chosenField.getName() + " vil give " + chosenField.getHousePrice(), "Sælg", "Annuler");
		
		if(accept){
			user.deposit(chosenField.getHousePrice());
			user.setGroundValue(user.getGroundValue() - chosenField.getHousePrice());
			if(chosenField.getHotelAmount() == 1){
				chosenField.setHotelAmount(0);
				chosenField.setHouseAmount(4);
				GUIBoundary.setHotel(chosenField.getFieldNumber(), false);
				GUIBoundary.setHouses(chosenField.getFieldNumber(), 4);
			}else if(chosenField.getHouseAmount() > 0){
				chosenField.setHouseAmount(chosenField.getHouseAmount()-1);	
				GUIBoundary.setHouses(chosenField.getFieldNumber(), chosenField.getHouseAmount());
			}
		}
		
	}
	
}
