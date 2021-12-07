package kr.or.connect.jdbc_example;

import kr.or.connect.jdbc_example.dao.RoleDao;
import kr.or.connect.jdbc_example.dto.Role;

public class JDBCExam1 {
	
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}

}
