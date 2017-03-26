package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;
  

  @Controller
  public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	
	
	@PostMapping("/manage_category_create")
	public ModelAndView createCategory(@RequestParam("id")String id, 
			@RequestParam("name")String name, @RequestParam("description")String description)
	{
		
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		
		ModelAndView mv = new ModelAndView("redirect:/ManageCategory");
		
		if (categoryDAO.save(category))
		{
			mv.addObject("message", "Successfully created the category");
		}
		else
		{
			mv.addObject("message", "Not able to create Category.  Pl contact Administrator");
		}
		
		return mv;
		
	}
	
	
	
	
	
	
	@GetMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id)
	{
		ModelAndView mv = new ModelAndView("redirect:/ManageCategory");
		
		if(categoryDAO.delete(id))
		{
			mv.addObject("message", "Successfully delete the category");
		}
		else
		{
			mv.addObject("message", "Note able delete the category pl contact administrator");
		}
		return mv;
		
		
	}
	

}
