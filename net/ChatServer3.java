package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class ChatServer3 {

	Vector<ClientThread3> vc;
	ServerSocket server;
	int port = 8003;
	ChatMgr3 mgr;

	public ChatServer3() {
		try {
			vc = new Vector<ClientThread3>();
			server = new ServerSocket(port);
			mgr = new ChatMgr3();
		} catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("****************************************");
		System.out.println("*Welcome Chat Server 3.0...");
		System.out.println("*Ŭ���̾�Ʈ ������ ��ٸ��� �ֽ��ϴ�.");
		System.out.println("****************************************");
		try {
			while (true) {
				Socket sock = server.accept();
				ClientThread3 ct = new ClientThread3(sock);
				ct.start();
				vc.addElement(ct);
			}
		} catch (Exception e) {
			System.err.println("Error in Socket");
			e.printStackTrace();
		}
	}

	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			ClientThread3 ct = vc.elementAt(i);
			ct.sendMessage(msg);
		}
	}

	public void removeClient(ClientThread3 ct) {
		vc.remove(ct);
	}

	// ���ӵ� ��� id ����Ʈ ���� ex) aaa;bbb;ccc;ddd;ȫ�浿;
	public String getIdList() {
		String ids = "";
		for (int i = 0; i < vc.size(); i++) {
			ClientThread3 ct = vc.get(i);
			ids += ct.id + ";";
		}
		return ids;
	}

	// �Ű����� id������ ClientThread3�� �˻�
	public ClientThread3 findClient(String id) {
		ClientThread3 ct = null;
		for (int i = 0; i < vc.size(); i++) {
			ct = vc.get(i);
			if (ct.id.equals(id)) {// �Ű����� id�� Client�� id�� ���ٸ�...
				break;
			}
		} // --for
		return ct;
	}// --findClient

	class ClientThread3 extends Thread {

		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "�͸�";

		public ClientThread3(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter((sock.getOutputStream()), true);
				System.out.println(sock + " ���ӵ�...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (true) {
					String line = in.readLine();
					if (line == null)
						break;
					else
						routine(line);
				}
			} catch (Exception e) {
				removeClient(this);
				System.err.println(sock + "[" + id + "] ������...");
			}
		}

		public void routine(String line) {
			System.out.println("line:" + line);
			int idx = line.indexOf(ChatProtocol3.MODE);
			String cmd = line.substring(0, idx); 
			String data = line.substring(idx + 1); 
			//ID:aaa;1234
			if (cmd.equals(ChatProtocol3.ID)) {
				idx = data.indexOf(';');
				cmd = data.substring(0,idx);
				data = data.substring(idx+1);
				if(mgr.loginChk(cmd, data)) {
					//�α��� ����
					ClientThread3 ct = findClient(cmd);
					if(ct!=null&&ct.id.equals(cmd)) {
						sendMessage(ChatProtocol3.ID+ChatProtocol3.MODE+"C");
					}else {
						id = cmd;
						sendMessage(ChatProtocol3.ID+ChatProtocol3.MODE+"T");
						sendAllMessage(ChatProtocol3.CHATLIST+ChatProtocol3.MODE+getIdList());
						sendAllMessage(ChatProtocol3.CHATALL+ChatProtocol3.MODE+"["+id+"]���� �����Ͽ����ϴ�.");
					}
				}else {
					sendMessage(ChatProtocol3.ID +ChatProtocol3.MODE+"F");
				}
			} else if (cmd.equals(ChatProtocol3.CHAT)) {// CHAT:bbb;�����
				idx = data.indexOf(';');
				cmd/* bbb */ = data.substring(idx);
				data/* ����� */ = data.substring(idx + 1);
				// id : bbb�� ���� Ŭ���̾�Ʈ�� ã�ƾ� �Ѵ�.
				ClientThread3 ct = findClient(cmd);
				if (ct != null) {// ����� �ڽſ��� ����
					ct.sendMessage(ChatProtocol3.CHAT + ChatProtocol3.MODE + "[" + id + "(S)]" + data); 
					// bbb���� ���󰡴°�(����) , data =
					// �ӼӸ�
					sendMessage(ChatProtocol3.CHAT + ChatProtocol3.MODE + "[" + id + "(S)]" + data); 
					// �ڽ�(aaa)���� �����(sendMessage)
				} else {// �ڽſ��� �����°� (aaa)
					sendMessage(ChatProtocol3.CHAT + ChatProtocol3.MODE + "[" + cmd + "]���� �����ڰ� �ƴմϴ�.");
				}
			} else if (cmd.equals(ChatProtocol3.CHATALL)) {
				sendAllMessage(ChatProtocol3.CHATALL + ChatProtocol3.MODE + "[" + id + "]" + data);
			} else if (cmd.equals(ChatProtocol3.MESSAGE)) {
				//MESSAGE:ccc;���� ����?
				ClientThread3 ct = findClient(cmd);
				if(ct!=null) {
					//MESSAGE:aaa;���� ����?
					MessageBean3 bean = new MessageBean3();
					bean.setFid(id);
					bean.setTid(id);
					bean.setMsg(data);
					mgr.insertMsg(bean);
					ct.sendMessage(ChatProtocol2.MESSAGE+
							ChatProtocol2.MODE+id+";"+data);
				}else {
					sendMessage(ChatProtocol2.CHAT+
							ChatProtocol2.MODE+"["+cmd+"]���� �����ڰ� �ƴմϴ�");
				}
			}else if (cmd.equals(ChatProtocol3.MSGLIST)) {
				Vector<MessageBean3> vlist = mgr.getMsgList(id);
				String str = " ";
				for (int i = 0; i < vlist.size(); i++) {
					MessageBean3 bean = vlist.get(i);
					str+= bean.getFid()+",";
					str+= bean.getTid()+",";
					str+= bean.getMsg()+";";
				}
				sendMessage(ChatProtocol3.MSGLIST+ChatProtocol3.MODE+str);
			}
		}

		public void sendMessage(String msg) {
			out.println(msg);
		}
	}

	public static void main(String[] args) {
		new ChatServer3();
	}
}
