package com.pizzaria.pedidos.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pizza {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private SaborPizza sabor;
	@Enumerated(EnumType.STRING)
	private TamanhoPizza tamanho;
	private int tempoDePreparo;
	private double valorDaPizza;
	private boolean extraBacon;
	private boolean semCebola;
	private boolean bordaRecheada;
	private double extraBaconValor;
	private double bordaRecheadaValor;

	
	public Pizza(SaborPizza sabor, TamanhoPizza tamanho, int tempoDePreparo, double valorDaPizza, double extraBaconValor, double bordaRecheadaValor) {
		this.sabor = sabor;
		this.tamanho = tamanho;
		this.tempoDePreparo = tempoDePreparo;
		this.valorDaPizza = valorDaPizza;
		this.extraBaconValor = extraBaconValor;
		this.bordaRecheadaValor = bordaRecheadaValor;
		
	}

	public Pizza() {}
	
	public double getValorDaPizza(String tamanho) {
		if(tamanho.equals(TamanhoPizza.PEQUENA)) {
			return 20;
		} else if (tamanho.equals(TamanhoPizza.MEDIA)) {
			return 30;
		} 
		return 40;
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

	public double getValorDaPizza() {
		return valorDaPizza;
	}

	public void setValorDaPizza(double valorDaPizza) {
		this.valorDaPizza = valorDaPizza;
	}

	public int getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(int tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public boolean getExtraBacon() {
		return extraBacon;
	}

	public void setExtraBacon(boolean extraBacon) {
		this.extraBacon = extraBacon;
	}

	public boolean getSemCebola() {
		return semCebola;
	}

	public void setSemCebola(boolean semCebola) {
		this.semCebola = semCebola;
	}

	public boolean getBordaRecheada() {
		return bordaRecheada;
	}

	public void setBordaRecheada(boolean bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}

	public double getExtraBaconValor() {
		return extraBaconValor;
	}

	public void setExtraBaconValor(double extraBaconValor) {
		this.extraBaconValor = extraBaconValor;
	}

	public double getBordaRecheadaValor() {
		return bordaRecheadaValor;
	}

	public void setBordaRecheadaValor(double bordaRecheadaValor) {
		this.bordaRecheadaValor = bordaRecheadaValor;
	}
	
}
