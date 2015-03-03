package game;

import interfaces.IDice;

public class Dice implements IDice{
	private final int max = 6;
	private int faceValue;
	
	@Override
	public int roll() {
		faceValue = (int) (Math.random() * max) + 1;
		return faceValue;
	}

	@Override
	public int getFaceValue() {
		return faceValue;
	}

	@Override
	public void setFaceValue(int value) {
		faceValue = value;
	}

	public String toString(){
		String result = Integer.toString(faceValue);
		return result;
	}
	
}
