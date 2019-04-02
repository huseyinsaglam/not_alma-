package com.example.demo;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class Connection {
	
	private ComboPooledDataSource connection() throws PropertyVetoException
	{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/notalma2.schema?serverTimezone=UTC");
		cpds.setUser("root");
		cpds.setPassword("123456");
		return cpds;
	}
	
	public SessionFactory sessionFactory() throws PropertyVetoException
	{
		LocalSessionFactoryBean sessionfactory = new LocalSessionFactoryBean();
		sessionfactory.setDataSource(connection());
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		
		
		sessionfactory.setHibernateProperties(properties);
		sessionfactory.setPackagesToScan("com.example.demo.entity");
		return (SessionFactory) sessionfactory;
	}

}
