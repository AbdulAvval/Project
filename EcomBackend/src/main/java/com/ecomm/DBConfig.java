package com.ecomm;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.model.Cart;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm")

public class DBConfig
{
	@Bean
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSourse=new DriverManagerDataSource();
		dataSourse.setDriverClassName("org.h2.Driver");
		dataSourse.setUrl("jdbc:h2:tcp://localhost/~/test1");
		dataSourse.setUsername("sa");
		dataSourse.setPassword("");
		
		System.out.println("==DataSourse obj Created==");
		return dataSourse;
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbm2dd1.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factory =new LocalSessionFactoryBuilder(getH2DataSource());
		
		factory.addProperties(hibernateProp);
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Cart.class);
		
		
		SessionFactory sessionFactory=factory.buildSessionFactory();
		
		System.out.println("===SessionFactory obj Created===");
		return sessionFactory;
	}
	@Bean("texManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("===Hibernat Transaction Manager===");
		return new HibernateTransactionManager(sessionFactory);
	}
}
