package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesignEx1 extends MFrame2 {
	
	Label label;
	Checkbox cb1,cb2,cb3;
	CheckboxGroup cbg;
	Button btn1, btn2;
	Panel p1,p2,p3;
	
	public DesignEx1() {
		super(250,150);
		this.setLayout(new BorderLayout());
		setTitle("������ ����1");
		label = new Label("���� �߿� ����");
		cbg = new CheckboxGroup();
		cb1 = new Checkbox("���",cbg, false);
		cb2 = new Checkbox("�޵�",cbg, false);
		cb3 = new Checkbox("����",cbg, false);
		btn1 = new Button("Start");
		btn2 = new Button("End");
		
		
		p1= new Panel();
		p2=new Panel();		
		p3=new Panel();
		p1.setBackground(Color.green);
		p1.add(label);
		p2.add(cb1);
		p2.add(cb2);
		p2.add(cb3);
		p3.add(btn1);
		p3.add(btn2);
		
		add(p1, BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
	}

	
	public static void main(String[] args) {
		new DesignEx1();
	}

}

