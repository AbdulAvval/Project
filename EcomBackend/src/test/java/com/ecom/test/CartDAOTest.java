package com.ecom.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ecomm.dao.CartDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.OrderDetail;

public class CartDAOTest 
{
 static CartDAO cartDAO;
 
 @BeforeClass
 public static void initialize()
 {
	AnnotationCanfigApplicationCantext context=new AnnotationConfigApplicataionContext ();
	context.scon("con.ecomm");
	context.refresh();
	
	cartDAO=(CartDAO)context.getBean("cartDAO");
	 
 }
 @Test
 public void addCartITest()
 {
	 Cart cartItem=new Cart();
	 cartItem.setProductId(11);
	 cartItem.setProductName("Lenovo");
	 cartItem.setQuantity(2);
	 cartItem.setStatus("NP");
	 cartItem.setUsername("AbdulAvval");
	 cartItem.setPrice(1200);
	 
	 assertTrue("Problem in Adding Item to Cart ",cartDAO.addCartItem(cartItem));
	 
 }
 @Test 
 public void updateCartItemTest()
 {
	 Cart cartItem=cartDAO.getCartItem(17);
	 cartItem.setQuantity(5);
	 assertTrue("Problem in Updating Item of the Cart",cartDAO.updateCartItem(cartItem));

 }
 @Test
 public void deleteCartItemTest()
 {
	 Cart cartItem=cartDAO.getCartItem(18);
	 assertTrue("Problem in Deleting the CartItem",cartDAO.deleteCartItem(cartItem));
	 
 }
 
 
 @Test 
 public void displayCartItemsTest()
 {
	 
	 List<Cart> listCartItems=cartDAO.listCartItems("AbdulAvval");
	 assertTrue("Problem in Retrieving the CartItem:",listCartItems.size()>0);

	 for(Cart cartItem:listCartItems)
	 {
		 System.out.println(cartItem.getCartItemId()+"");
		 System.out.println(cartItem.getProductName()+"");
		 System.out.println(cartItem.getQuantity());
	 }
 
 }

}
