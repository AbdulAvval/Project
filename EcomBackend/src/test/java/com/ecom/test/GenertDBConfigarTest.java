package com.ecom.test;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GenertDBConfigarTest 
{
  public static void main(String args[])
  {
	  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	  context.scan("com.ecom");
		context.refresh();
		SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
		
  }
}
