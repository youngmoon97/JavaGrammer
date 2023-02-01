package ch12;

public class SynchronizedEx1 implements Runnable{
	
	public synchronized void a(String who) {
		try {
			Thread.sleep(200);
		} catch (Exception e) {}
		System.out.println(who +"a() ȣ��");
		a(who);
	}
	
	public synchronized void b(String who) {
		try {
			Thread.sleep(200);
		} catch (Exception e) {}
		System.out.println(who +"b() ȣ��");
		b(who);
	}
	
	@Override
	public void run() {
		b(Thread.currentThread().getName());
		
	}

	public static void main(String[] args) {
		SynchronizedEx1 sch = new SynchronizedEx1();
		Thread t1 = new Thread(sch, "ù��°");
		Thread t2 = new Thread(sch, "�ι�°");
		t1.start();
		t2.start();		
	}

}
