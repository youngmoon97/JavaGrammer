package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class ChatServer1 {
	public static final int PORT=8001;
	ServerSocket server;
	Vector<ClientThread1> vc;
	
	public ChatServer1() {
		try {
			server = new ServerSocket(PORT);
			vc = new Vector<ClientThread1>();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in Server");
			System.exit(1);
		}
		System.out.println("*****************************");
		System.out.println("ChatServer1 v1.0 ���۵Ǿ����ϴ�.");
		System.out.println("*****************************");
		try {
			while(true) {
				Socket sock = server.accept();
				ClientThread1 ct = new ClientThread1(sock);
				ct.start();
				//������ Ŭ���̾�Ʈ Socket��ü�� Vector ����
				vc.addElement(ct);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error in Socket");
		}
	}
	
	//��ü �����ڿ��� �޼��� ����
	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size() ; i++) {
			ClientThread1 ct = vc.get(i);
			ct.sendMessage(msg);
			System.out.println(ct.id);
		}
	}
	
	//������ ������ Client�� Vector���� ����
	public void removeClient(ClientThread1 ct) {
		vc.remove(ct);
	}
	
	class ClientThread1 extends Thread{
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id;
		
		public ClientThread1(Socket sock) {
			try {
				this.sock= sock;
				in = new BufferedReader(
						new InputStreamReader(sock.getInputStream()));
				out  = new PrintWriter(sock.getOutputStream(),true);
				//sock.toString
				System.out.println(sock+"���ӵ�...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
		try {
			//Client���� ���� ������ �޼���
			out.println("����Ͻ� ���̵� �Է��ϼ���.");
			//Client���� �Է��� id�� ����
			id = in.readLine();
			//������ ��� Client���� welcome �޼��� ����
			sendAllMessage("["+id+"]���� �����Ͽ����ϴ�.");
			String line= "";
			while(true) {
				line=in.readLine();
				if(line==null) {
					break; // Client ���� ����
				}
				sendAllMessage("["+id+"]"+line);
			}
			in.close();
			out.close();
			sock.close();
		} catch (Exception e) {
			//�ڽ��� ��ü�� Vector���� ����
			removeClient(this);
			System.err.println(sock+"������...");
		}
		}
		//Client���� �޼��� ������ �޼ҵ�
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}//--ClientThread1
	
	public static void main(String[] args) {
		new ChatServer1();
	}
}
