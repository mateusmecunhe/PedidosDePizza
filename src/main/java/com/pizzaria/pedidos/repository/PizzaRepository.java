package com.pizzaria.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaria.pedidos.model.Pizza;


public interface PizzaRepository extends JpaRepository<Pizza, Long>{

}
