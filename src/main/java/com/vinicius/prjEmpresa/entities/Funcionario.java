package com.vinicius.prjEmpresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Funcodigo;
	
	private String Funnome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate Funnascimento;
	
	private Long Funsalario;
	
	public Long getFuncodigo() {
		return Funcodigo;
	}

	public void setFuncodigo(Long funcodigo) {
		this.Funcodigo = funcodigo;
	}

	public String getFunnome() {
		return Funnome;
	}

	public void setFunnome(String funnome) {
		this.Funnome = funnome;
	}

	public LocalDate getFunnascimento() {
		return Funnascimento;
	}

	public void setFunnascimento(LocalDate funnascimento) {
		this.Funnascimento = funnascimento;
	}

	public Long getFunsalario() {
		return Funsalario;
	}

	public void setFunsalario(Long funsalario) {
		this.Funsalario = funsalario;
	}
	@ManyToMany
	private Departamento departamento;

//inserir os metodos get e o set
public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	

	

	

}
