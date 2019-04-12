package com.ecom.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ecomm.dao.OrderDAO;
import com.ecomm.model.OrderDetail;

public class OrderDAOTest
{

	
	 static OrderDAO orderDAO;
	 
	 @BeforeClass
	 public static void initialize()
	 {
		AnnotationCanfigApplicationCantext context=new AnnotationConfigApplicataionContext ();
		context.scon("con.ecomm");
		context.refresh();
		
		orderDAO=(OrderDAO)context.getBean("orderDAO");
		 
	 }
	 @Test
	 public void paymentProcessTest()
	 {
		 OrderDetail orderDetail=new OrderDetail();
		 orderDetail.setUsername("AbdulAvval");
		 orderDetail.setTotalShoppingAmount(67000);
		 orderDetail.setOrderDate(new java.util.Date());
		 orderDetail.setPaymentMode("COD");
	 }
	 
	
	
}
