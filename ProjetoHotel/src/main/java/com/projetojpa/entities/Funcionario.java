package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name= "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name= "nome")
	private String nome;

	@Column(name= "cargo")
	private String cargo;

	@Column(name= "salario")
	private double salario;

	@Column(name= "cpf")
	private String cpf;

	@Column(name= "telefone")
	private String telefone;


	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo (Long codigo) {
		this.codigo= codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo=cargo;

	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario=salario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf=cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone=telefone;
	}

}

