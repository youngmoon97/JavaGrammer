package ch10;

public class ExceptionEx1 {

	public static void main(String[] args) {
		try {
			int a=10;
			int b=1;
			System.out.println("a + b = "+ (a+b));
			System.out.println("a - b = "+ (a-b));
			System.out.println("a * b = "+ (a*b));
			System.out.println("a / b = "+ (a/b));
			
		} catch (Exception e) {//예외가 일어나면 실행되는 영역
			System.err.println("0으로 나누면 안되요");
			//System.out.println(e.getMessage());
		}
		System.out.println("성공");
		
	}

}
