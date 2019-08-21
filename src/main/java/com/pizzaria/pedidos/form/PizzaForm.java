package com.pizzaria.pedidos.form;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.pizzaria.pedidos.model.Pizza;
import com.pizzaria.pedidos.model.SaborPizza;
import com.pizzaria.pedidos.model.TamanhoPizza;

public class PizzaForm {
	
	@Enumerated(EnumType.STRING)
	private SaborPizza sabor;
	@Enumerated(EnumType.STRING)
	private TamanhoPizza tamanho;
	
	public SaborPizza getSabor() {
		return sabor;
	}
	public void setSabor(SaborPizza sabor) {
		this.sabor = sabor;
	}
	public TamanhoPizza getTamanho() {
		return tamanho;
	}
	public void setTamanho(TamanhoPizza tamanho) {
		this.tamanho = tamanho;
	}
	
	public Pizza converter() {
		int tempoDePreparo = 0;
		double valorDaPizza = 0;
		double valorExtraBacon = 0;
		double valorBordaRecheada = 0;
		
		if(this.tamanho == TamanhoPizza.PEQUENA) {
			tempoDePreparo = 15;
			valorDaPizza = 20;
		} else if (this.tamanho == TamanhoPizza.MEDIA) {
			tempoDePreparo = 20;
			valorDaPizza = 30;
		} else if (this.tamanho == TamanhoPizza.GRANDE) {
			tempoDePreparo = 25;
			valorDaPizza = 40;
		} 
		if (this.sabor == SaborPizza.PORTUGUESA) {
			tempoDePreparo += 5;
		}
		
		return new Pizza(this.sabor, this.tamanho, tempoDePreparo, valorDaPizza, valorExtraBacon, valorBordaRecheada);
	}
	
	
	

}
