package br.com.fiap.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_HOSPITAL")
public class Hospital {
	
	@Id
	@Column(name = "nr_cnpj")
	private int cnpj; 
	
	@Column(name = "nm_hospital", nullable = false, length = 100)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_especialidade", nullable = false)
	private Especialidade especialidade; 

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "nr_cep", nullable = false)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "hospital", cascade = CascadeType.PERSIST)
	private List<Funcionario> funcionario = new ArrayList<Funcionario>(); 
	
	public void addFunc(Funcionario func) {
		funcionario.add(func);
		func.setHospital(this);
	}
	

	public Hospital() {}

	public Hospital(int cnpj, String nome, Especialidade especialidade, Endereco endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.especialidade = especialidade;
		this.endereco = endereco;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	} 
}
