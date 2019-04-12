package com.ecom.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest
{
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		
	}
	@Test 
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("SamsungMobil");
		category.setCategoryDesc("Alll Smart Mobile of Samsung Brand");
		assertTure("Proble in Adding Category",categoryDAO.addCategory(category));
		
	}
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in Deleting the Category",categoryDAO.deletCategory(category));
		
	}
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		category.setCategoryDesc("All Smart Mobile and other gadget from Xiome:");
		assertTrue("Problem in Update the Category",categoryDAO.updateCategory(category));
	}
	@Test
	public void retriveCategories()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		assertTrue("Problem in Retrieving the Category ",listCategories.size()>0);
	for(Category category:listCategories)
	{
		System.out.println(category.getCategoryId()+" ");
		System.out.println(category.getCategoryName()+" ");
		System.out.println(category.getCategoryDesc());
	}
		
	}
	private void assertTure(String string, boolean addCategory) {
		// TODO Auto-generated method stub
		
	}
	
}
