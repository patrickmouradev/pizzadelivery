package com.pizzamoura.delivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzamoura.delivery.dto.OrderDTO;
import com.pizzamoura.delivery.entities.Order;
import com.pizzamoura.delivery.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repositoy;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repositoy.findOrderWithProducts();
		return list.stream().map(x ->new OrderDTO(x)).collect(Collectors.toList());
	}

}
