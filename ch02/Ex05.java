package ch02;

public class Ex05 {

	public static void main(String[] args) {
		int a=10;
		long b=a;//묵시적 형변환
		short c=(short)a;//명시적 형변환
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		a=32768;
		c=(short)a;
		System.out.println(c);
	}

}
