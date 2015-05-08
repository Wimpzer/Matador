package field;

import user.User;

	/**
	 * @author Frederik
	 */

public class Taxes extends Field {
	private int tax;

	/**
	 * Constructor for setting the number, name and tax for the given field.
	 * @param fieldNumber
	 * @param name
	 * @param tax
	 */
	
	public Taxes(int fieldNumber, String name, int tax) {
		super(name);
		this.fieldNumber = fieldNumber;
		this.tax = tax;
	}

	/**
	 * Withdraws the tax amount from users account.
	 */
	
	@Override
	public void landOnField(User user) {
		user.withdraw(tax);
	}

}
