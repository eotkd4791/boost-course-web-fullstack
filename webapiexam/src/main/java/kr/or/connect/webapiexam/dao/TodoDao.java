package kr.or.connect.webapiexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.webapiexam.dto.Todo;

public class TodoDao {
	public TodoDao() {}
	
	private static String dbUrl = "jdbc:mysql://localhost:3306/boost_course";
	private static String dbUser = "connectuser";
	private static String dbPassword = "1974";
	
	public List<Todo> getTodo() {
		List<Todo> todos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			
			String sql = "select * from todo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				todos.add(new Todo(title));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();					
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}		
		return todos;
	}
	
	public void addTodo(Todo todo) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			String sql = "insert into todo (title, created_at) values (?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, todo.getTitle());
			ps.setObject(2, todo.getCreatedAt());

			ps.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
