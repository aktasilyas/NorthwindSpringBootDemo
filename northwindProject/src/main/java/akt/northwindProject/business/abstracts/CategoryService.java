package akt.northwindProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import akt.northwindProject.entities.concretes.Category;


public interface CategoryService {

	 List<Category> getAll();
}
