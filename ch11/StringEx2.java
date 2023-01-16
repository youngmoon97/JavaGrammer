package ch11;

public class StringEx2 {
	public static void main(String[] args) {
		String str = "Java Programming";
		
		int len=str.length();
		System.out.println("len : "+ len);
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
		String str2= str.substring(5);
		String str3= str.substring(5,10);
		System.out.println("str2 : "+str2);
		System.out.println("str3 : "+str3);
		
		char c1 = str.charAt(8);
		System.out.println("8번째 문자 : " + c1);
		//짝수 자리 문자만 출력하세요.
		for (int i = 0; i < len; i++) {
			if(i%2==0) {
				System.out.println(str.charAt(i));
			}
		}
		//a문자는 몇번째 자리에 있는가?
		int idx1=str.indexOf('a');
		System.out.println("\n"+"idx1 :"+idx1);
		int idx2 = str.lastIndexOf('a');
		System.out.println("idx2 : "+idx2);
		//a를 q로 변환출력하시오.
		System.out.println(str.replace('a', 'q'));
		for (int i = 0; i < len; i++) {
			if(str.charAt(i)=='a') {
				System.out.print('q');
			}else {
				System.out.print(str.charAt(i));
			}
		}
		System.out.println("\n--------------------------");
		//str 반대로 출력
		for (int i = len-1; i >=0; i--) {
			System.out.print(str.charAt(i));
		}
		StringBuffer sb = new StringBuffer(str);
		System.out.println("\n"+sb.reverse());
		
		String str5 = "Java&JSP&Android&Iot&Spring";
		String str6[] = str5.split("&");
		for(int i =0;i<str6.length;i++) {
			System.out.println(str6[i]);
		}
		
		String str7="            JSPStudy";
		System.out.println(str7.trim());
		int idx3 = 22; // 정수를 문자로 변환
		String str8 = String.valueOf(idx3);
		String str9 = idx3+"";
		System.out.println(str8+str9);
	}
}
