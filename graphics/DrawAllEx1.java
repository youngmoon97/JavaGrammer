package graphics;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch06.MFrame;

public class DrawAllEx1 extends MFrame implements ActionListener{
   
   Panel p1,p2;
   int mode=1/*0-��,1-�簢��,2-��*/,color;
   Label l[];
   Checkbox fillcb;
   Checkbox cb[] = new Checkbox[3];
   CheckboxGroup cbg;
   TextField tf[];
   Button b[] = new Button[4];
   Button btn;
   MCanvas canvas;
   String sl[] = {"��","�簢��","��","������"};
   String cl[] = {"R","G","B"};
   String ll[] = {"X1","Y1","X2","Y2 "};
   String rl[] = {"X","Y","W","H "};
   String ol[] = {"X","Y","�ʺ�","����"};
   
   public DrawAllEx1() {
      super(600,600);
      setTitle("���׸���");
      
      makeAWT();
      p1 = new Panel();
      p1.setLayout(new GridLayout(4,1));
      for (int i = 0; i < b.length; i++) {
         p1.add(b[i]);
      }
      add(p1,BorderLayout.EAST);
      p2.setBackground(Color.yellow);
      for (int i = 0; i < l.length; i++) {
         p2.add(l[i]);
         p2.add(tf[i]);
      }
      for (int i = 0; i < cb.length; i++) {
         p2.add(cb[i]);
      }
      p2.add(btn);
//      selectPanel(mode);
      add(p2,BorderLayout.SOUTH);
      add(canvas = new MCanvas());
      validate();
   }
   
   public void selectPanel(int mode) {
	   setTitle(sl[mode] + "�׸���");
	   switch (mode) {
	case 0:
		p2.setBackground(Color.YELLOW);
		for (int i = 0; i < l.length; i++) {
			l[i].setText(ll[i]);
			l[i].setBackground(Color.YELLOW);
		}
		for (int i = 0; i < cb.length; i++) {
			cb[i].setBackground(Color.YELLOW);
		}
		p2.remove(fillcb);
		break;
	case 1:
		p2.remove(fillcb);
		p2.setBackground(Color.PINK);
		for (int i = 0; i < l.length; i++) {
			l[i].setText(rl[i]);
			l[i].setBackground(Color.PINK);
		}
		for (int i = 0; i < cb.length; i++) {
			cb[i].setBackground(Color.PINK);
		}
		p2.add(fillcb,8);
		break;
	case 2:
		p2.remove(fillcb);
		p2.setBackground(Color.CYAN);
		for (int i = 0; i < l.length; i++) {
			l[i].setText(ol[i]);
			l[i].setBackground(Color.CYAN);
		}
		for (int i = 0; i < cb.length; i++) {
			cb[i].setBackground(Color.CYAN);
		}
		p2.add(fillcb,8);
		break;
	}
   }
   
   public void makeAWT(){
      p1 = new Panel();
      p2 = new Panel();
      l = new Label[4];
      for (int i = 0; i < l.length; i++) {
         l[i] = new Label();
      }
      for (int i = 0; i < b.length; i++) {
         b[i] = new Button(sl[i]); 
         b[i].addActionListener(this); 
      }
      tf = new TextField[4];
      for (int i = 0; i < tf.length; i++) {
         tf[i] = new TextField("30",3);
      }
      fillcb = new Checkbox("ä���");
      cbg = new CheckboxGroup();
      for (int i = 0; i < cb.length; i++) {
         cb[i]=new Checkbox(cl[i],cbg,false);
      }
      btn = new  Button("�׸���");
      btn.addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      for (int i = 0; i < b.length; i++) {
		if(obj==b[i]) {
			mode = i;
			selectPanel(mode);
			break;
		}
      }//for
      if(obj==b[3]/*����*/) {
    	  
      }else if(obj==btn/*�׸���*/) {
    	  /*ä���, RGB(color)*/
    	  Checkbox cbx = cbg.getSelectedCheckbox();
    	  for (int i = 0; i < cb.length; i++) {
			if(cbx==cb[i]) {
				color = i;
				break;
			}
		}
    	  canvas.repaint();
      }
   }
   
   class MCanvas extends Canvas {
      @Override
      public void paint(Graphics g) {
    	  //4���� tf�� ���� ���������� ����
    	  int a[] = new int[4];
    	  for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(tf[i].getText());
		}
    	  //color : 0(R), 1(G), 2(B) ����
    	  switch (color) {
    	  case 0:g.setColor(Color.RED); break;
    	  case 1:g.setColor(Color.GREEN); break;
    	  case 2:g.setColor(Color.BLUE); break;    	  
    	  }
    	  //mode : 0 :���׸���, 1: �簢��(ä���), 2: ���׸���(ä���)
    	  switch (mode) {
    	  case 0://��
    		  g.drawLine(a[0], a[1], a[2], a[3]);
    		  break;
    	  case 1:
    		  if(fillcb.getState()) {
    			  g.fillRect(a[0], a[1], a[2], a[3]);
    		  }else {
    			  g.fillRect(a[0], a[1], a[2], a[3]);    			  
    		  }
    		  break;
    	  case 2://��
    		  if(fillcb.getState()) {
    			  g.fillOval(a[0], a[1], a[2], a[3]);
    		  }else {
    			  g.fillOval(a[0], a[1], a[2], a[3]);    			  
    		  }
    		  break;
		}
      }
   }
   
   public static void main(String[] args) {
      new DrawAllEx1();
   }
}