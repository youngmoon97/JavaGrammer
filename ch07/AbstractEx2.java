package ch07;

abstract class Abstract2{
	abstract void prn();
}
abstract class Abstact2_1 extends Abstract2{
	abstract void prn2();
}
class Normal2 extends Abstact2_1{
	@Override
	void prn() {
	}
	@Override
	void prn2() {
	}
}
public class AbstractEx2 {

	public static void main(String[] args) {

	}

}
