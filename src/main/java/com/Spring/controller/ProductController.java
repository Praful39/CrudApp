package com.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Spring.model.Category;
import com.Spring.model.Product;
import com.Spring.repository.CategoryRepository;
import com.Spring.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping("/products/new")
	public String showNewProductForm(Model model) {
		List<Category> listCategories = categoryRepo.findAll();
		model.addAttribute("product", new Product());
		model.addAttribute("listCategories",listCategories);
		return "product_form";
	}
	
	@PostMapping("/products/save")
	public String saveProduct(Product product) {
		productRepo.save(product);
		
		return "redirect:/products";
	}

	@GetMapping("/products")
	public String listProducts (Model model) {
	List<Product> listProducts = productRepo.findAll();
	model.addAttribute("listProducts",listProducts);
	return "products";
	}
	
	@GetMapping("/products/edit/{id}")
	public String showEditProductForm(@PathVariable("id") int id, Model model) {
		Product product = productRepo.findById(id).get();
		model.addAttribute("product", product);
		return "product_form";
	}
	
	@GetMapping("/products/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id, Model model) {
		productRepo.deleteById(id);
		return "redirect:/products";
		
	}
}