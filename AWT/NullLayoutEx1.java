package AWT;

import java.awt.Button;

public class NullLayoutEx1 extends MFrame2 {
	Button btn1,btn2;
	
	public NullLayoutEx1() {
		setLayout(null);
		btn1 =new Button("button1");
		btn2 =new Button("button2");
		btn1.setBounds(10,50,50,50);
		btn2.setBounds(100,50,50,50);
		add(btn1);
		add(btn2);
	}
	public static void main(String[] args) {
		new NullLayoutEx1();
	}
}
