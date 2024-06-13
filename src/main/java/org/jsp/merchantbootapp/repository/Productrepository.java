package org.jsp.merchantbootapp.repository;

import java.util.List;

import org.jsp.merchantbootapp.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Productrepository extends JpaRepository<Product,Integer>{
List<Product> findByName(String name);
List<Product> findByBrand(String brand);
List<Product> findByCategory(String category);
@Query("select p from product p where p.merchant.id=?1")
List<Product> findByUserId(int user_id);
}
