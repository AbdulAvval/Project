package com.ecomm.dao;

import com.ecomm.model.OrderDetail;

public interface OrderDAO 
{

	public boolean paymentProcess(OrderDetail order);
	public boolean updateCartItemStatus(String username ,int orderId );
	
	
}
