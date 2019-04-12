package com.ecomm.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Product;

@Repository("productDAP")
@Transactional

public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product );
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

	public boolean deletProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

	public boolean updateProduct(Product product) 
	{
		try
	{
		sessionFactory.getCurrentSession().update(product);
		return true;
	}
	catch(Exception e)
	{
		return false;	
	}
	
	}

	public Product getProduct(int productId)
	{
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class,productId);
		session.close();
		
		return product;
	}

	public List<Product> listProducts() 
	{
		/*
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProducts=query.list();
		session.close(); */
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public List<Product> listProductByCategory(int categoryId) 
	{ 
		/*
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where categoryId=:categoryid");
		query.setParameter("categoryid", categoryId);
		List<Product> listProducts=query.list();
		session.close(); */
		
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
	
}
