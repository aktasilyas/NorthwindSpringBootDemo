package akt.northwindProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import akt.northwindProject.business.abstracts.ProductService;
import akt.northwindProject.core.utilities.results.DataResult;
import akt.northwindProject.core.utilities.results.Result;
import akt.northwindProject.entities.concretes.Product;
import akt.northwindProject.entities.dtos.ProductWithCategoryDto;



@RestController
@RequestMapping("api/products")//bu sekilde bir istek gelirse bu controller karsilayacak
@CrossOrigin
public class ProductsController {
	private ProductService productService;
	@Autowired//otomatik olarak projede ProductService implement eden sinifi bulup new'liyor
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		//@RequestBody:eslestirme islemini yapiyor
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategoryId")
	public 	DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,@RequestParam int categoryId){
		
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo,int pageSize){
		
		return this.productService.getAll(pageNo, pageSize);
		
	}
	@GetMapping("/getAllSortedDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
}
