package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {	
	
	//Com paginação. Pode dar erro em versões antiga do java. Por padrão 'JOIN FETCH' não lida bem com 'Page'
	//JPQL        Alias   Class Entity                junção nas tables (Ver ClassProduct - line 29)
	@Query("SELECT obj FROM Product obj JOIN FETCH obj.categories")
	Page<Product> findProductsCategories(Pageable pageable);
	
	//Sem paginação
	//JPQL        Alias   Class Entity                junção nas tables (Ver ClassProduct - line 29)
	@Query("SELECT obj FROM Product obj JOIN FETCH obj.categories")
	List<Product> findProductsCategories1();
	
	
	//Com paginação
	//JPQL        Alias   Class Entity                junção nas tables (Ver ClassProduct - line 29)
	@Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj IN :products")
	List<Product> findProductsCategories2(List<Product> products);

}
