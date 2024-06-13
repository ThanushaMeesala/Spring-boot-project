package org.jsp.merchantbootapp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Merchantrepository extends JpaRepository<Merchant,Integer>{
List<Merchant> findByName(String name);
Optional<Merchant> findByPhone(long phone);
Optional<Merchant> findByPhoneAndPassword(long phone,String password);
}
