package net;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class ChatClient2 extends JFrame 
implements ActionListener, Runnable {

   JButton bt1, bt2, bt3, bt4;
   JTextField tf1, tf2, tf3;
   TextArea area;
   List list;
   Socket sock;
   BufferedReader in;
   PrintWriter out;
   String listTitle = "*******��ȭ�ڸ��*******";
   boolean flag = false;

   public ChatClient2() {
      setSize(450, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("MyChat v2.0");
      JPanel p1 = new JPanel();
      p1.add(new Label("Host", Label.RIGHT));
      p1.add(tf1 = new JTextField("127.0.0.1", 10));
      p1.add(new Label("Port", Label.RIGHT));
      p1.add(tf2 = new JTextField("8002",5));
      bt1 = new JButton("connect");
      bt1.addActionListener(this);
      p1.add(bt1);
      add(BorderLayout.NORTH, p1);
      // //////////////////////////////////////////////////////////////////////////////////////////
      area = new TextArea("MyChat v2.0");
      area.setBackground(Color.DARK_GRAY);
      area.setForeground(Color.PINK);
      area.setEditable(false);
      add(BorderLayout.CENTER, area);
      // /////////////////////////////////////////////////////////////////////////////////////////
      JPanel p2 = new JPanel();
      p2.setLayout(new BorderLayout());
      list = new List();
      list.add(listTitle);
      p2.add(BorderLayout.CENTER, list);
      JPanel p3 = new JPanel();
      p3.setLayout(new GridLayout(1, 2));
      bt2 = new JButton("Save");
      bt2.addActionListener(this);
      bt3 = new JButton("Message");
      bt3.addActionListener(this);
      p3.add(bt2);
      p3.add(bt3);
      p2.add(BorderLayout.SOUTH, p3);
      add(BorderLayout.EAST, p2);
      // ///////////////////////////////////////////////////////////////////////////////////////////
      JPanel p4 = new JPanel();
      tf3 = new JTextField("", 30);
      tf3.addActionListener(this);
      bt4 = new JButton("send");
      bt4.addActionListener(this);
      p4.add(tf3);
      p4.add(bt4);
      add(BorderLayout.SOUTH, p4);
      setVisible(true);
      validate();
   }
   
   public void run() {
      try {
         String host = tf1.getText().trim();
         int port = Integer.parseInt(tf2.getText().trim());
         connect(host,port);
         // ���� -> ����Ͻ� ���̵� �Է��ϼ���.
         area.append(in.readLine());
         while(true) {
            String line = in.readLine();
            if(line == null)
               break;
            else
               routine(line);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }//--run
   
   public void routine(String line) {
      int idx = line.indexOf(ChatProtocol2.MODE);
      String cmd = line.substring(0, idx);
      String data = line.substring(idx+1);
      if(cmd.equals(ChatProtocol2.CHATLIST)) {
         // data = aaa;bbb;ccc;ȫ�浿;
         list.removeAll();//������ ����Ʈ ������ ���� ����
         list.add(listTitle);
         StringTokenizer st = new StringTokenizer(data, ";");
         while(st.hasMoreElements()) {
            list.add(st.nextToken());
         }
      }else if(cmd.equals(ChatProtocol2.CHATALL) || 
            cmd.equals(ChatProtocol2.CHAT)) {
         area.append(data + "\n");
      }else if(cmd.equals(ChatProtocol2.MESSAGE)) {
         //data => ccc;���� ����?
         idx = data.indexOf(';');
         cmd = data.substring(0, idx);
         data = data.substring(idx + 1);
         new Message("FROM:", cmd, data);
      }
      
   }//--routine
   
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if(obj==bt1) {//connect
         new Thread(this).start();//run�޼ҵ� ȣ�� ���
         bt1.setEnabled(false);
         tf1.setEnabled(false);
         tf2.setEnabled(false);
         area.setText("");
      }else if(obj==bt2) {//save
         long fileName = System.currentTimeMillis();
         try {
            FileWriter fw = new FileWriter("net/" + fileName + ".txt");
            fw.write(area.getText());
            fw.close();
            area.setText("");
            new MDialog(this, "Save", "��ȭ������ �����Ͽ����ϴ�.");
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }else if(obj==bt3) {//message
         //����Ʈ�� ���� Ŀ���� �ִ� ��ġ��
         int idx = list.getSelectedIndex();
         if(idx == 0 || idx == -1) {
            new MDialog(this, "�˸�", "���̵� �����ϼ���.");
         }else {
            new Message("TO:");
         }
      }else if(obj==bt4||obj==tf3) {//send
         String str = tf3.getText();
         if(filterMgr(str)) {
            new MDialog(this, "���", "�Է��Ͻ� ���ڴ� �������Դϴ�");
            return;
         }
         if(!flag)/*���̵� �Է�*/{
            sendMessage(ChatProtocol2.ID +
                  ChatProtocol2.MODE+str);
            setTitle(getTitle()+ " - " + str + "�� �ݰ����ϴ�");
            area.setText("");
            tf3.setText("");
            tf3.requestFocus();
            flag = true;
         }else/*�Ϲ�ä��*/{
            int idx = list.getSelectedIndex();
            if(idx == 0 || idx == -1) {
               sendMessage(ChatProtocol2.CHATALL +
                     ChatProtocol2.MODE + str);
            }else/*�ӼӸ� ä��*/ {
               String id = list.getSelectedItem();
               sendMessage(ChatProtocol2.CHAT + 
                     ChatProtocol2.MODE + id + ";" + str);
            }
            tf3.setText("");
            tf3.requestFocus();
         }
      }
   }//--actionPerformed
   
   public void connect(String host, int port) {
      try {
         sock = new Socket(host, port);
         in = new BufferedReader(
               new InputStreamReader(
                     sock.getInputStream()));
         out = new PrintWriter(
               sock.getOutputStream(),true/*auto flush*/);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }//--connect
   
   public void sendMessage(String msg) {
      out.println(msg);
   }

   public boolean filterMgr(String msg){
      boolean flag = false;//false�̸� ������ �ƴ�
      String str[] = {"�ٺ�","������","����","�ڹ�","java"};
      //msg : ���� ȣȣ ����
      StringTokenizer st = new StringTokenizer(msg);//�����ϸ� �����ڴ� ����
      String msgs[] = new String[st.countTokens()];
      for (int i = 0; i < msgs.length; i++) {
         msgs[i] = st.nextToken();
      }
      for (int i = 0; i < str.length; i++) {
         if(flag) break;//ù��° for�� ��������.
         for (int j = 0; j < msgs.length; j++) {
            if(str[i].equalsIgnoreCase(msgs[j])) {
               flag = true;
               break; //�ι�° for�� ��������.
            }//if
         }//for2
      }//for1
      return flag;
   }
   
   class Message extends Frame implements ActionListener {

      Button send, close;
      TextField name;
      TextArea ta;
      String mode;// to/from
      String id;

      public Message(String mode) {
         setTitle("����������");
         this.mode = mode;
         id = list.getSelectedItem();
         layset("");
         validate();
      }
      public Message(String mode, String id, String msg) {
         setTitle("�����б�");
         this.mode = mode;
         this.id = id;
         layset(msg);
         validate();
      }
      public void layset(String msg) {
          addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) {
                dispose();
               }
         });
         Panel p1 = new Panel();
         p1.add(new Label(mode, Label.CENTER));
         name = new TextField(id, 20);
         p1.add(name);
         add(BorderLayout.NORTH, p1);
         
         ta = new TextArea("");
         add(BorderLayout.CENTER, ta);
         ta.setText(msg);
         Panel p2 = new Panel();
         if (mode.equals("TO:")) {
            p2.add(send = new Button("send"));
            send.addActionListener(this);
         }
         p2.add(close = new Button("close"));
         close.addActionListener(this);
         add(BorderLayout.SOUTH, p2);
         
         setBounds(200, 200, 250, 250);
         setVisible(true);
      }

      public void actionPerformed(ActionEvent e) {
         if(e.getSource()==send){
            sendMessage(ChatProtocol2.MESSAGE+
                  ":"+id+";"+ ta.getText());
         }
         setVisible(false);
         dispose();
      }
   }

   class MDialog extends Dialog implements ActionListener{
      
      Button ok;
      ChatClient2 ct2;
      
      public MDialog(ChatClient2 ct2,String title, String msg) {
         super(ct2, title, true);
         this.ct2 = ct2;
          //////////////////////////////////////////////////////////////////////////////////////////
            addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent e) {
              dispose();
             }
            });
            /////////////////////////////////////////////////////////////////////////////////////////
            setLayout(new GridLayout(2,1));
            Label label = new Label(msg, Label.CENTER);
            add(label);
            add(ok = new Button("Ȯ��"));
            ok.addActionListener(this);
            layset();
            setVisible(true);
            validate();
      }
      
      public void layset() {
         int x = ct2.getX();
         int y = ct2.getY();
         int w = ct2.getWidth();
         int h = ct2.getHeight();
         int w1 = 150;
         int h1 = 100;
         setBounds(x + w / 2 - w1 / 2, 
               y + h / 2 - h1 / 2, 200, 100);
      }

      public void actionPerformed(ActionEvent e) {
         tf3.setText("");
         dispose();
      }
   }
   
   public static void main(String[] args) {
      new ChatClient2();
   }
}