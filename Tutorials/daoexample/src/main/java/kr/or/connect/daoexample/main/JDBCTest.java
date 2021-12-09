package kr.or.connect.daoexample.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexample.config.ApplicationConfig;
import kr.or.connect.daoexample.dao.RoleDao;
import kr.or.connect.daoexample.dto.Role;

public class JDBCTest {
	
	private ApplicationContext ac;
	private RoleDao roleDao;
	
	public JDBCTest() {
		this.ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		this.roleDao = this.ac.getBean(RoleDao.class);
	}

	public static void main(String[] args) {
		JDBCTest test = new JDBCTest();
		
//		test.insertTest();
//		test.updateTest();
//		test.selectByIdTest();
		test.deleteByIdTest();
		
	}
	
	public void insertTest() {
		Role role = new Role();
		role.setRoleId(600);
		role.setDescription("Programmer");
		
		int count = roleDao.insert(role);
		System.out.println(count + " 건 입력하였습니다.");
	}
	
	public void updateTest() {		
		Role role = new Role();
		role.setRoleId(600);
		role.setDescription("Burglar");
		
		int count = roleDao.update(role);
		System.out.println(count + " 건 수정하였습니다.");
		
	}
	
	public void selectByIdTest() {
		Role result = roleDao.selectById(201);
		System.out.println(result.toString());
	}
	
	public void deleteByIdTest() {
		int delCount = roleDao.deleteById(600);
		System.out.println(delCount + " 건 삭제하였습니다.");
	}
}
