package org.jsp.merchantbootapp.Service;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.Exception.MerchantNotFountException;
import org.jsp.merchantbootapp.Exception.ProductNotFoundException;
import org.jsp.merchantbootapp.dao.Merchantdao;
import org.jsp.merchantbootapp.dao.Productdao;
import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.Product;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Productservice {
@Autowired
private Productdao productdao;
@Autowired
private Merchantdao merchantdao;

public ResponseEntity<ResponseStructure<Product>> saveproduct(Product product,int merchant_id){
	ResponseStructure<Product> structure=new ResponseStructure<>();
	Optional<Merchant> recmer=merchantdao.findById(merchant_id);
	if(recmer.isPresent()) {
		Merchant dbmer=recmer.get();
		dbmer.getProducts().add(product);
		product.setMerchant(dbmer);
		structure.setData(productdao.saveproduct(product));
		structure.setMessage("Product added");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
	}
	throw new MerchantNotFountException("Invalid User Id");

	}

public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(String brand){
	ResponseStructure<List<Product>> structure=new ResponseStructure<>();
	List<Product> products=productdao.findByBrand(brand);
	if(products.isEmpty()) {
		throw new ProductNotFoundException("brand is not present");
	}
	structure.setData(products);
	structure.setMessage("List of Products for entered brand");
	structure.setStatuscode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<List<Product>>>(HttpStatus.OK);
}

public ResponseEntity<ResponseStructure<List<Product>>> findByCategory(String category){
	ResponseStructure<List<Product>> structure=new ResponseStructure<>();
	List<Product> products=productdao.findByBrand(category);
	if(products.isEmpty()) {
		throw new ProductNotFoundException("category is not present");
	}
	structure.setData(products);
	structure.setMessage("Category Found");
	structure.setStatuscode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
}

public ResponseEntity<ResponseStructure<List<Product>>> findByName(String name){
	ResponseStructure<List<Product>> structure=new ResponseStructure<>();
	List<Product> products=productdao.findByName(name);
	if(products.isEmpty()) {
		throw new ProductNotFoundException("name is not present");
	}
	structure.setData(products);
	structure.setMessage(name);
	structure.setStatuscode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
}

public ResponseEntity<ResponseStructure<List<Product>>> findByUserId(int user_id){
	ResponseStructure<List<Product>> structure=new ResponseStructure<>();
	List<Product> products=productdao.findByUserId(user_id);
	if(products.isEmpty()) {
		throw new ProductNotFoundException("user id is not found");
	}
	structure.setData(products);
	structure.setMessage("user id not found");
	structure.setStatuscode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
}

public ResponseEntity<ResponseStructure<List<Product>>> findAll(){
	List<Product> products=productdao.findAll();
	ResponseStructure<List<Product>> structure=new ResponseStructure<>();
	structure.setData(products);
	structure.setMessage("All the Products are ");
	structure.setStatuscode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
}
}
