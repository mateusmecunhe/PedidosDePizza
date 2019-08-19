package com.pizzaria.pedidos.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pizzaria.pedidos.model.Pizza;
import com.pizzaria.pedidos.repository.PizzaRepository;

@RestController("/pizza")
public class PizzaController {
	
	@Autowired
	PizzaRepository pizzaRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pizza>> detalhaPedido(@PathVariable Long id) {
		Optional<Pizza> pizza = pizzaRepository.findById(id);
		if(pizza.isPresent()) {
			return ResponseEntity.ok(pizza);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Pizza> cadastraPizza(@RequestBody Pizza pizza, UriComponentsBuilder builder){
		pizzaRepository.save(pizza);
		URI uri = builder.path("/pedidos/{id}").buildAndExpand(pizza.getId()).toUri();
		return ResponseEntity.created(uri).body(pizza);
		
	}

}