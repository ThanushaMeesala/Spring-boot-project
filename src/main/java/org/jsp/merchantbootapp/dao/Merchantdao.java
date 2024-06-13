package org.jsp.merchantbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.repository.Merchantrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Merchantdao {
@Autowired
private Merchantrepository merchantrepository;

public Merchant saveMerchant(Merchant merchant) {
	return merchantrepository.save(merchant);
}

public List<Merchant> findAll(){
	return merchantrepository.findAll();
}
public Optional<Merchant> findById(int id){
	return merchantrepository.findById(id);
}
public List<Merchant> findByName(String name){
	return merchantrepository.findByName(name);
}
public Optional<Merchant> findByPhone(long phone){
	return merchantrepository.findByPhone(phone);
}

public Optional<Merchant> findByPhoneByPassword(long phone,String password){
	return merchantrepository.findByPhoneAndPassword(phone, password);
}
public void deleteMerchant(int id) {
	merchantrepository.deleteById(id);
}
}
