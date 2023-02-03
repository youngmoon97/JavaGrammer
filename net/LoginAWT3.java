package net;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;

class LoginAWT3 extends JFrame implements ActionListener {

	TextField idTf, pwTf;
	Label logo, idl, pwl, msgl;
	Button logBtn;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	String id;
	String host = "127.0.0.1";
	int port = 8003;
	String title = "MyChat3.0";
	String label[] = { "ID�� PWD�� �Է��ϼ���.", "ID�� PWD�� Ȯ���ϼ���.", "���� �����Դϴ�." };

	public LoginAWT3() {
		setSize(450, 400);
		getContentPane().setBackground(new Color(100, 200, 100));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle(title);
		logo = new Label(title);
		logo.setFont(new Font("Dialog", Font.BOLD, 50));

		idl = new Label("ID");
		pwl = new Label("PWD");
		idTf = new TextField("aaa");
		pwTf = new TextField("1234");
		logBtn = new Button("�α���");
		msgl = new Label(label[0]);
		logo.setBounds(100, 50, 250, 100);
		idl.setBounds(150, 200, 50, 20);
		idTf.setBounds(200, 200, 100, 20);
		pwl.setBounds(150, 230, 50, 20);
		pwTf.setBounds(200, 230, 100, 20);
		logBtn.setBounds(150, 260, 150, 40);
		msgl.setBounds(150, 320, 150, 40);
		logBtn.addActionListener(this);
		add(logo);
		add(idl);
		add(idTf);
		add(pwl);
		add(pwTf);
		add(logBtn);
		add(msgl);
		setVisible(true);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object obj = e.getSource();
			if(obj==logBtn) {
				if(sock==null) {
					//ó���õ�
					connect();
					
				}
				id =idTf.getText().trim();
				out.println(ChatProtocol3.ID+
						ChatProtocol3.MODE+id+";"+pwTf.getText().trim());
				String line=in.readLine();
				int idx= line.indexOf(ChatProtocol3.MODE);
				String cmd=line.substring(0,idx);
				String data=line.substring(idx+1);
				//cmd : ID / data = T,F,C
				if(cmd.equals(ChatProtocol3.ID)) {
					if(data.equals("F")) {
						msgl.setForeground(Color.red);
						msgl.setText(label[1]);
					}else if(data.equals("C")) {
						msgl.setForeground(Color.blue);
						msgl.setText(label[2]);						
					}else if(data.equals("T")) {
						//msgl.setText("�α��μ���");
						dispose();
						new ChatClient3(in,out,id);
					}//--if3
				}//--if2
			}//--if1
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public void connect() {
		try {
			sock = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true/* auto flush */);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// --connect

	public static void main(String[] args) {
		new LoginAWT3();
	}
}
