package com.ecomm.dao;

import java.util.*;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{	
	@Autowired
	SessionFactory sessionFactory;
	public boolean addCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		}
		catch(Exception e )
		{
			return false;	
		}
		
	}

	public boolean deletCategory(Category category)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e )
		{
			return false;	
		}
		
	}

	public boolean updateCategory(Category category)
	{try
	{
		sessionFactory.getCurrentSession().update(category);
		return true;
	}
	catch(Exception e )
	{
		return false;	
	}
	
	}

	public List<Category> listCategories() 
	{
		
	/*
		  Session session =sessionFactory.openSession(); Query query
		 session.createQuery("from Category"); List<Category>
		  listCategories=query.list(); session.close();
		*/ 
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category getCategory(int categoryId)
	{
		 Session session =sessionFactory.openSession();
		 Category category=(Category)session.get(Category.class,categoryId);
		 session.close();
		 return category;
	}
	
}
