package boundary;

public class Boundary {

	Scanner scan = new Scanner();
	
	public void showOut(String text){
		System.out.println(text);
	}
	
	public int scanInt(){
		return scan.nextInt();
	}
	
	public double scanDouble(){
		return scan.nextDouble();
	}
	
	public String scanString(){
		return scan.nextLine();
	}
	
}
