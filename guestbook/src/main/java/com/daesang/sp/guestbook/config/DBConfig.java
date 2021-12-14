package com.daesang.sp.guestbook.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement // 트랜잭션 관련된 설정을 자동으로 해준다. 
@PropertySource("classpath:/env.properties")
public class DBConfig implements TransactionManagementConfigurer {
	
	// 단, 사용자 간의 트랜잭션 처리를 위한 PlatformTransactionManager를 설정하기 위해서는 TransactionManagementConfigure를 구현해야함. 
	
	
	@Value("${DRIVER_CLASS_NAME}")
	private String driverClassName;
	
	@Value("${URL}")
	private String url;
	
	@Value("${USER_NAME}")
	private String username;
	
	@Value("${PASSWORD}")
	private String password;
	
	@Bean
	public DataSource dataSource() { // DB 사용을 위한 데이터소스 생성
		System.out.println(this.driverClassName);
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		// annotationDrivenTransactionManager 이 함수를 오버라이딩해야함.
		// PlatformTransactionnManager객체를 반환하게 하면 됨.
		return transactionManager();
	}
}
