package com.ecomm.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.model.Cart;

public class CartDAOImpl implements CartDAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public boolean addCartItem(Cart cartItem) 
	{   
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean deleteCartItem(Cart cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateCartItem(Cart cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public Cart getCartItem(int cartItemId) 
	{
		Session session=sessionFactory.openSession();
		Cart cartItem=session.get(Cart.class, cartItemId);
		session.close();
		return cartItem;
	}

	@Override
	public List<Cart> listCartItems(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where username=:uname");
		query.setParameter("uname", username);
		List<Cart> listCartItem=query.list();
		
		return listCartItem;
	}
	
	
	
	
}
