package akt.northwindProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import akt.northwindProject.entities.concretes.Product;
import akt.northwindProject.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {

	//jpa bizim icin crud islemlerini yapti
	
	Product getByProductName(String productName);
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	//getBy ile baslamasi onemli bizim icin productName ve categoryId yi and kosulu ile getirir
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> GetByNameAndCategory(String productName,int categoryId);
	
	@Query("Select new akt.northwindProject.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	//select p.productId,p.productName,c.categoryName from Category c inner join Product p  on c.categoryId=p.categoryId
}
