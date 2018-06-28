package main.java.hibernate.samples.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import main.java.com.mkyong.user.DBUser;

@Configuration
public class DbHibernateConfig {
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/db_test?autoReconnect=true&useSSL=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		Properties props= new Properties();
		props.setProperty("hibernate.show_sql", "true");
		
		
//		auto strategies 1) Create- Always DROP and CREATE TABELE
//						2) Validate - Validate your java model aganist Database TABLE
//						3) UPDATE  - UPDATE TABELs
		props.setProperty("hibernate.hbm2ddl.auto", "create");
//		If different database uses different dialect needs to GOOGLE
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		props.setProperty("hibernate.default_schema", dataSourceDefaultSchema);
		sessionFactory.setAnnotatedClasses(DBUser.class);
		sessionFactory.setHibernateProperties(props);
		return sessionFactory;
		
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}
