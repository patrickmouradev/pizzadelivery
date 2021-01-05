package com.pizzamoura.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzamoura.delivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
