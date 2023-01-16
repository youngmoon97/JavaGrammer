package ch06;
class Car3{
	   
	   //필드  : 객체의 속성 <- 반드시 ()가 없다
	   
	   String carName;
	   int velocity;
	   String carColor;
	   
	   //메소드 : 객체의 기능 <- 반드시 ()가 있다
	   //주로 반복적인 행동을 메소드로 선언
	   void speedUp(){
	      velocity++;
	   }
	   
	   void speedDown() {
	      velocity--;
	      if(velocity<0)
	         velocity = 0;
	   }
	    
	} 

public class CarEx3 {

	public static void main(String[] args) {
		Car3 c1 = new Car3();
		Car3 c2 = new Car3();
		c1.carName = "아반때";
		c2.carName = "소나타";
		System.out.println("c1 : " + c1.carName);
		System.out.println("c2 : " + c2.carName);
		//System.out.println(c1.toString());
		//System.out.println(c2.toString());
		c2=c1; //참조형의 '='은 call by reference 방식
		//System.out.println(c1.toString());
		//System.out.println(c2.toString());
		c1.carName = "그랜져";
		
		int a=10;
		int b=a; //자바기본형 : call by value
		a=20;
		System.out.println(a+b);
	}

}
