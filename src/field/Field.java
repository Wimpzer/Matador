package field;

import user.User;
import interfaces.IField;

	/**
	 * The parent class for all fields.
	 * @author Andreas og Frederik
	 */

public abstract class Field implements IField{
	private String name;
	protected int fieldNumber;
	
	/**
	 * Constructor for setting the name for the given field.
	 * @param name
	 */
	
	public Field(String name){
		this.name = name;
	}
	
	/**
	 * Returns the number for the given field.
	 * @return
	 */
	
	public int getFieldNumber() {
		return fieldNumber;
	}

	/**
	 * Sets the number for the given field.
	 * @param fieldNumber
	 */
	
	public void setFieldNumber(int fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

	@Override
	abstract public void landOnField(User user);

	/**
	 * Returns the name for the given field.
	 */
	
	@Override
	public String getName() {
		return name;
	}
	
}
