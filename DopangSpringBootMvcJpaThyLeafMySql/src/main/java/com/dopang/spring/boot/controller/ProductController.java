package com.dopang.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dopang.spring.boot.domain.Product;
import com.dopang.spring.boot.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService; 
	
	@RequestMapping("/index")
	public String viewHomePage(Model model) {
		List<Product> listProducts = productService.listAll();
		System.out.println(listProducts.size());
		model.addAttribute("listProducts", listProducts);
		
        return "index";
	}
	
	@RequestMapping("/new")
	public ModelAndView showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		ModelAndView modelView = new ModelAndView("new_product");
        return modelView;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.save(product);
		
		return "redirect:/index";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView modelView = new ModelAndView("edit_product");
		Product product = productService.get(id);
		modelView.addObject("product", product);
		
		return modelView;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		productService.delete(id);

		return "redirect:/index";	
			// revert
	}
}
