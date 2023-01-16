package ch06;

final class Final1{
	
}
//class Final2 extends Final1{}
class Final3{
	final int KIA=1;
	final int SK=2;
	int k;
	public Final3() {
		//KIA=2;
		System.out.println(k);
	}
	public void prn(final int a) {
		//a=10;
		final int b=10; //지역변수(local variable)
		//b=20;
		int c;
		//System.out.println(c);
		int d=10;
		int e;
		e=10;
	}
}
class Final4{
	void prn1() {
		
	}
	final void prn2() {}
}
class Finale5 extends Final4{
	@Override
	void prn1() {}
	//@Override
	//void prn2() {}
}
public class FinalEx1 {

	public static void main(String[] args) {

	}

}
