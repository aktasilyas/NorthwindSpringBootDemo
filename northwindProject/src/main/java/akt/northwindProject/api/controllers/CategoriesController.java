package akt.northwindProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import akt.northwindProject.business.abstracts.CategoryService;
import akt.northwindProject.entities.concretes.Category;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {

	private CategoryService categoryService;
	
	@Autowired
	public CategoriesController(CategoryService categoryService) {
		
		this.categoryService=categoryService;
	}
	
	@GetMapping("/getall")
	public List<Category> getAll(){
		return categoryService.getAll();
	}
}
