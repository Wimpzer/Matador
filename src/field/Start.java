package field;

import user.User;

public class Start extends Field {
	private int bonus = 4000;

	public Start(int fieldNumber, String name) {
		super(name);
		this.fieldNumber = fieldNumber;
	}
	
	public void crossStart(User user){
		user.deposit(bonus);
	}

	@Override
	public void landOnField(User user) {
		
	}

}
