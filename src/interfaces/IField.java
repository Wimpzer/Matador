package interfaces;

import user.User;

public interface IField {

	abstract void landOnField(User user);
	String getName();
	void setName(String name);
	
}
