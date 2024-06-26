package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Study {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public Study() {	
		// 1. 생성자 생성
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e);
			return;
		}
		
		// 2. DB서버와 연결
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e);
			return;
		}
		
		// 3. 연결된 DB서버에 SQL 실행
		try {
			// 1. Scanner을 통한 입력 
			Scanner sc = new Scanner(System.in);
			System.out.print("부서번호:");
			int buserNum = sc.nextInt();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT jikwon_no as 사번, jikwon_name as 이름, buser_name as 부서, jikwon_jik as 직급, jikwon_pay as 연봉 FROM jikwon\r\n"
					+ "INNER JOIN buser ON jikwon.buser_num = buser.buser_no\r\n WHERE buser_num = " + buserNum);
			System.out.println("사번 이름 부서 직급 연봉");
			while(rs.next()) {
				int jikwon_no = rs.getInt("사번");
				String jikwon_name = rs.getString("이름");
				String buser_name = rs.getString("부서");
				String jikwon_jik = rs.getString("직급");
				int jikwon_pay = rs.getInt("연봉");
				System.out.println(jikwon_no + " " + jikwon_name + " " + buser_name + " " + jikwon_jik + " " + jikwon_pay);
				
			}
//			sc.close(); // 입력 받은 후에는 닫아야함 

			// 2. SQL 연동

			String sql = "select count(*) as 건수 from jikwon where buser_num = " + buserNum;
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("건수 : " + rs.getString("건수"));
		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
			
		}
	}

	public static void main(String[] args) {
		new Study();

	}

}
