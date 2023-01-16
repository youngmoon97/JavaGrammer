package ch06;
//클래스 선언 -> 필드&메서드 -> 객체생성(new, 필드 및 메서드 사용 목적)
class Car2{
	
	void stop() {
		speed=0;
	}
	
	String name;
	int speed;
	int gear;
}


public class CarEx2 {

	public static void main(String[] args) {
		int a=10;
		int b=a+10;
		for (int i = 0; i < 100; i++) {
			Car2 c1 = new Car2();
			//System.out.println(c1.toString());
		}
	
		String s = "asdfasdfa";
		System.out.println(s.toUpperCase());
		int d=32;
		System.out.println(Integer.toBinaryString(d));
	
	}
}
