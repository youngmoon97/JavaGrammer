package AWT;

import java.awt.Button;

public class ButtonEx1 extends MFrame2 {
	
	Button btn[] = new Button[4];
	String label[] = {"�߰�", "����","��ü����","����"};
	public ButtonEx1() {
		super(250,250);
		setTitle("Button Example");
		for (int i = 0; i < btn.length; i++) {
			add(btn[i] = new Button(label[i]));
			
		}
		validate();
	}
	
	public static void main(String[] args) {
		new ButtonEx1();
	}
}
