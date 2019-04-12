package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	@RequestMapping("/category")
	public String showCatgory(Model m)
	{
		List<Category>listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
	return "category";			
	}
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc, Model m)
	{ 
		 Category category=new Category();
		 category.setCategoryName(categoryName);
		 category.setCategoryDesc(categoryDesc);
		 
		 categoryDAO.addCategory(category);
		List<Category>listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
		return "Category";
	}
}
