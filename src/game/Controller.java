package game;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import user.User;
import desktop_resources.*;
import field.*;

public class Controller {
	ArrayList<User> users = new ArrayList<User>();
	Board board = new Board();
	Dice dice1 = new Dice();
	Dice dice2 = new Dice();
	int playerTurn = 0;

	public void run(){
		//		startMenu();
		testMenu();
		game();
	}

	//TEST MENU
	public void testMenu(){
		users.add(new User("Bjarke", 1, 30));
		GUI.addPlayer(users.get(0).getUserName(), users.get(0).getBalance());
		GUI.setCar(31, "Bjarke");
		users.add(new User("Joakim", 2, 0));
		GUI.addPlayer(users.get(1).getUserName(), users.get(1).getBalance());
		GUI.setCar(1, "Joakim");
	}	



	public void startMenu(){
		Object[] options = {"Start nyt spil",	"Hent seneste gemte spil"};
		int n = JOptionPane.showOptionDialog(null, "Vælg en mulighed", "Matador spillet", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

		if(n == 0){
			GUI.showMessage("Velkommen til spillet");
			int userAmount = GUI.getUserInteger("Indtast antal spillere", 2, 6);
			for (int i = 0; i < userAmount; i++) {
				int j = i+1;
				String userName = GUI.getUserString("Indtast navn på bruger nr. " + j);
				users.add(new User(userName, j, 0));
				GUI.addPlayer(users.get(i).getUserName(), users.get(i).getBalance());
				GUI.setCar(1, userName);
			}			
		}else if(n == 1){
			GUI.showMessage("Dit gamle spil er hentet");
		}
	}

	public void game(){
		while(true){
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
				if(board.getFields()[user.getCurrentPosition()] instanceof Shipping){
					if(((Shipping) board.getFields()[user.getCurrentPosition()]).getOwner() == null){
						String[] options = {"Ja", "Nej"};
						String input = GUI.getUserSelection("Feltet er frit, vil du købe det?", options);
						if(input.equals("Ja")){
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



			GUI.setBalance(user.getUserName(), user.getBalance());

			users.set(playerTurn, user);
			if(playerTurn == users.size()-1){
				playerTurn = 0;
			}else{
				playerTurn++;
			}
		}
	}

	private void playerMove(User user) {
		GUI.showMessage("Det er spiller " + user.getUserNumber() + "'s tur" + " - Slå med terninger");
		int facevalue1 = dice1.roll();
		int facevalue2 = dice2.roll();
		GUI.setDice(facevalue1, facevalue2);
		GUI.removeCar(user.getCurrentPosition()+1, user.getUserName());
		if(user.getCurrentPosition()+facevalue1+facevalue2 > 39){
			user.setCurrentPosition(user.getCurrentPosition() + facevalue1 + facevalue2-40);
			user.deposit(4000);
		}else{
			user.setCurrentPosition(user.getCurrentPosition() + facevalue1 + facevalue2);
		}
		GUI.setCar(user.getCurrentPosition()+1, user.getUserName());
	}
}
