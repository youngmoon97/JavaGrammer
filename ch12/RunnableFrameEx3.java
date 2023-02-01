package ch12;
/*1.thread ���
 * 2.9���� ������ ����(3��3���� ��ġ�� ����)
 * 3.ũ��� 200*200
 * 4.�� ������ �������̰� ������ 30��*/

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import AWT.MColor;

public class RunnableFrameEx3 extends MFrame implements Runnable{
	
	Random r = new Random();
	int x, y;
	Color c;
	
	public RunnableFrameEx3(int x1, int y1) {
		super(200,200);
		setLocation(x1, y1);
		c = MColor.rColor();
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			x = r.nextInt(200);
			y = r.nextInt(200);
			try {
				Thread.sleep(100);
				repaint();
			} catch (InterruptedException e) {}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, 10, 10);
	}
	
	@Override
	public void update(Graphics g) {
		g.clearRect(x, y, 10, 10);
		paint(g);
	}
	
	public static void main(String[] args) {
		RunnableFrameEx3 ra[] = new RunnableFrameEx3[9];
		for (int i = 0; i < ra.length; i++) {
			int x1 = 200 +(200*(i%3));
			int y1 = 200 +(200*(i/3));
			ra[i] = new RunnableFrameEx3(x1, y1);
			new Thread(ra[i]).start();
		}//for
	}


}
