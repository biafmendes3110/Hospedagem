package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Aposento;
import com.projetojpa.repository.AposentoRepository;

@Service
public class AposentoServices {

	private final AposentoRepository aposentoRepository;

	@Autowired
	public AposentoServices(AposentoRepository aposentoRepository) {
		this.aposentoRepository = aposentoRepository;
	}
	public List<Aposento> buscarTodosAposento(){
		return aposentoRepository.findAll();
	}
	//método para buscar produto por código 
	public Aposento buscaAposentoId(long codigo) {
		Optional<Aposento> Aposento = aposentoRepository.findById(codigo); // classe usada para consulta de banco
		return Aposento.orElse(null);
	} 
	//método para salvar os produtos
	public Aposento salvaAposento(Aposento aposento) {
		return aposentoRepository.save(aposento);
	}
	public Aposento alterarAposento(long codigo, Aposento alterarAposento) {
		Optional<Aposento> existeAposento = aposentoRepository.findById(codigo);
		if (existeAposento.isPresent()) {
			alterarAposento.setCodigo(codigo);
			return aposentoRepository.save(alterarAposento);
		}
		return null;
	}
	public boolean apagarAposento(long codigo) {
		Optional<Aposento> existeAposento = aposentoRepository.findById(codigo);
		if (existeAposento.isPresent()) {
			aposentoRepository.deleteById(codigo);
			return true;
		}
		return false;
	}
}

