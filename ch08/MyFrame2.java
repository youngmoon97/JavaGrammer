package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class MyFrame2 extends MFrame {
	Button btn; 
	boolean flag=false;
	
	public MyFrame2() {
		btn = new Button("Button");
		add(btn, BorderLayout.SOUTH);
		setBackground(Color.orange);
		MyAction ma = new MyAction();
		btn.addActionListener(ma);
	}//--생성자
	
class MyAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		if(flag) 
			setBackground(Color.green);
		else
			setBackground(Color.yellow);
		flag=!flag;
		}
	}
	public static void main(String[] args) {
		new MyFrame2();
	}
}
