package kr.ac.sunmoon.server;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import kr.ac.sunmoon.client.LoginService;
import kr.ac.sunmoon.shared.KJMember;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")         //?
public class KJMembershipServiceImpl extends RemoteServiceServlet implements kr.ac.sunmoon.client.KJMembershipService {

	@Override
	public KJMember findKJmember(String ID, String Name) {
		// TODO Auto-generated method stub
		KJMember kjmember = new KJMember();
		try {
			String url = "jdbc:mysql://localhost:3306/kj_membership_db?useSSL=false";
			String user = "root";
			String password_ = "0131";
			
			Connection con = DriverManager.getConnection(url, user, password_);
			
			Statement stmt = con.createStatement();
			String sql = "SELECT* FROM membership_data.kjmember Inner Join membership_data.local on kjmember.country= local.country; ";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {				
				String id = rs.getString("ID");
				String Password = rs.getString("PassWord");
				String Check_Password = rs.getString("Check_Password");
				String name = rs.getString("Name");
				String Gender = rs.getString("Gender");
				String Birth = rs.getString("Birth");
				String Country = rs.getString("Country");
				String Local = rs.getString(" Local");
				//패스워드 찾기
				if (ID.equals(id) && Name.equals(name)) {
					kjmember.setID(id);
					kjmember.setCheckPassword(Check_Password);
					kjmember.setName(name);
					kjmember.setGender(Gender);
//					kjmember.setBirth(Birth);
					kjmember.setCountry(Country);
					kjmember.setLocal(Local);
					rs.close();
					stmt.close();
					con.close();
					return kjmember;
				}
				//아이디찾기
//				else if 
			}
			rs.close();
			stmt.close();
			con.close();
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean checkID(KJMember kjMember) {
		// TODO Auto-generated method stub
		try {
			String id = kjMember.getID();
			String url = "jdbc:mysql://localhost:3306/kj_membership_db?useSSL=false";
			String user = "root";
			String password_ = "0131";
			Connection con = DriverManager.getConnection(url, user, password_);
		
			Statement stmt = con.createStatement();
			String sql = "SELECT ID kj_membership_db.kjmember where ID='" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.getMetaData().getColumnCount() == 1) {
				rs.close();
				stmt.close();
				con.close();
				return false;
			}
			rs.close();
			stmt.close();
			con.close();
			return true;

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

//	@Override
	public void Register_Membership(KJMember kjMember) {
		// TODO Auto-generated method stub
		try {
			String id = kjMember.getID();
			String password = kjMember.getPassword();
			String checkpassword = kjMember.getCheckPassword();
			String name = kjMember.getName();
			String gender = kjMember.getGender();
			String birh = kjMember.getBirth();
			String country = kjMember.getCountry();
			String local = kjMember.getLocal();
			
			String url = "jdbc:mysql://localhost:3306/kj_membership_db?useSSL=false";
			String user = "root";
			String password_ = "0131";
			
			Connection con = DriverManager.getConnection(url, user, password_);
			
			Statement stmt = con.createStatement();
			String sql = "INSERT * into kj_membership_db values(\"id\", \"password\", \"checkpassword\" , \"name\", \"gender\", \"year\" , \"date\", \"country\", \"local\")";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
			{
			e.printStackTrace();
			}
	}
	
	public boolean LoginService(KJMember crKjMember) {
		String id = crKjMember.getID();
		String password = crKjMember.getPassword();
		List returnlist = new List();
		try {
			String url = "jdbc:mysql://localhost:3306/kj_membership_db?useSSL=false";
			String user = "root";
			String password_ = "0131";
			
			Connection con = DriverManager.getConnection(url, user, password_);
			Statement stmt = con.createStatement();
			String sql = "SELECT ID,Password FROM kj_membership_db.`membership_data.kjmember`;";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String ID = rs.getString("ID");
				String Password = rs.getString("Password");
				if(ID.equals(id) && Password.equals(password)) {
					rs.close();
					stmt.close();
					con.close();
					return true;
				}
			}
			rs.close();
			stmt.close();
			con.close();
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}