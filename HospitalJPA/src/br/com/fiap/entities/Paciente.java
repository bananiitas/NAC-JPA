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
@Table(name = "TB_PACIENTE")
public class Paciente {
	
	@Id
	@Column(name = "cpf_paciente")
	private int cpf;
	
	@Column(name = "nm_paciente", nullable = false, length = 50)
	private String nome; 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_genero")
	private Genero genero; 
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_entrada", nullable = false)
	private Calendar entrada; 

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_saida")
	private Calendar saida;

	public Paciente() {
		super();
	}
	
	
}
