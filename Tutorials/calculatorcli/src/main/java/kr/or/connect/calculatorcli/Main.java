package kr.or.connect.calculatorcli;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		// ApplicationConfig.class 설정파일을 읽어들이는 ApplicationContext 객체를 생성합니다.
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		
		// ApplicationContext가 관리하는 CalculatorService.class 타입의 객체를 요청합니다
		CalculatorService calculatorService = applicationContext.getBean(CalculatorService.class);
		
		System.out.println(calculatorService.plus(6, 34));
		
		((ConfigurableApplicationContext)applicationContext).close();
	}
}
