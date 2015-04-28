package game;

import java.awt.Color;

import boundary.GUIBoundary;
import desktop_resources.GUI;
import field.Field;
import field.Street;
import user.User;

public class HouseShopping {

	public void buyHouse(User user, Board board){
		int blueMatch, pinkMatch, greenMatch, grayMatch, redMatch, whiteMatch, yellowMatch, purpleMatch;
		blueMatch = pinkMatch = greenMatch = grayMatch = redMatch = whiteMatch = yellowMatch = purpleMatch = 0;
		int amount = 0;

		String[] buttons = countColourMatches(blueMatch, pinkMatch, greenMatch,
				grayMatch, redMatch, whiteMatch, yellowMatch, purpleMatch,
				amount, board);

		String colourInput = GUIBoundary.getUserButtonPressed("Vælg grundfarve du vil købe hus på", buttons);

		colourInputSwitch(user, board, colourInput);
	}
	
	private String[] countColourMatches(int blueMatch, int pinkMatch,
			int greenMatch, int grayMatch, int redMatch, int whiteMatch,
			int yellowMatch, int purpleMatch, int amount, Board board) {
		
		for (Field field : board.fields) {
			if(field instanceof Street){
				Street street = (Street) field;
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

	private void purpleYesNo(User user, Board board) {
		boolean purpleYesNo = GUIBoundary.getUserLeftButtonPressed("Køb af hus på følgende farve koster: " + ((Street) board.getField(37)).getHousePrice(), "Køb hus", "Annuler");
		if(purpleYesNo == true){
			String[] purpleButtons = {"Frederiksberggade", "Rådhuspladsen"};
			String purpleInput = GUIBoundary.getUserButtonPressed("Vælg hvilken grund du vil købe hus på", purpleButtons);
			switch (purpleInput) {
			case "Frederiksberggade":
				Street frederiksberggade = (Street) board.getField(37);
				if(frederiksberggade.getHouseAmount() == 3){
					frederiksberggade.setHotelAmount(1);
					frederiksberggade.setHouseAmount(0);
					GUI.setHouses(37, 0);
					GUI.setHotel(37, true);
				}else{
					frederiksberggade.setHouseAmount(frederiksberggade.getHouseAmount()+1);
					GUI.setHouses(37, frederiksberggade.getHouseAmount());
				}
				user.withdraw(frederiksberggade.getHousePrice());
				break;

			case "Rådhuspladsen":
				Street Raedhuspladsen = (Street) board.getField(39);
				if(Raedhuspladsen.getHouseAmount() == 3){
					Raedhuspladsen.setHotelAmount(1);
					Raedhuspladsen.setHouseAmount(0);
					GUI.setHouses(39, 0);
					GUI.setHotel(39, true);
				}else{
					Raedhuspladsen.setHouseAmount(Raedhuspladsen.getHouseAmount()+1);
					GUI.setHouses(39, Raedhuspladsen.getHouseAmount());
				}
				user.withdraw(Raedhuspladsen.getHousePrice());
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
				if(amagertorv.getHouseAmount() == 3){
					amagertorv.setHotelAmount(1);
					amagertorv.setHouseAmount(0);
					GUI.setHouses(31, 0);
					GUI.setHotel(31, true);
				}else{
					amagertorv.setHouseAmount(amagertorv.getHouseAmount()+1);
					GUI.setHouses(31, amagertorv.getHouseAmount());
				}
				user.withdraw(amagertorv.getHousePrice());
				break;

			case "Vimmelskaftet":
				Street vimmelskaftet = (Street) board.getField(32);
				if(vimmelskaftet.getHouseAmount() == 3){
					vimmelskaftet.setHotelAmount(1);
					vimmelskaftet.setHouseAmount(0);
					GUI.setHouses(32, 0);
					GUI.setHotel(32, true);
				}else{
					vimmelskaftet.setHouseAmount(vimmelskaftet.getHouseAmount()+1);
					GUI.setHouses(32, vimmelskaftet.getHouseAmount());
				}
				user.withdraw(vimmelskaftet.getHousePrice());
				break;

			case "Nygade":
				Street nygade = (Street) board.getField(34);
				if(nygade.getHouseAmount() == 3){
					nygade.setHotelAmount(1);
					nygade.setHouseAmount(0);
					GUI.setHouses(34, 0);
					GUI.setHotel(34, true);
				}else{
					nygade.setHouseAmount(nygade.getHouseAmount()+1);
					GUI.setHouses(34, nygade.getHouseAmount());
				}
				user.withdraw(nygade.getHousePrice());
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
				if(bredgade.getHouseAmount() == 3){
					bredgade.setHotelAmount(1);
					bredgade.setHouseAmount(0);
					GUI.setHouses(26, 0);
					GUI.setHotel(26, true);
				}else{
					bredgade.setHouseAmount(bredgade.getHouseAmount()+1);
					GUI.setHouses(26, bredgade.getHouseAmount());
				}
				user.withdraw(bredgade.getHousePrice());
				break;

			case "Kgs. Nytorv":
				Street kgsNytorv = (Street) board.getField(27);
				if(kgsNytorv.getHouseAmount() == 3){
					kgsNytorv.setHotelAmount(1);
					kgsNytorv.setHouseAmount(0);
					GUI.setHouses(27, 0);
					GUI.setHotel(27, true);
				}else{
					kgsNytorv.setHouseAmount(kgsNytorv.getHouseAmount()+1);
					GUI.setHouses(27, kgsNytorv.getHouseAmount());
				}
				user.withdraw(kgsNytorv.getHousePrice());
				break;

			case "Østergade":
				Street oestergade = (Street) board.getField(29);
				if(oestergade.getHouseAmount() == 3){
					oestergade.setHotelAmount(1);
					oestergade.setHouseAmount(0);
					GUI.setHouses(29, 0);
					GUI.setHotel(29, true);
				}else{
					oestergade.setHouseAmount(oestergade.getHouseAmount()+1);
					GUI.setHouses(29, oestergade.getHouseAmount());
				}
				user.withdraw(oestergade.getHousePrice());
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
				if(trianglen.getHouseAmount() == 3){
					trianglen.setHotelAmount(1);
					trianglen.setHouseAmount(0);
					GUI.setHouses(21, 0);
					GUI.setHotel(21, true);
				}else{
					trianglen.setHouseAmount(trianglen.getHouseAmount()+1);
					GUI.setHouses(21, trianglen.getHouseAmount());
				}
				user.withdraw(trianglen.getHousePrice());
				break;

			case "Østerbrogade":
				Street oesterbrogade = (Street) board.getField(23);
				if(oesterbrogade.getHouseAmount() == 3){
					oesterbrogade.setHotelAmount(1);
					oesterbrogade.setHouseAmount(0);
					GUI.setHouses(23, 0);
					GUI.setHotel(23, true);
				}else{
					oesterbrogade.setHouseAmount(oesterbrogade.getHouseAmount()+1);
					GUI.setHouses(23, oesterbrogade.getHouseAmount());
				}
				user.withdraw(oesterbrogade.getHousePrice());
				break;

			case "Grønningen":
				Street grønningen = (Street) board.getField(24);
				if(grønningen.getHouseAmount() == 3){
					grønningen.setHotelAmount(1);
					grønningen.setHouseAmount(0);
					GUI.setHouses(24, 0);
					GUI.setHotel(24, true);
				}else{
					grønningen.setHouseAmount(grønningen.getHouseAmount()+1);
					GUI.setHouses(24, grønningen.getHouseAmount());
				}
				user.withdraw(grønningen.getHousePrice());
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
				if(bernstorffsvej.getHouseAmount() == 3){
					bernstorffsvej.setHotelAmount(1);
					bernstorffsvej.setHouseAmount(0);
					GUI.setHouses(16, 0);
					GUI.setHotel(16, true);
				}else{
					bernstorffsvej.setHouseAmount(bernstorffsvej.getHouseAmount()+1);
					GUI.setHouses(16, bernstorffsvej.getHouseAmount());
				}
				user.withdraw(bernstorffsvej.getHousePrice());
				break;

			case "Hellerupvej":
				Street hellerupvej = (Street) board.getField(18);
				if(hellerupvej.getHouseAmount() == 3){
					hellerupvej.setHotelAmount(1);
					hellerupvej.setHouseAmount(0);
					GUI.setHouses(18, 0);
					GUI.setHotel(18, true);
				}else{
					hellerupvej.setHouseAmount(hellerupvej.getHouseAmount()+1);
					GUI.setHouses(18, hellerupvej.getHouseAmount());
				}
				user.withdraw(hellerupvej.getHousePrice());
				break;

			case "Strandvejen":
				Street strandvejen = (Street) board.getField(19);
				if(strandvejen.getHouseAmount() == 3){
					strandvejen.setHotelAmount(1);
					strandvejen.setHouseAmount(0);
					GUI.setHouses(19, 0);
					GUI.setHotel(19, true);
				}else{
					strandvejen.setHouseAmount(strandvejen.getHouseAmount()+1);
					GUI.setHouses(19, strandvejen.getHouseAmount());
				}
				user.withdraw(strandvejen.getHousePrice());
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
				if(frederiksbergAlle.getHouseAmount() == 3){
					frederiksbergAlle.setHotelAmount(1);
					frederiksbergAlle.setHouseAmount(0);
					GUI.setHouses(11, 0);
					GUI.setHotel(11, true);
				}else{
					frederiksbergAlle.setHouseAmount(frederiksbergAlle.getHouseAmount()+1);
					GUI.setHouses(11, frederiksbergAlle.getHouseAmount());
				}
				user.withdraw(frederiksbergAlle.getHousePrice());
				break;

			case "Bulowsvej":
				Street bulowsvej = (Street) board.getField(13);
				if(bulowsvej.getHouseAmount() == 3){
					bulowsvej.setHotelAmount(1);
					bulowsvej.setHouseAmount(0);
					GUI.setHouses(13, 0);
					GUI.setHotel(13, true);
				}else{
					bulowsvej.setHouseAmount(bulowsvej.getHouseAmount()+1);
					GUI.setHouses(13, bulowsvej.getHouseAmount());
				}
				user.withdraw(bulowsvej.getHousePrice());
				break;

			case "Gammel Kongevej":
				Street gammelKongevej = (Street) board.getField(14);
				if(gammelKongevej.getHouseAmount() == 3){
					gammelKongevej.setHotelAmount(1);
					gammelKongevej.setHouseAmount(0);
					GUI.setHouses(14, 0);
					GUI.setHotel(14, true);
				}else{
					gammelKongevej.setHouseAmount(gammelKongevej.getHouseAmount()+1);
					GUI.setHouses(14, gammelKongevej.getHouseAmount());
				}
				user.withdraw(gammelKongevej.getHousePrice());
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
				if(roskildevej.getHouseAmount() == 3){
					roskildevej.setHotelAmount(1);
					roskildevej.setHouseAmount(0);
					GUI.setHouses(6, 0);
					GUI.setHotel(6, true);
				}else{
					roskildevej.setHouseAmount(roskildevej.getHouseAmount()+1);
					GUI.setHouses(6, roskildevej.getHouseAmount());
				}
				user.withdraw(roskildevej.getHousePrice());
				break;

			case "Valby Langgade":
				Street valbyLanggade = (Street) board.getField(8);
				if(valbyLanggade.getHouseAmount() == 3){
					valbyLanggade.setHotelAmount(1);
					valbyLanggade.setHouseAmount(0);
					GUI.setHouses(8, 0);
					GUI.setHotel(8, true);
				}else{
					valbyLanggade.setHouseAmount(valbyLanggade.getHouseAmount()+1);
					GUI.setHouses(8, valbyLanggade.getHouseAmount());
				}
				user.withdraw(valbyLanggade.getHousePrice());
				break;

			case "Allegade":
				Street allegade = (Street) board.getField(9);
				if(allegade.getHouseAmount() == 3){
					allegade.setHotelAmount(1);
					allegade.setHouseAmount(0);
					GUI.setHouses(9, 0);
					GUI.setHotel(9, true);
				}else{
					allegade.setHouseAmount(allegade.getHouseAmount()+1);
					GUI.setHouses(9, allegade.getHouseAmount());
				}
				user.withdraw(allegade.getHousePrice());
				break;

			default:
				break;
			}
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
				if(roedovrevej.getHouseAmount() == 3){
					roedovrevej.setHotelAmount(1);
					roedovrevej.setHouseAmount(0);
					GUI.setHouses(2, 0);
					GUI.setHotel(2, true);
				}else{
					roedovrevej.setHouseAmount(roedovrevej.getHouseAmount()+1);
					GUI.setHouses(2, roedovrevej.getHouseAmount());
				}
				user.withdraw(roedovrevej.getHousePrice());
				break;

			case "Hvidovrevej":
				Street hvidovrevej = (Street) board.getField(3);
				if(hvidovrevej.getHouseAmount() == 3){
					hvidovrevej.setHotelAmount(1);
					hvidovrevej.setHouseAmount(0);
					GUI.setHouses(3, 0);
					GUI.setHotel(3, true);
				}else{
					hvidovrevej.setHouseAmount(hvidovrevej.getHouseAmount()+1);
					GUI.setHouses(3, hvidovrevej.getHouseAmount());
				}
				user.withdraw(hvidovrevej.getHousePrice());
				break;

			default:
				break;
			}
		}
	}
	
}
