package net;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.mysql.cj.protocol.Resultset;

public class ChatMgr3 {
	private DBConnectionMgr pool;
	
	public ChatMgr3() {
		pool = DBConnectionMgr.getInstance();
	}
	//�α���
	public boolean loginChk(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql="select count(id) from tblRegister where id = ? and pwd = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()&&rs.getInt(1)==1)
				flag=true;
//			int cnt = pstmt.executeUpdate();
//			if(cnt == 1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	//���� insert
	public void insertMsg(MessageBean3 bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con=pool.getConnection();
			sql="insert into tblMessage values (null, ?, ?, ?, now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getFid());
			pstmt.setString(2, bean.getTid());
			pstmt.setString(3, bean.getMsg());			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
	}
	
	//���� list
	public Vector<MessageBean3> getMsgList(String id){
		Connection con = null;
		PreparedStatement pstmt=null;
		String sql= null;
		ResultSet rs = null;
		Vector<MessageBean3> vlist = new Vector<MessageBean3>();
		try {
			con = pool.getConnection();
			sql="select * from tblMessage where fid = ? or tid = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MessageBean3 bean = new MessageBean3();
				bean.setNo(rs.getInt("no"));
				bean.setFid(rs.getString("fid"));
				bean.setTid(rs.getString("tid"));
				bean.setMsg(rs.getString("msg"));
				bean.setMdate(rs.getString("mdate"));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return vlist;
	}
	
	//���� get	
	public MessageBean3 getMsg(int no) {
		Connection con = null;
		PreparedStatement pstmt=null;
		String sql= null;
		ResultSet rs = null;
		MessageBean3 bean = new MessageBean3();

		try {
			con = pool.getConnection();
			sql = "select * from tblMessage where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setNo(rs.getInt("no"));
				bean.setFid(rs.getString("fid"));
				bean.setTid(rs.getString("tid"));
				bean.setMsg(rs.getString("msg"));
				bean.setMdate(rs.getString("mdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con);
		}
		return bean;
	}
	public static void main(String[] args) {
		new ChatMgr3();
	}
}
