package field;

import user.User;

public class Taxes extends Field {
	private int tax;

	public Taxes(int fieldNumber, String name, int tax) {
		super(name);
		this.fieldNumber = fieldNumber;
		this.tax = tax;
	}

	@Override
	public void landOnField(User user) {
		// TODO Auto-generated method stub
		
	}

}
