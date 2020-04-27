package br.com.fiap.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {
	
	@Id
	@Column(name = "nr_cep")
	private int cep; 
	
	@Column(name = "ds_logadouro", nullable = false, length = 100)
	private String logadouro;
	
	@Column(name = "ds_complemento", length = 50)
	private String complemento;
	
	@OneToOne(mappedBy = "endereco", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Hospital hospital;

	public Endereco() {}

	public Endereco(int cep, String logadouro) {
		this.cep = cep;
		this.logadouro = logadouro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getLogadouro() {
		return logadouro;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	

}
