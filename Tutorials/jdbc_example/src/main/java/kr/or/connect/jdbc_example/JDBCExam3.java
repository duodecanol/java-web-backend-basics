package kr.or.connect.jdbc_example;

import kr.or.connect.jdbc_example.dao.RoleDao;
import kr.or.connect.jdbc_example.dto.Role;

public class JDBCExam3 {
	
	public static void main(String[] args) {
		
		int roleId = 201;
		String description = "Head of HR";
				
		RoleDao dao = new RoleDao();
		
		Role role = new Role(roleId, description);
		
		int updateCount = dao.updateRole(role);
		
		System.out.println(updateCount);
	}

}
