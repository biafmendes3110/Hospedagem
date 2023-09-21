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

import com.projetojpa.entities.Funcionario;
import com.projetojpa.services.FuncionarioServices;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {


	private final FuncionarioServices funcionarioServices;
	@Autowired
	public FuncionarioController(FuncionarioServices funcionarioServices) {
		this.funcionarioServices = funcionarioServices;
	}
	@GetMapping("/{codigo}")
	public ResponseEntity <Funcionario> buscaFuncionarioIdControlId(@PathVariable Long codigo){
		Funcionario funcionario = funcionarioServices.buscaFuncionarioId(codigo);
		if(funcionario != null) {
			return ResponseEntity.ok(funcionario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> buscaTodosProdutosControl() {
		List<Funcionario> Funcionarios = funcionarioServices.buscarTodosFuncionario();

		return ResponseEntity.ok(Funcionarios);
	}
	@PostMapping("/")
	public ResponseEntity<Funcionario> salvaProdutosControl(@RequestBody Funcionario funcionario){
		Funcionario salvaFuncionario = funcionarioServices.salvaFuncionario(funcionario);

		return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionario);

	}
	@PutMapping ("/{codigo}")
	public ResponseEntity<Funcionario> updatefuncionario(@PathVariable Long codigo, @RequestBody Funcionario funcionario) {
        Funcionario updatefuncionario = funcionarioServices.alterarFuncionario(codigo, funcionario);
        if (updatefuncionario != null) {
            return ResponseEntity.ok(updatefuncionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> apagaPFuncionarioControl(@PathVariable Long codigo) {
		boolean apagar = funcionarioServices.apagarFuncionario(codigo);
		if(apagar) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
