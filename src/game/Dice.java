package game;

import interfaces.IDice;

public class Dice implements IDice{
	private final int max = 6;
	private int faceValue1;
	private int faceValue2;
	
	@Override
	public void roll() {
		faceValue1 = (int) (Math.random() * max) + 1;
		faceValue2 = (int) (Math.random() * max) + 1;
	}
	
	public int getSum(){
		return faceValue1 + faceValue2;
	}
	
	public int getFaceValue1(){
		return faceValue1;
	}
	
	public int getFaceValue2(){
		return faceValue2;
	}
	
	public boolean checkEqual(){
		if(faceValue1 == faceValue2){
			return true;
		}else
			return false;
	}
	
}
