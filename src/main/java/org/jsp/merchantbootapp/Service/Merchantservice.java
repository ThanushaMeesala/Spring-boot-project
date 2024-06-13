package org.jsp.merchantbootapp.Service;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.Exception.MerchantNotFountException;
import org.jsp.merchantbootapp.dao.Merchantdao;
import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Merchantservice {
@Autowired
private Merchantdao merchantdao;

public ResponseStructure<Merchant> saveMerchant(Merchant merchant){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	structure.setData(merchantdao.saveMerchant(merchant));
	structure.setMessage("merchnat found");
	structure.setStatuscode(HttpStatus.CREATED.value());
	return structure;
}

public ResponseEntity<ResponseStructure<List<Merchant>>> findAll(){
	ResponseStructure<List<Merchant>> structure=new ResponseStructure<>();
	structure.setData(merchantdao.findAll());
	structure.setMessage("Merchants Found");
	structure.setStatuscode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<List<Merchant>>>(structure,HttpStatus.OK);
}

public ResponseEntity<ResponseStructure<Merchant>> findById(int id){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	Optional<Merchant> recmerchant=merchantdao.findById(id);
	if(recmerchant.isPresent()) {
		structure.setData(recmerchant.get());
		structure.setMessage("merchant found");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
	}
	throw new MerchantNotFountException("invalid id");
}

public ResponseEntity<ResponseStructure<Merchant>> update(Merchant merchant){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	Optional<Merchant> recmer=merchantdao.findById(merchant.getId());
	if(recmer.isPresent()) {
		Merchant dbmer=recmer.get();
		dbmer.setName(merchant.getName());
		dbmer.setPhone(merchant.getPhone());
		dbmer.setEmail(merchant.getEmail());
		dbmer.setPassword(merchant.getPassword());
		structure.setData(merchantdao.saveMerchant(merchant));
		structure.setMessage("user updated");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
	}
	structure.setData(null);
	structure.setMessage("cannot update user invalid id");
	structure.setStatuscode(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.NOT_FOUND);
}

public ResponseEntity<ResponseStructure<List<Merchant>>> findByName(String name){
	ResponseStructure<List<Merchant>> structure=new ResponseStructure<>();
	List<Merchant> recmer=merchantdao.findByName(name);
	structure.setData(recmer);
	if(recmer.size()>0) {
		structure.setMessage("name found");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Merchant>>>(structure,HttpStatus.OK);
	}
	throw new MerchantNotFountException("invalid name");
}

public ResponseEntity<ResponseStructure<Merchant>> findByPhone(long phone){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	Optional<Merchant> recmer=merchantdao.findByPhone(phone);
	if(recmer.isPresent()) {
		structure.setData(recmer.get());
		structure.setMessage("Merchant found");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
	}
	throw new MerchantNotFountException("invalid phone");
}

public ResponseEntity<ResponseStructure<Merchant>> findByPhoneAndPassword(long phone,String password){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	Optional<Merchant> recmer=merchantdao.findByPhoneByPassword(phone, password);
	if(recmer.isPresent()) {
		structure.setData(recmer.get());
		structure.setMessage("merchant found");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
	}
	throw new MerchantNotFountException("invalid phone and password");
}

public ResponseEntity<ResponseStructure<Merchant>> verify(long phone,String password){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	Optional<Merchant> recmer=merchantdao.findByPhoneByPassword(phone, password);
	if(recmer.isPresent()) {
		structure.setData(recmer.get());
		structure.setMessage("merchant found");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
	}
	throw new MerchantNotFountException("invalid phone or password");
}

public ResponseEntity<ResponseStructure<String>> deleteById(int id){
	ResponseStructure<String> structure=new ResponseStructure<>();
	Optional<Merchant> recmer=merchantdao.findById(id);
	if(recmer.isEmpty()) {
		structure.setData("merchant found");
		structure.setMessage("Merchant deleted");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
	}
	structure.setData("merchant not found");
	structure.setMessage("invaild id");
	structure.setStatuscode(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
}
}
