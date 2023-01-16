package ch10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx3{
	public static void main(String[] args) throws InputMismatchException {
		Scanner s= null;
		try {
			int a,b;
			s=new Scanner(System.in);
			System.out.println("첫번째 숫자 : ");
			a = s.nextInt();
			System.out.println("두번째 숫자 : ");
			b = s.nextInt();
			System.out.println(a+"/"+b+"="+(a/b));
		//다중 catch일때는 하위 Exception이 위로 옴
		//} catch (Exception e) { //순차적으로 catch
		//e.printStackTrace();
		}catch (ArithmeticException e) {
			System.out.println("0으로 입력하면 안되요.");
		}catch (InputMismatchException e) {
			System.out.println("숫자만 입력해야합니다.");
		}
		finally{
			s.close();//사용 후에 반드시 닫아야한다.
		}
	}

}
