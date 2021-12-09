package kr.or.connect.daoexample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "kr.or.connect.daoexample.dao" })
@Import({ DBConfig.class }) // 하나의 클래스가 모든 정보를 갖고 있는 것이 아니라 컴포넌트별로 분리해서
public class ApplicationConfig {

}
