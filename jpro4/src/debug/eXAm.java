package debug;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class eXAm {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public eXAm() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			String sql ="";
			
			sql = "select * from buser";
			pstmt = conn.prepareStatement(sql);	
			rs = pstmt.executeQuery();
	
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " +
						rs.getString(2) + " " + 
						rs.getString(3) + " " + 
						rs.getString(4));
			} 
			
		} catch (Exception e) {
			System.out.println("eXAm err : " + e);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("부서명 : ");
		String buserName = sc.next();
		new eXAm();

	}

}
