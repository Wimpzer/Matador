package field;

import user.User;

public class Taxes extends Field {
	private int tax;

	public Taxes(String name, int tax) {
		super(name);
		this.tax = tax;
	}

	@Override
	public void landOnField(User user) {
		// TODO Auto-generated method stub
		
	}

}
