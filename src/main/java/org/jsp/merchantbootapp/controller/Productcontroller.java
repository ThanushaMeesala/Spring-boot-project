package org.jsp.merchantbootapp.controller;

import java.util.List;

import org.jsp.merchantbootapp.Service.Productservice;
import org.jsp.merchantbootapp.dto.Product;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/product")
public class Productcontroller {
  @Autowired
  private Productservice productservice;
 
  
  @PostMapping("/user_id")
  public ResponseEntity<ResponseStructure<Product>> save(@RequestBody Product product,@PathVariable(name="user_id") int user_id){
  return productservice.saveproduct(product, user_id);
  }
  
  @GetMapping
  public ResponseEntity<ResponseStructure<List<Product>>> findAll(){
	  return productservice.findAll();
  }
  
  @GetMapping("/find-by-brand/{brand}")
  public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(@PathVariable(name="brand") String brand){
	  return productservice.findByBrand(brand);
  }
  
  @GetMapping("/find-by-category/{category}")
  public ResponseEntity<ResponseStructure<List<Product>>> findByCategory(@PathVariable(name="category")String category){
	  return productservice.findByCategory(category);
  }
  
  @GetMapping("/find-by-name/{name}")
  public ResponseEntity<ResponseStructure<List<Product>>> findByName(@PathVariable(name="name") String name){
	  return productservice.findByName(name);
  }
  
  @GetMapping("/user_id")
  public ResponseEntity<ResponseStructure<List<Product>>> findByUserid(@PathVariable(name="user_id") int id){
	  return productservice.findByUserId(id);
			  
  }
}
