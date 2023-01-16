package ch11;
class Point{
	
}
public class ObjectEx1 {
	public static void main(String[] args) {
		Point p = new Point();
		System.out.println("클래스 이름 : "+p.getClass());
		System.out.println("객체문자열 : "+p.toString()); //toString 생략가능
		System.out.println("해쉬코드 : "+p.hashCode());
		Point p1 = new Point();
		System.out.println("클래스 이름 : "+p1.getClass());
		System.out.println("객체문자열 : "+p1.toString()); //toString 생략가능
		System.out.println("해쉬코드 : "+p1.hashCode());
		String s = new String("금요일");
		System.out.println("객체문자열 : "+s.toString());
	}
}
