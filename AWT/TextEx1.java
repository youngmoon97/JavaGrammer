package AWT;

import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEx1 extends MFrame2 
implements ActionListener {
	
	TextField tf1 ,tf2;
	TextArea ta;
	
	public TextEx1() {
		super(250,300);
		add(new Label("����"));
		add(tf1 = new TextField("ȫ�浿",20));
		add(new Label("���"));
		add(tf2 = new TextField("",20));
		tf2.setEchoChar('@');
		add(ta=new TextArea(10,30));
		ta.setEditable(false);
		
		tf2.addActionListener(this);
		
		validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ta.append(tf1.getText()+" / "+tf2.getText()+"\n");
		tf1.setText("");
		tf2.setText("");
		tf1.requestFocus();
	}

	public static void main(String[] args) {
		new TextEx1();

	}

}
