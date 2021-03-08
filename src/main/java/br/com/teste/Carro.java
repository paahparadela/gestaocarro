package br.com.teste;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long chassi;
	private String cor;
	private int quantidadePorta;
	private String marca;
	private String modelo;
	private double motor;
	
	public Long getChassi() {
		return chassi;
	}
	public void setChassi(Long chassi) {
		this.chassi = chassi;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getQuantidadePorta() {
		return quantidadePorta;
	}
	public void setQuantidadePorta(int quantidadePorta) {
		this.quantidadePorta = quantidadePorta;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getMotor() {
		return motor;
	}
	public void setMotor(double motor) {
		this.motor = motor;
	}
	
}
