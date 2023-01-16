package ch09;

interface MyInter1{
	void prn();
}
abstract class MyAbst1{
	abstract void prn();
}

class A implements MyInter1{
	@Override
	public void prn() {
		System.out.println("일반적인 구현방법");
	}
}
class B extends MyAbst1{
	@Override
	void prn() {
		System.out.println("일반적인 구현방법 2");
	}
}

public class AnnoymousEx1 {
	public static void main(String[] args) {
		A a = new A();
		a.prn();
		B b = new B();
		b.prn();
		
		//클래스화를 시켜 다른 곳에서 사용할 목적이 아닌 여기에서만 Only 사용
		new MyInter1() {
			@Override
			public void prn() {
				System.out.println("익명클래스 구현 방법");
			}
		}.prn();;
		new MyAbst1() {
			@Override
			void prn() {
				System.out.println("익명클래스 구현 방법2");
			}
		}.prn();;
	}
}
