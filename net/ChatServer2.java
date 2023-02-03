package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.security.auth.callback.CallbackHandler;

public class ChatServer2 {
   
   public static final int PORT = 8002;
   ServerSocket server;
   Vector<ClientThread2> vc;
   
   public ChatServer2() {
      try {
         server = new ServerSocket(PORT);
         vc = new Vector<ClientThread2>();
      } catch (Exception e) {
         //e.printStackTrace();
         System.err.println("Error in Server");
         System.exit(1);//���������� ����
      }
      System.out.println("******Chat Server 2.0******");
      System.out.println("*Ŭ���̾�Ʈ ������ ��ٸ��� �ֽ��ϴ�.*");
      System.out.println("*************************");
      try {
         while(true) {
            Socket sock = server.accept();
            ClientThread2 ct = new ClientThread2(sock);
            ct.start();
            //������ Ŭ���̾�Ʈ Socket��ü�� Vector ����
            vc.addElement(ct);
         }
      } catch (Exception e) {
         //e.printStackTrace();
         System.err.println("Error in Socket");
      }
   }
   
   public void sendAllMessage(String msg) {
      for (int i = 0; i < vc.size(); i++) {
         ClientThread2 ct = vc.get(i);
         ct.sendMessage(msg);
      }
   }
   
   public void removeClient(ClientThread2 ct) {
      vc.remove(ct);
   }
   
   //���ӵ� ��� id ����Ʈ ���� ex)aaa;bbb;ȫ�浿;��ȣ��;
   public String getIdList() {
      String list = "";
      for (int i = 0; i < vc.size(); i++) {
         ClientThread2 ct = vc.get(i);
         list+=ct.id+";";
      }
      return list;
   }
   
   //�Ű����� id������ ClientThread2�� �˻�
   public ClientThread2 findClient(String id) {
      ClientThread2 ct = null;
      for (int i = 0; i < vc.size(); i++) {
         ct = vc.get(i);
         if(ct.id.equals(id))//�Ű������� id�� ct�� id�� ���� �ϴٸ�.
            break;
      }
      return ct;
   }
   
   class ClientThread2 extends Thread {
      
      Socket sock;
      BufferedReader in;
      PrintWriter out;
      String id;   
      
      public ClientThread2(Socket sock) {
         try {
            this.sock = sock;         
            in = new BufferedReader(
                  new InputStreamReader(sock.getInputStream()));
            out = new PrintWriter(sock.getOutputStream(),true);
            //sock.toString();
            System.out.println(sock + "���ӵ�...");
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      
      @Override
      public void run() {
         try {
            sendMessage("����Ͻ� ���̵� �Է��ϼ���");
            while(true) {
               String line = in.readLine();
               if(line==null)
                  break;
               else
                  routine(line);
            }
         } catch (Exception e) {
            removeClient(this);
            System.err.println(sock + "[" + id +"] ������...");
         }
      }
      
      public void routine(String line) {
         //CHATALL:������ ������Դϴ�.
         int idx = line.indexOf(':');
         String cmd = line.substring(idx);//CHATALL
         String data = line.substring(idx + 1);//������ ������Դϴ�.
         if(cmd.equals(ChatProtocol2.ID)) {
            id = data;
            //���ο� ������ �߰� �Ǿ��� ������ ����Ʈ ������
            sendAllMessage(ChatProtocol2.CHATLIST+
            		ChatProtocol2.MODE + getIdList());
            //���ο� ������ welcome ����
            sendAllMessage(ChatProtocol2.CHATALL+
            		ChatProtocol2.MODE + "[" + id + "]���� �����Ͽ����ϴ�.");
            
         }else if(cmd.equals(ChatProtocol2.CHATALL)) {
            sendAllMessage(ChatProtocol2.CHATALL+
            		ChatProtocol2.MODE + "[" + id + "]" + data);
            
         }else if(cmd.equals(ChatProtocol2.CHAT)) {
        	 	idx = data.indexOf(';');
        	 	cmd= data.substring(0, idx);
        	 	data = data.substring(idx+1);
        	 	ClientThread2 ct = findClient(cmd);
        	 	if(ct!=null) {
        	 		//bbb���� ����
        	 		ct.sendMessage(ChatProtocol2.CHAT+
        	 				ChatProtocol2.MODE+"["+id+"(S)]"+data);
        	 		//�ڽſ��� ����
        	 		sendMessage(ChatProtocol2.CHAT+
        	 				ChatProtocol2.MODE+"["+id+"(S)]"+data);
        	 	}else {
        	 		//�ڽſ��� ������ �޼���
        	 		sendMessage(ChatProtocol2.CHAT+
        	 				ChatProtocol2.MODE+"["+cmd+"]���� �����ڰ� �ƴմϴ�.");
        	 	}
        	 	
         }else if(cmd.equals(ChatProtocol2.MESSAGE)) {
        	 //MESSAGE : ccc;���ù���?
        	 idx = data.indexOf(';');
     	 	cmd= data.substring(0, idx);	//ccc
     	 	data = data.substring(idx+1);//���ù���?
     	 	ClientThread2 ct = findClient(cmd);
     	 	if(ct!=null) {
     	 		ct.sendMessage(ChatProtocol2.MESSAGE+
     	 				ChatProtocol2.MODE+id+";"+data);
     	 	}else {
     	 		//�ڽſ��� ������ �޼���
    	 		sendMessage(ChatProtocol2.CHAT+
    	 				ChatProtocol2.MODE+"["+cmd+"]���� �����ڰ� �ƴմϴ�.");
    	 	}
         }
      }
      
      public void sendMessage(String msg) {
         out.println(msg);
      }
      
   }//--ClientThread2
   
   
   public static void main(String[] args) {
      new ChatServer2();
//      String str = "CHATALL:������ ������Դϴ�.";
//      int idx = str.indexOf(':');
//      System.out.println(str.substring(0, idx));
//      System.out.println(str.substring(idx + 1));
   }

}