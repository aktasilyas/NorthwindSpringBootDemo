package akt.northwindProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import akt.northwindProject.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
