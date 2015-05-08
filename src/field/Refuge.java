package field;

import user.User;

	/**
	 * @author Frederik
	 */

public class Refuge extends Field {

	/**
	 * Constructor for setting the number and name for the given field.
	 * @param fieldNumber
	 * @param name
	 */
	
	public Refuge(int fieldNumber, String name) {
		super(name);
		this.fieldNumber = fieldNumber;
	}

	@Override
	public void landOnField(User user) {
	}

}
