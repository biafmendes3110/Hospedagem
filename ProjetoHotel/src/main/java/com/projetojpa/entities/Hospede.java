package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name= "hospede")
public class Hospede {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@Column(name= "nome")
	private String nome;

	@Column(name= "cpf")
	private String cpf;

	@Column(name= "rg")
	private double rg;

	@Column(name= "telefone")
	private String telefone;

	public long getCodigo() {
		return codigo;
	}
	public void setCodigo (long codigo) {
		this.codigo= codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf=cpf;

	}
	public double getRg() {
		return rg;
	}
	public void setRg(double rg) {
		this.rg=rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone=telefone;
	}



}
