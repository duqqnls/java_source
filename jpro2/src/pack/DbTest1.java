package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// MariaDB(원격 DB 서버) 연동 프로그래밍 
public class DbTest1 {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	//생성자 생성
	public DbTest1() {
		// 1. Driver file loading - Mariadb방법  
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Oracle
			// 2? 
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e);
			return;
		}
		
		// 2. DB 서버와 연결 - Mariadb방법 = 어떤 데이터베이스랑 연결할건지 작성해줘야함 / 필수조건 : conn 객체 필요
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			return;
		}
		
		// 3. 연결된 DB서버에 SQL 실행
		try {
			//sangdata 테이블 자료 읽기
			 stmt = conn.createStatement();
			 
//			 rs = stmt.executeQuery("select * from sangdata");
			 rs = stmt.executeQuery("select code, sang, su, dan from sangdata"); // 처럼 써도되는데 귀찮으니 40라인처럼 쓰자 
			 
			 
//			 System.out.println(rs.next());// cursor (레코드 포인터) 이동 후에 아래 출력문 실행시켜야 결과나옴
//			 System.out.println(rs.getString("sang"));
			 while(rs.next()) {
				 String code = rs.getString("code"); //code를 받아서 문자형으로 받을 것 = 계산 안할거임
				 String sangname = rs.getString("sang");
				 int su = rs.getInt("su");
				 int dan = rs.getInt("dan");
				 System.out.println(code + " " + sangname + " " + su + " " + dan);
			 }
			 
			 System.out.println("-----");
			 rs.close(); // ResultSet을 닫고, 아래에서 다시 열기 * 다른 표현의 방법 
			 rs = stmt.executeQuery("select code as 코드, sang as 상품명, su,dan from sangdata");
			 while(rs.next()) {
				 String code = rs.getString("코드"); //code를 받아서 문자형으로 받을 것 = 계산 안할거임
				 String sangname = rs.getString(2);
				 int su = rs.getInt("su");
				 int dan = rs.getInt("dan");
				 System.out.println(code + " " + sangname + " " + su + " " + dan);
			 }
			 
			 
//			 String sql = "select count(*) as cou from sangdata"; // 별명을 써줘야 cou가 먹힘 -1 
			 String sql = "select count(*)from sangdata";
			 rs = stmt.executeQuery(sql);
			 rs.next();
//			 System.out.println("건수 : " + rs.getString("cou")); -1
//			 System.out.println("건수 : " + rs.getString("count(*)")); -2 
			 System.out.println("건수 : " + rs.getString(1)); // count(*)가 '1번째'라는 의미라서 이렇게 써도 먹힌다.
		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		} finally { //에러가 나거나 말거나 무조건 실행 
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
			}
		}
//		System.out.println("go");
	}

	
	public static void main(String[] args) {
		new DbTest1();
	}
}
