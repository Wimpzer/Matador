package interfaces;

public interface IUser {

	void setUserName(String userName);
	String getUserName();
	void deposit(int amount);
	void withdraw(int amount);
	int getBalance();
	int getCurrentPosition();
	void setCurrentPosition(int fieldNumber);
	
}
