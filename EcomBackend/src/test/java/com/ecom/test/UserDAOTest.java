package com.ecom.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;

public class UserDAOTest
{


 static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Ignore
	@Test
	public void registerUserTest()
	{
	 UserDetail user =new UserDetail();
	 user.setUsername("Mohit");
	user.setPassword("pass123");
	user.setCustomerName("Mohit Khan");
	user.setEnable(true);
	user.setRole("ROLE_USER");
	user.setAddress("UtterPardesh");
	assertTrue("Problem in adding the User:",userDAO.registerUser(user));
	
	}
	@Test 
	public void updateTest()
	{
		UserDetail user =userDAO.getUser("Mohit");
		user.setPassword("pass132");
		assertTrue("Problem in adding the User:",userDAO.updateUser(user));
			
	}	
}




