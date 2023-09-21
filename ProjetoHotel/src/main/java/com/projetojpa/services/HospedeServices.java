package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Hospede;
import com.projetojpa.repository.HospedeRepository;

@Service
public class HospedeServices {
	private final HospedeRepository hospedeRepository;

	@Autowired
	public HospedeServices(HospedeRepository hospedeRepository) {
		this.hospedeRepository = hospedeRepository;
	}
	public List<Hospede> buscarTodosHospede(){
		return hospedeRepository.findAll();
	}
	//método para buscar produto por código 
	public Hospede buscaHospedeId(long codigo) {
		Optional<Hospede> hospede = hospedeRepository.findById(codigo); // classe usada para consulta de banco
		return hospede.orElse(null);
	} 
	//método para salvar os produtos
	public Hospede salvaHospede(Hospede hospede) {
		return hospedeRepository.save(hospede);
	}
	public Hospede alterarHospede(long codigo, Hospede alterarHospede) {
		Optional<Hospede> existeHospede = hospedeRepository.findById(codigo);
		if (existeHospede.isPresent()) {
			alterarHospede.setCodigo(codigo);
			return hospedeRepository.save(alterarHospede);
		}
		return null;
	}
	public boolean apagarHospede(long codigo) {
		Optional<Hospede> existeHospede = hospedeRepository.findById(codigo);
		if (existeHospede.isPresent()) {
			hospedeRepository.deleteById(codigo);
			return true;
		}
		return false;
	}
}


