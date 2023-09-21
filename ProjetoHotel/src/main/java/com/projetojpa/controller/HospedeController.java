package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Hospede;
import com.projetojpa.services.HospedeServices;

@RestController
@RequestMapping("/hospede")
public class HospedeController {

	private final HospedeServices hospedeServices;
	@Autowired
	public HospedeController(HospedeServices hospedeServices) {
		this.hospedeServices = hospedeServices;
	}
	@GetMapping("/{codigo}")
	public ResponseEntity <Hospede> buscaHospedeIdControlId(@PathVariable Long codigo){
		Hospede hospede = hospedeServices.buscaHospedeId(codigo);
		if(hospede != null) {
			return ResponseEntity.ok(hospede);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Hospede>> buscaTodosHospedeControl() {
		List<Hospede> Hospede = hospedeServices.buscarTodosHospede();

		return ResponseEntity.ok(Hospede);
	}
	@PostMapping("/")
	public ResponseEntity<Hospede> salvaHospedeControl(@RequestBody Hospede hospede){
		Hospede salvaHospede = hospedeServices.salvaHospede(hospede);

		return ResponseEntity.status(HttpStatus.CREATED).body(salvaHospede);

	}
	@PutMapping ("/{codigo}")
	public ResponseEntity<Hospede> updateHospede(@PathVariable Long codigo, @RequestBody Hospede hospede) {
		Hospede  updateHospede = hospedeServices.alterarHospede(codigo, hospede);
        if (updateHospede  != null) {
            return ResponseEntity.ok(updateHospede );
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> apagaPHospedeControl(@PathVariable Long codigo) {
		boolean apagar = hospedeServices.apagarHospede(codigo);
		if(apagar) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}

