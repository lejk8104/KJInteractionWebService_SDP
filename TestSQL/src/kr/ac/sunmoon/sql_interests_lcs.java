package kr.ac.sunmoon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class sql_interests_lcs {
	public static int findLCS(int[][] c, String[] X, String[] Y) {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String url = "jdbc:mysql://localhost:3306/sdp2?useSSL=false";
			String user = "root";
			String password = "seiya411";
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();
			
			String sql = "select ID, interest1, interest2, interest3, interest4, interest5 from survey where ID != 'seiya.u77';";
			ResultSet rs = stmt.executeQuery(sql);
			String[] interests;
			String[] myInterests = {"문화교류", "채팅", "여행", "테니스", "독서"};
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
//				System.out.println(interest1+ ", " + interest2 + ", " + interest3 + ", " + interest4 + ", " + interest5);
			}
			System.out.println(tmpID.get((int)(Math.random()*tmpID.size())));
			rs.close();
			stmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
