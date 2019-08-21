package com.pizzaria.pedidos.form;

import java.util.Optional;

import com.pizzaria.pedidos.model.Pizza;
import com.pizzaria.pedidos.repository.PizzaRepository;

public class AdicionaisForm {
	
	private boolean extraBacon;
	private boolean semCebola;
	private boolean bordaRecheada;
	
	public boolean isExtraBacon() {
		return extraBacon;
	}

	public boolean isSemCebola() {
		return semCebola;
	}

	public boolean isBordaRecheada() {
		return bordaRecheada;
	}

	public Pizza atualizar(PizzaRepository pizzaRepository, Long id) {
		Pizza pizza = pizzaRepository.getOne(id);
		pizza.setExtraBacon(this.extraBacon);
		pizza.setSemCebola(this.semCebola);
		pizza.setBordaRecheada(this.bordaRecheada);
		
		if(pizza.getExtraBacon()) {
			pizza.setValorDaPizza(pizza.getValorDaPizza() + 3);
			pizza.setExtraBaconValor(3);
		}
		if(pizza.getBordaRecheada()) {
			pizza.setValorDaPizza(pizza.getValorDaPizza()+5);
			pizza.setTempoDePreparo(pizza.getTempoDePreparo() + 5);
			pizza.setBordaRecheadaValor(5);
		}
			
		return pizza;
	}

	public void setExtraBacon(boolean extraBacon) {
		this.extraBacon = extraBacon;
	}

	public void setSemCebola(boolean semCebola) {
		this.semCebola = semCebola;
	}

	public void setBordaRecheada(boolean bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}
	
	

}
