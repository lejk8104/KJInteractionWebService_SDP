package kr.ac.sunmoon.server;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang3.builder.StandardToStringStyle;

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
			String url = "jdbc:mysql://localhost:3306/sdp2?useSSL=false";
			String user = "root";
			String password_ = "seiya411";
			
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
			String url = "jdbc:mysql://localhost:3306/sdp2?useSSL=false";
			String user = "root";
			String password_ = "seiya411";
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
			
			String url = "jdbc:mysql://localhost:3306/sdp2?useSSL=false";
			String user = "root";
			String password_ = "seiya411";
			
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
			String url = "jdbc:mysql://localhost:3306/sdp2?useSSL=false";
			String user = "root";
			String password_ = "seiya411";
			
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
	
	private int findLCS(int[][] c, String[] X, String[] Y) {
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
	public String findLCS(String ID) {
		String matchingID = null;
		try {
			String url = "jdbc:mysql://localhost:3306/sdp2?useSSL=false";
			String user = "root";
			String password = "seiya411";
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();
			
			String sql = "select interest1, interest2, interest3, interest4, interest5 from survey where ID = " + ID + ";";
			ResultSet rs = stmt.executeQuery(sql);
			String[] myInterests = new String[5];
			for(int i=1; i<myInterests.length+1; i++)
				myInterests[i] = rs.getString("interest" + i);
			
			sql = "select ID, interest1, interest2, interest3, interest4, interest5 from survey where ID != " + ID + ";";
			rs = stmt.executeQuery(sql);
			String[] interests;
//			String[] myInterests = {"문화교류", "채팅", "여행", "테니스", "독서"};
			int maxLCS = 0;
			ArrayList<String> tmpID = new ArrayList<String>();
			while(rs.next()) {
				interests = new String[5];
				String interest1 = rs.getString("interest1");
				interests[0] = interest1;
				String interest2 = rs.getString("interest2");
				interests[1] = interest2;
				String interest3 = rs.getString("interest3");
				interests[2] = interest3;
				String interest4 = rs.getString("interest4");
				interests[3] = interest4;
				String interest5 = rs.getString("interest5");
				interests[4] = interest5;
				int[][] c = new int[myInterests.length+1][interests.length+1];
				int LCS = findLCS(c, myInterests, interests);
				if(LCS > maxLCS) {
					maxLCS = LCS;
					tmpID.removeAll(tmpID);
				}
				if(LCS >= maxLCS) {
					tmpID.add(rs.getString("ID"));
				}
			}
			matchingID = tmpID.get((int)(Math.random()*tmpID.size()));
			rs.close();
			stmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return matchingID;
	}
	
	
}