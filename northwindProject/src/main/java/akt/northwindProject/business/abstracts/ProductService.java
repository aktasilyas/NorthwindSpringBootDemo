package akt.northwindProject.business.abstracts;

import java.util.List;


import akt.northwindProject.core.utilities.results.DataResult;
import akt.northwindProject.core.utilities.results.Result;
import akt.northwindProject.entities.concretes.Product;
import akt.northwindProject.entities.dtos.ProductWithCategoryDto;

public interface ProductService {

	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAll(int pageNo,int pageSize);
	DataResult<List<Product>> getAllSorted();
	
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);
	DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> GetByNameAndCategory(String productName,int categoryId);
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
	
	
}
