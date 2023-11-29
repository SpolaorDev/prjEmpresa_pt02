package com.vinicius.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import com.vinicius.prjEmpresa.entities.Departamento;
import com.vinicius.prjEmpresa.entities.Funcionario;
import com.vinicius.prjEmpresa.repositories.DepartamentoRepository;


public class DepartamentoService {
private final DepartamentoRepository departamentoRepository;
	
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}
	
	public Departamento saveEmpresa(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	
	public Departamento getEmpresaByDepcodigo(Long Depcodigo) {
		return departamentoRepository.findById(Depcodigo).orElse(null);
	}
	
	public List<Departamento>getAllEmpresa(){
		return departamentoRepository.findAll();
	}
	public void deleteEmpresa(Long Depcodigo) {
		departamentoRepository.deleteById(Depcodigo);
	}
	
	// fazendo o update do jogo com o optional
		public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
	        Optional<Departamento> departamentoOptional = departamentoRepository.findById(depcodigo);
	        if (departamentoOptional.isPresent()) {
	        	Departamento departamentoExistente = departamentoOptional.get();
	           	departamentoExistente.setDepnome(novoDepartamento.getDepnome());
	        	departamentoExistente.setDepcodigo(novoDepartamento.getDepcodigo());          
	            return departamentoRepository.save(departamentoExistente); 
	        } else {
	            return null; 
	        }
	    }

}


