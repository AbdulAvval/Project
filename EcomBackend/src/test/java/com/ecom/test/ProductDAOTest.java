package com.ecom.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTest 
{
static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		
		
	}
	@Test
	public void addProductTest()
	{
		Product product =new Product();
		
		product.setProductName("Samsung j7");
		product.setProductDesc("The Moblie with 4g and NFC Feature:");
		product.setStock(20);
		product.setPrice(1200);
		product.setCategoryId(1);
		product.setSupplierId(1);
		
		assertTrue("Product in adding the Product",productDAO.addProduct(product));
	}
	@Test
	public void deletProductTest()
	{
		Product product=productDAO.getProduct(2);
		assertTrue("Product in adding the Product",productDAO.deletProduct(product));
	}
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(2);
		product.setPrice(1300);
		product.setStock(10);
		
		assertTrue("Product in adding the Product",productDAO.updateProduct(product));
		
	}
	@Test
	public void listCategoryTest()
	{
		List<Product> listProducts=(List<Product>)productDAO.listProducts();
		assertTrue("Product in Retriving the Product: ",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.println(product.getProductName()+"");
			System.out.println(product.getPrice()+" ");
			System.out.println(product.getStock()+" ");
		}
		
		
	}
}
