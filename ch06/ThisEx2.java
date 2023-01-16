package ch06;

import java.lang.*;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.plaf.basic.BasicToggleButtonUI;

public class ThisEx2 extends MFrame
implements ActionListener{
	
	Random r;
	Button btn;
	
	public ThisEx2() {
		btn=new Button("my Button");
		add(btn,"South");
		btn.addActionListener(this);
		r = new Random();
	}
	
	public void actionPerformed(ActionEvent e) {
		//System.out.println("보이나요?");
		MDialog md = new MDialog(this, "보이나요?");
	}
	class MDialog extends Dialog
	implements ActionListener{
		
		Button mbtn;
		ThisEx2 f;
		
		public MDialog(ThisEx2 f, String title) {
			super(f, title,true);
			this.f= f;
			setLayout(new FlowLayout());
			setSize(150, 100);
			mbtn=new Button("Click");
			mbtn.addActionListener(this);
			add(mbtn);
			setVisible(true);
			
		}
		public  Color rColor(){
			int rr,gg,bb;
			rr = r.nextInt(256);
			gg = r.nextInt(256);
			bb = r.nextInt(256);
			return new Color(rr,gg,bb);
		}
@Override
		public void actionPerformed(ActionEvent e) {
			f.btn.setBackground(rColor());
			mbtn.setBackground(rColor());
			//dispose(); //자신의 창 사라지게
		}
	}//--MDialog
	
	public static void main(String[] args) {
		new ThisEx2();
	}

}
