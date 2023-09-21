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

import com.projetojpa.entities.Aposento;
import com.projetojpa.services.AposentoServices;

@RestController
@RequestMapping("/aposento")
public class AposentoController {
	
		private final AposentoServices aposentoServices;
		@Autowired
		public AposentoController(AposentoServices aposentoServices) {
			this.aposentoServices = aposentoServices;
		}
		@GetMapping("/{codigo}")
		public ResponseEntity <Aposento> buscaAposentoIdControlId(@PathVariable Long codigo){
			Aposento aposento = aposentoServices.buscaAposentoId(codigo);
			if(aposento != null) {
				return ResponseEntity.ok(aposento);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@GetMapping("/")
		public ResponseEntity<List<Aposento>> buscaTodosAposentoControl() {
			List<Aposento> Aposento = aposentoServices.buscarTodosAposento();

			return ResponseEntity.ok(Aposento);
		}
		@PostMapping("/")
		public ResponseEntity<Aposento> salvaAposentoControl(@RequestBody Aposento aposento){
			Aposento salvaAposento = aposentoServices.salvaAposento(aposento);

			return ResponseEntity.status(HttpStatus.CREATED).body(salvaAposento);

		}
		@PutMapping ("/{codigo}")
		public ResponseEntity<Aposento> updateAposento(@PathVariable Long codigo, @RequestBody Aposento aposento) {
			Aposento  updateAposento = aposentoServices.alterarAposento(codigo,aposento);
	        if (updateAposento  != null) {
	            return ResponseEntity.ok(updateAposento);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
		@DeleteMapping("/{codigo}")
		public ResponseEntity<String> apagaPAposentoControl(@PathVariable Long codigo) {
			boolean apagar = aposentoServices.apagarAposento(codigo);
			if(apagar) {
				return ResponseEntity.ok().body("O produto foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}

	}

