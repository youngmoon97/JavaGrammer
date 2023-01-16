package ch04;

public class Ex8 {
			//문제1. 1~30사이의 값중에 3의 배수의 합을 구하시오.
	
			//문제2. 1~30사이의 값중에 짝수와 홀수의 합을 각각 구하시오.
			
			/*문제3. 1~50사이의 3,6,9의 합은?
			Hint : %와 /를 사용. 33/10 => 3
			sum : 627*/
	public static void main(String[] args) {
		int i=0,sum1=0, sum2=0;
		int even=0, odd=0;
		for(i=1;i<=50;i++) {
			String s = Integer.toString(i);	
			
			if(i<=30) {
				if (i%2==0) {
					even+=i;
				}
				else {
					odd+=i;
				}
				if (s.contains("3")||s.contains("6")||s.contains("9")) {
				sum1+=i;
				}
			}
			else {
				if (s.contains("3")||s.contains("6")||s.contains("9")) {
					sum2+=i;
			}
		}
	}
		sum2+=sum1;
		System.out.println("1-30 / 369합"+sum1);
		System.out.println("1-30 / 짝수합"+even);
		System.out.println("1-30 / 홀수합"+odd);
		System.out.println("1-50 / 369합"+sum2);
	}
}
