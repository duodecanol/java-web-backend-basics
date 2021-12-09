package kr.or.connect.daoexample.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexample.config.ApplicationConfig;
import kr.or.connect.daoexample.dao.RoleDao;
import kr.or.connect.daoexample.dto.Role;

public class SelectAllTest {
	
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);

		List<Role> list = roleDao.selectAll();
		
		for (Role role : list) {
			System.out.println(role);
		}
		
		((ConfigurableApplicationContext)ac).close();
	}
}
