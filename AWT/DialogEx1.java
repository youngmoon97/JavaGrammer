package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogEx1 extends MFrame2
implements ActionListener{
   Button btn;
   String title = "�޼��� ��ȭ����";
   
   public DialogEx1() {
      super(300,300);
      setLayout(new BorderLayout());
      add(btn = new Button("���̱�"),
            BorderLayout.SOUTH);
      setResizable(true);
      btn.addActionListener(this);
   }
   
	@Override
	public void actionPerformed(ActionEvent e) {
		MyDialog md = new MyDialog(this, title, true);
		//���� Frame�� ��ǥ
		int fx = getX();
		int fy = getY();
		//Dialog�� âũ��
		int width = 100;
		int height = 150;
		//int x = fx+getWidth()/2-width/2;
		//int y = fy+getHeight()/2-height/2;		
		md.setSize(width, height);
		md.setLocationRelativeTo(this);
		md.setVisible(true);
	}
   
   // ���� Ŭ���� ���� : �ܺ� Ŭ������ ���� ������ ���谡 �ִ� Ŭ����
   class MyDialog extends Dialog implements ActionListener{
      Button b;
      public MyDialog(Frame owner, String title, boolean modal) {
         super(owner, title, modal);
         setLayout(new FlowLayout());
         b = new Button("Ȯ��");
         b.addActionListener(this);
         add(b);
      }
      @Override
      public void actionPerformed(ActionEvent e) {
         dispose();
      }
   }
   
   public static void main(String[] args) {
      new DialogEx1();
   }

}