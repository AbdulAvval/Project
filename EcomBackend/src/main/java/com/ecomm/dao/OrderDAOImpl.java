package com.ecomm.dao;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.OrderDetail;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean paymentProcess(OrderDetail order) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(order);
			return true;
		}
		catch(Exception e)
		{
		return false;
		
		}
	}

	public boolean updateCartItemStatus(String username,int orderId)
	{
		try 
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("update Cart set status='P',orderId=:orderId where username=:uname and status='NP'");
			
				query.setParameter("orderId", orderId);
			    query.setParameter("uname", username);
				
			    int row_eff=query.executeUpdate();
			    
			    if(row_eff>0)
			    	return true;
			    else
			    	return true;
			    
			    	
		}
		catch(Exception e)
		{
			
		return false;
		
		}
	}

	
	
}
