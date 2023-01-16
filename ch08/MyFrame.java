package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class MyFrame extends MFrame 
implements ActionListener{
	
	Button btn; //필드의 목적 : 객체의 속성 , 메서드가 공유할 목적
	boolean flag=false;
	public MyFrame() {
		btn = new Button("Button");
		add(btn, BorderLayout.SOUTH);
		setBackground(Color.orange);
		//actionPerformed 연결메서드 
		//내자신이 ActionListenr 타입이므로 this가 가능
		//버튼을 클릭하면 ActionEvent 객체가 내부적 생성
		btn.addActionListener(this); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(flag) 
			setBackground(Color.orange);
		else
			setBackground(Color.pink);
		flag=!flag;
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}
