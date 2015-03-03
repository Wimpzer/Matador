package field;

import user.User;
import interfaces.IField;

public abstract class Field implements IField{

	private String name;
	
	public Field(String name){
		this.setName(name);
	}

	@Override
	abstract public void landOnField(User user);

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
}
