package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	
	@GetMapping()
	public ResponseEntity<Page<ProductDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size
			) {
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<ProductDTO> list = service.find(pageRequest);
		return ResponseEntity.ok(list);
	}
	
	
	// Sem paginação - Pode dar erro em versões antiga do java
	@GetMapping("/find1")
	public ResponseEntity<List<ProductDTO>> findAll1(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size
			) {
		
		PageRequest pageRequest = PageRequest.of(page, size);
		List<ProductDTO> list = service.find1(pageRequest);
		return ResponseEntity.ok(list);
	}
	
	// Com paginação
	@GetMapping("/find2")
	public ResponseEntity<Page<ProductDTO>> findAll2(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size
			) {
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<ProductDTO> list = service.find2(pageRequest);
		return ResponseEntity.ok(list);
	}
}
