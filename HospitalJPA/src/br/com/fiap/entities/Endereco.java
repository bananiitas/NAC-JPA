package br.com.fiap.entities;

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
	
	@OneToOne(mappedBy = "endereco")
	private Hospital hospital;

	public Endereco() {}

}
