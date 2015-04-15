package boundary;

import java.util.Scanner;

public class Boundary {

	static Scanner scan = new Scanner(System.in);
	
	public static void showOutput(String text){
		System.out.println(text);
	}
	
	public static int scanInt(){
		return scan.nextInt();
	}
	
	public static double scanDouble(){
		return scan.nextDouble();
	}
	
	public static String scanString(){
		return scan.nextLine();
	}
	
}
