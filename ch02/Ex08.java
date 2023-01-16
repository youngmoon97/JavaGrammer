package ch02;

public class Ex08 {

	public static void main(String[] args) 
	throws Exception{			
		while(true) {
			int keyCode = System.in.read();
			System.out.println("keyCode : "+ keyCode);
			if(keyCode==113) {
				break;
			}
		}
	}
	

}
