package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberMgr {
   
   private DBConnectionMgr pool;
   
   public MemberMgr() {
      pool = DBConnectionMgr.getInstance();
   }
   
   //��� ����Ʈ : select - db1
   public Vector<MemberBean> selectAll(){
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = null;
      Vector<MemberBean> vlist = new Vector<MemberBean>();
      try {
         con = pool.getConnection();
         sql = "select * from tblMember";
         pstmt = con.prepareStatement(sql);
         rs = pstmt.executeQuery();//SQL�� ����
         while(rs.next()) {
            MemberBean bean = new MemberBean();
            bean.setId(rs.getInt("id"));//�÷���
            bean.setName(rs.getString("name"));
            bean.setPhone(rs.getString("phone"));
            bean.setAddress(rs.getString("address"));
            bean.setTeam(rs.getString("team"));
            vlist.addElement(bean);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         pool.freeConnection(con, pstmt, rs);
      }
      return vlist;
   }
   //���� : insert - db2
   public boolean insert(MemberBean bean) {
      Connection con = null;
      PreparedStatement pstmt = null;
      String sql = null;
      boolean flag = false;
      try {
         con = pool.getConnection();
         sql = "insert tblMember values(null,?,?,?,?)";
         pstmt = con.prepareStatement(sql);
         //ù��° ?�� ���� ��� name ���� : 'aaa'
         pstmt.setString(1, bean.getName());
         pstmt.setString(2, bean.getPhone());
         pstmt.setString(3, bean.getAddress());
         pstmt.setString(4, bean.getTeam());
         //insert, update, delete ����� ���ڵ� ����
         int cnt = pstmt.executeUpdate();
         if(cnt==1) flag = true;
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         pool.freeConnection(con, pstmt);
      }
      return flag;
   }
   //�Ѱ��� ���ڵ� : select - db1
   public MemberBean select(int id) {
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         String sql = null;
         MemberBean bean = new MemberBean();
         try {
            con = pool.getConnection();
            sql = "select * from tblMember where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
               bean.setId(rs.getInt("id"));
               bean.setName(rs.getString("name"));
               bean.setPhone(rs.getString("phone"));
               bean.setAddress(rs.getString("address"));
               bean.setTeam(rs.getString("Team"));
            }
            
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            pool.freeConnection(con, pstmt, rs);
         }
         return bean;
      }
   //���� : update - db2
   public boolean update(MemberBean bean) {
      Connection con = null;
      PreparedStatement pstmt = null;
      String sql = null;
      boolean flag = false;
      try {
         con = pool.getConnection();
         sql = "update tblMember set name=?, phone=?,"
               + "address=?, team =?, where id =;";
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, bean.getName());
         pstmt.setString(2, bean.getPhone());
         pstmt.setString(3, bean.getAddress());
         pstmt.setString(4, bean.getTeam());
         pstmt.setInt(5, bean.getId());
         //insert, update, delete�� ����� �ϸ� ����� ���ڵ� ���� ����
         int cnt = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         pool.freeConnection(con, pstmt);
      }
      return flag;
   }
   //���� : delete - db2
   public boolean delete(int id) {
      Connection con = null;
      PreparedStatement pstmt = null;
      String sql = null;
      boolean flag = false;
      try {
         con = pool.getConnection();
         sql = "delete from tblMember where id = ?";
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, id);
         if(pstmt.executeUpdate()==1)
            flag = true;
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         pool.freeConnection(con, pstmt);
      }
      return flag;
   }
   
   //�ּҰ˻�(�����ȣ �˻�) : select - db1
   public Vector<ZipcodeBean> zipcodeSearch(String area3){
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = null;
      Vector<ZipcodeBean> vlist = new Vector<ZipcodeBean>();
      try {
         con = pool.getConnection();
         sql = "select * from tblZipcode " + "where area3 like ?";
         pstmt = con.prepareStatement(sql);
         //like '%�������%'
         pstmt.setString(1, "%" + area3 + "%");
         rs = pstmt.executeQuery();
         while(rs.next()) {
            ZipcodeBean bean = new ZipcodeBean();
            //select �ڿ� �������� �÷��� index
            bean.setZipcode(rs.getString(1));
            bean.setArea1(rs.getString(2));
            bean.setArea2(rs.getString(3));
            bean.setArea3(rs.getString(4));
            vlist.addElement(bean);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         pool.freeConnection(con, pstmt, rs);
      }
      return vlist;
   }
   
   
   
   
   public static void main(String[] args) {
      MemberMgr mgr = new MemberMgr();
      MemberBean bean = new MemberBean();
      bean.setName("ȫ�浿");
      bean.setPhone("010-2222-9999");
      bean.setAddress("�λ�� ������");
      bean.setTeam("���Ǵ�");
//      boolean flag = mgr.insert(bean);
//      System.out.println(flag);
      //�迭�� Vector �ؿ��� �׻� for�� ����
      Vector<MemberBean> vlist = mgr.selectAll();
      for (int i = 0; i < vlist.size(); i++) {
         MemberBean bean1 = vlist.get(i);
         System.out.println(bean1.getId() + "\t"
               + bean1.getName() + "\t"
               + bean1.getPhone() + "\t"
               + bean1.getAddress() + "\t"
               + bean1.getTeam());
      }
   }
}
