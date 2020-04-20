package br.com.fiap.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_FUNCIONARIO")
public class Funcionario {
	
	@Id
	@Column(name = "cpf_funcionario")
	private int cpf; 
	
	@Column(name = "nm_funcionario", nullable = false, length = 50)
	private String nome; 
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_admissao", nullable = false)
	private Calendar admissao; 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_genero")
	private Genero genero; 
	
	@Column(name = "ds_cargo", nullable = false, length = 100)
	private String cargo; 
	
	@Column(name = "vl_salario", nullable = false)
	private float salario; 
}
