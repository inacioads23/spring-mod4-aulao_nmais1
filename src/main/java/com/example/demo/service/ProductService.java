package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> find(PageRequest pageRequest) {
		Page<Product> list = repository.findAll(pageRequest);
		return list.map(x -> new ProductDTO(x));
	}
		
	@Transactional(readOnly = true)
	public List<ProductDTO> find1(PageRequest pageRequest) {
		List<Product> list = repository.findProductsCategories1();
		// converter para DTO
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> find2(PageRequest pageRequest) {
		Page<Product> list = repository.findAll(pageRequest);
		// forço JPA fazer a query e subir/ instanciar na memória. Ficando disponível para acesso do Dto, sem necessidade de ir no DB
		repository.findProductsCategories2(list.stream().collect(Collectors.toList()));
		return list.map(x -> new ProductDTO(x));
	}
}
