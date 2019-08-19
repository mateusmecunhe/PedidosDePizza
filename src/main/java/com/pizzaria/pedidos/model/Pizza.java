package com.pizzaria.pedidos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private SaborPizza sabor;
	private TamanhoPizza tamanho;
	
	public Pizza(SaborPizza sabor, TamanhoPizza tamanho) {
		this.sabor = sabor;
		this.tamanho = tamanho;
	}
	
	public Pizza() {}
	
	public double calculaValorDaPizza(String tamanho) {
		if(tamanho.equals(TamanhoPizza.PEQUENA)) {
			return 20;
		} else if (tamanho.equals(TamanhoPizza.MEDIA)) {
			return 30;
		} 
		return 40;
	}
	
	
	
	public int calculaTempoDaPizza(Pizza pizza) {
		int tempoDePreparo = 0;
		if(pizza.getTamanho().equals(TamanhoPizza.PEQUENA)) {
			tempoDePreparo = tempoDePreparo + 15;
		} else if (pizza.getTamanho().equals(TamanhoPizza.MEDIA)) {
			tempoDePreparo = tempoDePreparo + 20;
		} 
		else if (pizza.getTamanho().equals(TamanhoPizza.GRANDE)) {
			tempoDePreparo = tempoDePreparo+25;
		}
		if(pizza.getSabor().equals(SaborPizza.PORTUGUESA)) {
			tempoDePreparo = tempoDePreparo+5;
		}
		return tempoDePreparo;
	}

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

	public Long getId() {
		return this.id;
	}
	
}
