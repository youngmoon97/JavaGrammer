package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEx2 extends MFrame2
implements ActionListener{
	TextField tf;
	TextArea ta;
	Button btn;
	public TextEx2() {
		super(260,300);
		setTitle("MyChat v1.0");
		setLayout(new BorderLayout());
		add(ta = new TextArea(),"Center");
		Color c[] = MColor.rColor2();
		ta.setBackground(c[0]);
		ta.setBackground(c[1]);
		ta.setEditable(false);
		//�׷� �����̳�
		Panel p = new Panel();
		p.add(tf = new TextField(22));
		p.add(btn = new Button("Send"));
		tf.addActionListener(this); //Enter�̺�Ʈ
		btn.addActionListener(this); //Ŭ�� �̺�Ʈ
		add(p,"South");
		validate();
		tf.requestFocus();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = tf.getText().trim();
		if(str.length()==0) {
			str = "�Է��� �ϼ���.";
		}
		ta.append(str+"\n");
		tf.setText("");
		tf.requestFocus();
	}
	public static void main(String[] args) {
		new TextEx2();
	}
}
