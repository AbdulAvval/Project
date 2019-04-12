package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/product")
	public String showProduct(Model m)
	{
		Product product=new Product();
		m.addAttribute("product", product);
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
		return "Product";
	}
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile filedet,Model m)
	{
		productDAO.addProduct(product);
		
		int productId=product.getProductId();
		String path="C:\\Users\\Admin\\eclipse-workspace\\EcomFrantent\\src\\main\\resources\\image";
		
		path=path+String.valueOf(productId)+".jpg";
		File myImageFile=new File(path);
		if (!filedet.isEmpty())
		{
			try 
			{
				byte buff[]=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(myImageFile);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buff);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("Error", "Error Occured durig Image Uploading::"+e.getMessage());
			}
		}
		else
		{
			System.out.println("Error Occured While Uploading File");
			m.addAttribute("Error", "Error Occured during Image Uploading");
		}
		
		Product product1=new Product();
		m.addAttribute("product", product1);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		return "Product";
	}
	@RequestMapping(value = "/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product1=productDAO.getProduct(productId);
		productDAO.deletProduct(product1);
		Product product2=new Product();
		m.addAttribute("product", product2);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		return "Product";
	}
	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product1=productDAO.getProduct(productId);
		m.addAttribute("product", product1);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		m.addAttribute("categoryList", this.getCategoryList(categoryDAO.listCategories()));
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> listCategory)
	{
		LinkedHashMap<Integer,String> listCategories=new LinkedHashMap<Integer,String>();
		for(Category category:listCategory)
		{
			listCategories.put(category.getCategoryId(),category.getCategoryName());
			
		}
		System.out.println(listCategories);
		return listCategories;
	}
	@RequestMapping(value="/productDisplay")
	public String displayProduct(Model m)
	{
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		
		return "ProductDisplay";
	}
	@RequestMapping(value="totalProductDisplay/{productId}")
	public String totalProductDisplay(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		m.addAttribute("product", product);
		return "productId";
	}
}
