package ch06;

//클래스 선언 (class + 클래스명), 객체를 만드는 틀(ex - 붕어빵 틀) 
//예약어는 클래스명으로 사용 x
class Car1{
   
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
   
   void stop() {
      velocity = 0;
   }
   
} //class Car1

// .java로 선언된 클래스만 public사용 가능
public class CarEx1 {

   public static void main(String[] args) {
      int arr[] = new int[3];
      System.out.println(arr.length);
      String str = "오늘의 메뉴는 수구레";
      System.out.println(str.length());
      
      Car1 c1=new Car1();
      c1.carName = "소나타";
      c1.carColor = "흰색";
      c1.speedUp();
      System.out.println(c1.carName);
      System.out.println(c1.carColor);
      System.out.println(c1.velocity);
   }

}