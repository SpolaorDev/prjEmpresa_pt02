package com.vinicius.prjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.prjEmpresa.entities.Departamento;
import com.vinicius.prjEmpresa.services.DepartamentoService;



@RestController
@RequestMapping("/departamentos")
public class DepartamentoControler {
private final DepartamentoService departamentoService;
	
	@GetMapping("/home")
	public String paginaInicial ( ) {
		return "index";
	}

	
	@Autowired
	public DepartamentoController (DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	
	@PostMapping
	public Departamento createDepartamentos(@RequestBody Departamento departamento) {
		return departamentoService.saveDepartamento(departamento);
	}
	
	//Utilizando o ResponseEntity e RequestEntity
		@GetMapping("/nome/{depnome}")
		public ResponseEntity<List<Departamento>> getAllDepartamentos(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Departamento> departamentos = departamentoService.getAllDepartamento();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(departamentos);
		}
		
		@PutMapping("/{id}")
		public Departamento updateDepartamento(@PathVariable Long depcodigo, @RequestBody Departamento departamento) {
		    return departamentoService.updateDepartamento(depcodigo, departamento);
		}
	
	@DeleteMapping
	public void deleteDepartamento(@PathVariable Long depcodigo) {
		departamentoService.deleteDepartamento(depcodigo);
	}

}
