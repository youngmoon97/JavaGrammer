package ch08;

public class InterfaceEx6 implements Runnable{
	
	String name;
	
	public InterfaceEx6(String name) {
		this.name=name;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i+" : "+name);
			try{
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		InterfaceEx6 a = new InterfaceEx6("첫번째");
		InterfaceEx6 b = new InterfaceEx6("두번째");
		new Thread(a).start();
		new Thread(b).start();		
	}

}
