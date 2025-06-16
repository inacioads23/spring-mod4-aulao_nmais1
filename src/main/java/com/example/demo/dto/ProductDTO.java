package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.Product;

public class ProductDTO {

	private Long id;
	private String name;
	
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductDTO() {
	}
	
	// Copia da entity - Converte Entity para DTO
	public ProductDTO(Product product) {
		id = product.getId();
		name = product.getName();
		categories = product.getCategories()
				.stream().map(x -> new CategoryDTO(x)) // cada elemento 'x' vou converter para um 'CategoryDTO'
				.collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}
}
