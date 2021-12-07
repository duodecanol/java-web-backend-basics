package kr.or.connect.jdbc_example;

import kr.or.connect.jdbc_example.dao.RoleDao;

public class JDBCExam4 {
	
	public static void main(String[] args) {
		int roleId = 500;
						
		RoleDao dao = new RoleDao();
		
		int updateCount = dao.deleteRole(roleId);
		
		System.out.println(updateCount);
	}

}
