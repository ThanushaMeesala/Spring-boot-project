package org.jsp.merchantbootapp.controller;

import java.util.List;

import org.jsp.merchantbootapp.Service.Merchantservice;
import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/merchant")
public class Merchantcontroller {
 @Autowired
 private Merchantservice merchantservice;
 
 @PostMapping
 @ResponseStatus(code=HttpStatus.CREATED)
 public ResponseStructure<Merchant> save(@RequestBody Merchant merchant){
	 return merchantservice.saveMerchant(merchant);
 }
 @PutMapping
 public ResponseEntity<ResponseStructure<Merchant>> update(@RequestBody Merchant merchant){
	 return merchantservice.update(merchant);
 }
 
 @DeleteMapping(value="/{id}")
 public ResponseEntity<ResponseStructure<String>> delete(@PathVariable(name="id") int id){
	 return merchantservice.deleteById(id);
 }
 
 @GetMapping
 public ResponseEntity<ResponseStructure<List<Merchant>>> findall(){
	 return merchantservice.findAll();
 }
 
 @GetMapping(value="/{id}")
 public ResponseEntity<ResponseStructure<Merchant>> findById(@PathVariable(name="id")int id){
	 return merchantservice.findById(id);
 }
 
 @GetMapping(value="/find-by-name/{name}")
 public ResponseEntity<ResponseStructure<List<Merchant>>> findByName(@PathVariable(name="name")String name){
	 return merchantservice.findByName(name);
 }
 
 @GetMapping(value="/find-by-phone/{phone}")
 public ResponseEntity<ResponseStructure<Merchant>> findByPhone(@PathVariable(name="phone") long phone){
	 return merchantservice.findByPhone(phone);
 }
 
 @GetMapping(value="/verify")
 public ResponseEntity<ResponseStructure<Merchant>> findByPhoneAndPassword(@RequestParam(name="phone") long phone,
		 @RequestParam(name="password")String password){
	 return merchantservice.verify(phone, password);
 }
}
