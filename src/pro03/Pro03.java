package pro03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pro03 {

	public static void main(String[] args) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // Select 할 때만 필요함.

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "SELECT em.employee_id, " + 
					"       em.last_name name, " + 
					"       em.email, "+ 
					"       jo.job_title, " + 
					"       de.department_name, " + 
					"       lo.city " + 
					" FROM employees em, departments de, locations lo, jobs jo" + 
					" WHERE em.department_id = de.department_id" + 
					" AND de.location_id = lo.location_id" + 
					" AND em.job_id = jo.job_id" + 
					" AND city = 'Seattle'" + 
					" AND jo.job_id = 'PU_CLERK'" + 
					" ORDER BY em.employee_id DESC";
			pstmt = conn.prepareStatement(query);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();

			System.out.println("EmployeeId \t Name \t Email \t JobTitle \t DepartmentName \t City");
			
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String jobTitle = rs.getString("job_title");
				String departmentName = rs.getString("department_name");
				String city = rs.getString("city");
				
				System.out.println(employeeId +"\t"+ name +"\t"+ email +"\t"+
								   jobTitle +"\t"+ departmentName +"\t"+ city);
			}

			// 4.결과처리

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

    }


}
