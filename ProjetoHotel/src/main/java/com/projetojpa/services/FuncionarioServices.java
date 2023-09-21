package com.projetojpa.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Funcionario;
import com.projetojpa.repository.FuncionarioRepository;

@Service
public class FuncionarioServices {

	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioServices(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	// método para buscar todos os produtos 
	public List<Funcionario> buscarTodosFuncionario(){
		return funcionarioRepository.findAll();
	}
	//método para buscar produto por código 
	public Funcionario buscaFuncionarioId(long codigo) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(codigo); // classe usada para consulta de banco
		return funcionario.orElse(null);
	} 
	//método para salvar os produtos
	public Funcionario salvaFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	public Funcionario alterarFuncionario(long codigo, Funcionario alterarFuncionario) {
		Optional<Funcionario> existeFuncionario = funcionarioRepository.findById(codigo);
		if (existeFuncionario.isPresent()) {
			alterarFuncionario.setCodigo(codigo);
			return funcionarioRepository.save(alterarFuncionario);
		}
		return null;
	}
	public boolean apagarFuncionario(long codigo) {
		Optional<Funcionario> existeFuncionario = funcionarioRepository.findById(codigo);
		if (existeFuncionario.isPresent()) {
			funcionarioRepository.deleteById(codigo);
			return true;
		}
		return false;
	}
}
