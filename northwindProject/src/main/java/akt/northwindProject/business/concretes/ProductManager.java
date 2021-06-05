package akt.northwindProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import akt.northwindProject.business.abstracts.ProductService;
import akt.northwindProject.core.utilities.results.DataResult;
import akt.northwindProject.core.utilities.results.Result;
import akt.northwindProject.core.utilities.results.SuccessDataResult;
import akt.northwindProject.core.utilities.results.SuccessResult;
import akt.northwindProject.dataAccess.abstracts.ProductDao;
import akt.northwindProject.entities.concretes.Product;
import akt.northwindProject.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");
				
				
	}
	@Override
	public Result add(Product product) {
		
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi");
	}
	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data Listelendi");
		
	}
	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),"Data Listelendi");

	}
	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data Listelendi");

	}
	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");

	}
	@Override
	public DataResult<List<Product>> GetByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.GetByNameAndCategory(productName,categoryId),"Data Listelendi");

	}
	@Override
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable= PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}
	@Override
	public DataResult<List<Product>> getAllSorted() {
		
		Sort sort=Sort.by(Sort.Direction.DESC,"productName");
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"basarili");
	}
	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"Data Listelendi");
		
		
	}

}
