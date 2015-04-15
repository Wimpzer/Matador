package game;

import interfaces.IDice;

public class Dice implements IDice{
	private final int max = 6;
	private int faceValue;
	private int faceValue2;
	
	@Override
	public int roll() {
		faceValue = (int) (Math.random() * max) + 1;
	
		return faceValue;
	}
	
	public int getSum(){
		return faceValue+faceValue2;
	}


	public boolean checkEqual()
	{
		if(faceValue == faceValue2)
			return true;
		else
			return false;
	}

	public String toString(){
		String result = Integer.toString(roll());
		return result;
	}
	
}
