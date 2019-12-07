package kr.ac.sunmoon.server;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang3.builder.StandardToStringStyle;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import kr.ac.sunmoon.client.KJMembershipService;
import kr.ac.sunmoon.client.LoginService;
import kr.ac.sunmoon.shared.KJMember;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")         //?
public class KJMembershipServiceImpl extends RemoteServiceServlet implements KJMembershipService {
	
	public KJMember findKJmember(String ID, String Name) {
		// TODO Auto-generated method stub
		KJMember kjmember = new KJMember();
		try {
			String url = "jdbc:mysql://localhost:3306/sdp2?useSSL=false";
			String user = "root";
			String password_ = "seiya411";
			
			Connection con = DriverManager.getConnection(url, user, password_);
			
			Statement stmt = con.createStatement();
			String sql = "SELECT* FROM members1hip_data.kjmember Inner Join members1hip_data.local on kjmember.country= local.country; ";
			ResultSet rs1 = stmt.executeQuery(sql);
			while(rs1.next()) {				
				String id = rs1.getString("ID");
				String Password = rs1.getString("PassWord");
				String Check_Password = rs1.getString("Check_Password");
				String name = rs1.getString("Name");
				String Gender = rs1.getString("Gender");
				String Birth = rs1.getString("Birth");
				String Country = rs1.getString("Country");
				String Local = rs1.getString(" Local");
				//패스워드 찾기
				if (ID.equals(id) && Name.equals(name)) {
					kjmember.setID(id);
					kjmember.setCheckPassword(Check_Password);
					kjmember.setName(name);
					kjmember.setGender(Gender);
//					kjmember.setBirth(Birth);
					kjmember.setCountry(Country);
					kjmember.setLocal(Local);
					rs1.close();
					stmt.close();
					con.close();
					return kjmember;
				}
				//아이디찾기
//				else if 
			}
			rs1.close();
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
//		try {
//			String id = kjMember.getID();
//			String url = "jdbc:mysql://localhost:3306/sdp2?useSSL=false";
//			String user = "root";
//			String password_ = "seiya411";
//			Connection con = DriverManager.getConnection(url, user, password_);
//		
//			Statement stmt = con.createStatement();
//			String sql = "SELECT ID kjmember where ID='" + id + "';";
//			ResultSet rs1 = stmt.executeQuery(sql);
//			if(rs1.getMetaData().getColumnCount() == 1) {
//				rs1.close();
//				stmt.close();
//				con.close();
//				return false;
//			}
//			rs1.close();
//			stmt.close();
//			con.close();
//			return true;
//
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
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
			
			String url = "jdbc:mysql://localhost:3306/sdp2?useSSL=false";
			String user = "root";
			String password_ = "seiya411";
			
			Connection con = DriverManager.getConnection(url, user, password_);
			
			Statement stmt = con.createStatement();
			String sql = "INSERT * into kj_members1hip_db values(\"id\", \"password\", \"checkpassword\" , \"name\", \"gender\", \"year\" , \"date\", \"country\", \"local\")";
			ResultSet rs1 = stmt.executeQuery(sql);
			
			rs1.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
			{
			e.printStackTrace();
			}
	}
	
	@Override
	public KJMember LoginService(KJMember loginmember) {
		String id = loginmember.getID();
		String password = loginmember.getPassword();
//		List returnlist = new List();
		try {
			String url = "jdbc:mysql://localhost:3306/sdp2?useSSL=false";
			String user = "root";
			String password_ = "seiya411";
			
			Connection con = DriverManager.getConnection(url, user, password_);
			Statement stmt = con.createStatement();
			String sql = "SELECT ID,Password FROM kjmember;";
			ResultSet rs1 = stmt.executeQuery(sql);
			
			while(rs1.next()) {
				String ID = rs1.getString("ID");
				String Password = rs1.getString("Password");
				if(ID.equals(id) && Password.equals(password)) {
					loginmember.setCheckPassword(rs1.getString("Check_Password"));
					loginmember.setName(rs1.getString("Name"));
					loginmember.setGender(rs1.getString("Gender"));
					loginmember.setBitrh(rs1.getString("Birth"));
					loginmember.setCountry(rs1.getString("Country"));
					loginmember.setEmail(rs1.getString("Email"));
					rs1.close();
					stmt.close();
					con.close();
					return loginmember;
				}
			}
			rs1.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginmember;
	}
	
	private int findLCS(int[][] c, String[] X, String[] Y) { //LCS알고리즘 구현
		for(int i=1; i<X.length+1; i++) {
			for(int j=1; j<Y.length+1; j++) {
				if(X[i-1].equals(Y[j-1]))
					c[i][j] = c[i-1][j-1] + 1;
				else
					c[i][j] = Math.max(c[i][j-1], c[i-1][j]);
			}
		}
		return c[X.length][Y.length];
	}
	
	@Override
	public String findLCS(String ID){
		String matchingID = null;
		try {
			String url = "jdbc:mysql://localhost:3306/sdp2?useSSL=false";
			String user = "root";
			String password = "seiya411";
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();
			
			String sql1 = "select interest1, interest2, interest3, interest4, interest5 from survey where ID = '" + ID + "';";
			ResultSet rs1 = stmt.executeQuery(sql1);
			String[] myInterests = new String[5];
			while(rs1.next()) {
				myInterests[0] = rs1.getString("interest1");
				myInterests[1] = rs1.getString("interest2");
				myInterests[2] = rs1.getString("interest3");
				myInterests[3] = rs1.getString("interest4");
				myInterests[4] = rs1.getString("interest5");
			}
			for(int i=0; i<myInterests.length; i++)
				System.out.println(myInterests[i] + ", ");
			
			String sql2 = "select ID, interest1, interest2, interest3, interest4, interest5 from survey where ID != '" + ID + "';";
			ResultSet rs2 = stmt.executeQuery(sql2);
			String[] interests;
			int maxLCS = 0;
			ArrayList<String> tmpID = new ArrayList<String>();
			while(rs2.next()) {
				interests = new String[5];
				String interest1 = rs2.getString("interest1");
				interests[0] = interest1;
				String interest2 = rs2.getString("interest2");
				interests[1] = interest2;
				String interest3 = rs2.getString("interest3");
				interests[2] = interest3;
				String interest4 = rs2.getString("interest4");
				interests[3] = interest4;
				String interest5 = rs2.getString("interest5");
				interests[4] = interest5;
				int[][] c = new int[myInterests.length+1][interests.length+1];
				int LCS = findLCS(c, myInterests, interests);
				if(LCS > maxLCS) {
					maxLCS = LCS;
					tmpID.removeAll(tmpID);
				}
				if(LCS >= maxLCS) {
					tmpID.add(rs2.getString("ID"));
				}
			}
			matchingID = tmpID.get((int)(Math.random()*tmpID.size()));
			rs2.close();
			stmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return matchingID;
	}
}