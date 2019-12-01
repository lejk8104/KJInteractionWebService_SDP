package kr.ac.sunmoon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class sql_interests_lcs {
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
	
	public void findLCS(String ID){
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
		System.out.println(matchingID);
	}
}
