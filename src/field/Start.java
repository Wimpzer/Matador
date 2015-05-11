package field;

import user.User;

	/**
	 * @author Frederik
	 */

public class Start extends Field {
	private int bonus = 4000;

	/**
	 * Constructor for setting the number and name for the given field.
	 * @param fieldNumber
	 * @param name
	 */
	
	public Start(int fieldNumber, String name) {
		super(name);
		this.fieldNumber = fieldNumber;
	}
	
	/**
	 * Deposits the bonus amount into the users account. Used when the
	 * user is passing start on the board.
	 * @param user
	 */
	
	public void crossStart(User user){
		user.deposit(bonus);
	}
	
	@Override
	public void landOnField(User user) {
		
	}

}
