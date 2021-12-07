package kr.or.connect.jdbc_example;

import java.util.List;

import kr.or.connect.jdbc_example.dao.RoleDao;
import kr.or.connect.jdbc_example.dto.Role;

public class JDBCExam5 {
	
	public static void main(String[] args) {
		
		RoleDao dao = new RoleDao();
		List<Role> roles = dao.getRoles();
		
		for (Role role : roles) {
			System.out.println(role);
		}
	}

}
