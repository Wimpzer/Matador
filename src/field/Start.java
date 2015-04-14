package field;

import user.User;

public class Start extends Field {
	private int bonus;

	public Start(String name) {
		super(name);
		this.bonus = 4000;
	}
	
	public void crossStart(User user){
		user.deposit(bonus);
	}

	@Override
	public void landOnField(User user) {
		
	}

}
