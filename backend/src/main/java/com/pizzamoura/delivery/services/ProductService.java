package com.pizzamoura.delivery.services;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzamoura.delivery.dto.ProductDTO;
import com.pizzamoura.delivery.entities.Product;
import com.pizzamoura.delivery.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repositoy;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> list = repositoy.findAllByOrderByNameAsc();
		return list.stream().map(x ->new ProductDTO(x)).collect(Collectors.toList());
	}

}
