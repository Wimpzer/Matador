package game;

import interfaces.IDice;

	/**
	 * @author Bjarke, Frederik
	 */

public class Dice implements IDice{
	private final int max = 6;
	private int faceValue1;
	private int faceValue2;
	
	/**
	 * Does a representation of two dices, by saving two random generated
	 * numbers into two variables.
	 */
	
	@Override
	public void roll() {
		faceValue1 = (int) (Math.random() * max) + 1;
		faceValue2 = (int) (Math.random() * max) + 1;
	}
	
	/**
	 * Returns the sum of the two dices.
	 */
	
	public int getSum(){
		return faceValue1 + faceValue2;
	}
	
	/**
	 * Returns the value of the first dice.
	 * @return
	 */
	
	public int getFaceValue1(){
		return faceValue1;
	}
	
	/**
	 * Sets the value of the first dice.
	 * @param value
	 */
	
	public void setFaceValue1(int value){
		faceValue1 = value;
	}
	
	/**
	 * Returns the value of the second dice.
	 * @return
	 */
	
	public int getFaceValue2(){
		return faceValue2;
	}
	
	/**
	 * Sets the value of the second dice.
	 * @param value
	 */
	
	public void setFaceValue2(int value){
		faceValue2 = value;
	}
	
	/**
	 * Checks if the two dices are the same value.
	 * If so returns true, else false.
	 */
	
	public boolean checkEqual(){
		if(faceValue1 == faceValue2){
			return true;
		}else
			return false;
	}
	
}
