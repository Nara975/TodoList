package kr.or.connect.TodoList.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;



public class DBUtill {
	public static Connection getConnection() {
		Connection conn = null;
		String driver = "com.mysql.jdbc.driver";
		String url = "jdbc:mysql://localhost/todolist";
		String user = "todolistuser";
		String password = "todo123!@#";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
		}
		
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		close(conn, ps);
	}
}
