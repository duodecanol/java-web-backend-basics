package kr.or.connect.jdbc_example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbc_example.dto.Role;

public class RoleDao {
//	The below two errors must be resolved before execution.
//	SSL connection must be established by default if explicit option isn't set.
//	Unable to load authentication plugin 'caching_sha2_password'
	private static String dburl = "jdbc:mysql://192.168.219.107:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "1111";
	
	/** role 테이블의 모든 자료를 조회하여 role 객체의 list로 만든다.
//	 * @return List List
	 */
	public List<Role> getRoles() {
		List<Role> list = new ArrayList<>();
		
		try {
			Class.forName(  "com.mysql.jdbc.Driver"  );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT description, role_id FROM role order by role_id desc";
		try (   // 시작점에서 try-with-resources 선언하면 finally에서 close할 필요가 없어진다.
				Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)
		) {
			try (ResultSet rs = ps.executeQuery()) {
				
				while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id, description);
					list.add(role); // 반복시마다 Role 인스턴스를 생성하여 list에 추가한다.
				}
			} catch (Exception e) {
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;		
	}
	
	/**
	 * role id를 가지고 role 테이블의 행을 조회한다.
	 * @param roleId (Integer) 쿼리 조건절에 사용할 role id
	 * @return 조건절에 해당하는 행을 프린트한다.
	 */
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName(  "com.mysql.jdbc.Driver"  );
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT role_id, description FROM role WHERE role_id = ?"; // ? 자리에 원하는 값을 넣는다.
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId); // 1번 ?에 roleId를 set
			rs = ps.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("role_id");
				String description = rs.getString(2);
				role = new Role(id, description);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}
		
		return role;		
	}
	
	public int addRole(Role role) {
		int insertCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(  "com.mysql.jdbc.Driver"  );
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "INSERT INTO role (role_id, description) VALUES(?, ?)";

			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, role.getRoleId()); // 쿼리문의 컬럼 나열 순서에 맞춰서 사용한다.
			ps.setString(2, role.getDescription());
			
			insertCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {	
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			} // if
		} // finally
		return insertCount;
	}
	
	public int updateRole(Role role) {
		int updateCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(  "com.mysql.jdbc.Driver"  );
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "UPDATE role SET description = ? WHERE role_id = ?";

			ps = conn.prepareStatement(sql);
			
			ps.setInt(2, role.getRoleId());
			ps.setString(1, role.getDescription());
			
			updateCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {	
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			} // if
		} // finally
		return updateCount;
	}
	
	public int deleteRole(Integer roleId) {
		int deleteCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(  "com.mysql.jdbc.Driver"  );
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "DELETE FROM role WHERE role_id = ?";

			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, roleId);			
			
			deleteCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {	
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			} // if
		} // finally
		return deleteCount;
	}
}
