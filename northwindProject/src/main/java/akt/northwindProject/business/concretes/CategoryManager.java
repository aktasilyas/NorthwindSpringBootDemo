package akt.northwindProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akt.northwindProject.business.abstracts.CategoryService;
import akt.northwindProject.dataAccess.abstracts.CategoryDao;
import akt.northwindProject.entities.concretes.Category;

@Service
public class CategoryManager  implements CategoryService{
	
	private CategoryDao categoryDao;
	
	@Autowired
	 public CategoryManager(CategoryDao categoryDao) {
		
		this.categoryDao=categoryDao;
	}

	@Override
	public List<Category> getAll() {
		
		return this.categoryDao.findAll();
	}

	
}
