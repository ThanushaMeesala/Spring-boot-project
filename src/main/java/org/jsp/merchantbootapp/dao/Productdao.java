package org.jsp.merchantbootapp.dao;

import java.util.List;

import org.jsp.merchantbootapp.dto.Product;
import org.jsp.merchantbootapp.repository.Productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Productdao {
@Autowired
private Productrepository productrepository;

public Product saveproduct(Product product) {
	return productrepository.save(product);
}

public List<Product> findAll(){
	return productrepository.findAll();
}
public List<Product> findByName(String name){
	return productrepository.findByName(name);
}
public List<Product> findByCategory(String category){
	return productrepository.findByCategory(category);
}
public List<Product> findByBrand(String brand){
	return productrepository.findByBrand(brand);
}

public List<Product> findByUserId(int id){
	return productrepository.findByUserId(id);
}
}
