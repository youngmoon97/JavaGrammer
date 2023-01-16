package ch11;

import java.util.Iterator;

public class PalindromeEx1 {

	static final int MAX = 100000; 
	
	public static void main(String[] args) {
		/*
		 * 앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 합니다.
		 *   대칭수(palindrome)인 585는 2진수로 나타내도 1001001001가 되어 여전히 대칭수입니다.
        */
		
		//문제1.10진법의 대칭수인 100,000 이하 숫자의 합은 얼마입니까?
		
		//문제2.2진법의 대칭수인 100,000 이하 숫자의 합은 얼마입니까?
		
		//문제3.10진법과 2진법으로 모두 대칭수인 100,000 이하 숫자의 합은 얼마입니까?
		int len=100000;
		int sum1=0;
		for (int i = 0; i < len; i++) {
			int res =0;
			int temp=i;
			while(temp!=0) {
				res *=10;				   //
				res +=temp%10;   //나머지값
				temp/=10;				//몫
			}
			if(i==res)
				sum1+=i;
		}//--1번
		int sum2=0;
		for (int i = 0; i < len; i++) {
			
				String bi = Integer.toBinaryString(i);
				StringBuffer sb = new StringBuffer(bi);
				String reversebi = sb.reverse().toString();
				if(bi.equals(reversebi)) {
					sum2+=i;
				}
			}//--2번
		int sum3=0;

		for (int i = 0; i < len; i++) {
				String si = Integer.toString(i);
				StringBuffer sb1 = new StringBuffer(si);
				String reversesi = sb1.reverse().toString();
				String bi = Integer.toBinaryString(i);
				StringBuffer sb2 = new StringBuffer(bi);
				String reversebi = sb2.reverse().toString();
				if((si.equals(reversesi))&&(bi.equals(reversebi))) {
					sum3+=i;
				}
			}
		
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
		
		//문제 1: 50045040
		//문제 2: 21865050
		//문제 3: 286602
	}
}
