package kr.or.connect.TodoList.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.TodoList.dto.TodoDto;


public class TodoDao {
	
	//할일 등록
	public int addTodo(TodoDto td) {
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "insert into todo(title, name, sequence) values(?,?,?);";
		
		try {
			conn = DBUtill.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, td.getTitle());
			ps.setString(2, td.getName());
			ps.setInt(3, td.getSequence());
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(conn, ps);
		}
		return count;
	}
	
	
	//할일 모두 불러오기 
	public List<TodoDto> allTodo(){
		List<TodoDto> list = new ArrayList<TodoDto>();
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from todo";
		
		try {
			conn = DBUtill.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Long id = rs.getLong(1);
				String title = rs.getString(2);
				String name = rs.getString(3);
				int sequence = rs.getInt(4);
				String type = rs.getString(5);
				String regDate = rs.getString(6).substring(0, 10);
				TodoDto dto = new TodoDto(id, title, name, sequence, type, regDate);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(conn, ps, rs);
		}
		
		return list;
	}
	
	
	//타입 변경 
	//TODO -> DOING, DOING -> DONE
	public int updateTodo (Long id) {
		int count = 0;
		Connection conn =null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		
		String sql1 = "update todo set type='DOING' where type='TODO' and id=?;";
		String sql2 = "update todo set type='DONE' where type='DOING' and id=?;";
		
		// TODO -> DOING
		try {
			conn = DBUtill.getConnection();
			ps1 = conn.prepareStatement(sql1);
			ps1.setLong(1, id);
			count = ps1.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(conn, ps1);
		}
		
		// DOING -> DONE
		try {
			conn = DBUtill.getConnection();
			ps2 = conn.prepareStatement(sql2);
			ps2.setLong(1, id);
			count = ps2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(conn, ps2);
		}
		
		return count;
	}
	
	
	//완료 한 일 삭제 
	public int deleteTodo(Long id) {
		int count = 0;
		Connection conn =null;
		PreparedStatement ps = null;
		
		String sql = "delete from todo where id=?;";
		
		try {
			conn = DBUtill.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(conn, ps);
		}
		
		return count;
	}
	
	
	
	
	
	
	
	
	
}
