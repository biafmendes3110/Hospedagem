package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name= "aposento")
public class Aposento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@Column(name= "valor")
	private double valor;

	@Column(name= "descricao")
	private String descricao;

	@Column(name= "numero")
	private int numero;

	public long getCodigo() {
		return codigo;
	}
	public void setCodigo (long codigo) {
		this.codigo= codigo;
	}

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor=valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao=descricao;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero (int numero) {
		this.numero= numero;
	}

}
