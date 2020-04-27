package br.com.fiap.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

	@ManyToMany(mappedBy = "pacientes")
	private List<Funcionario> funcionario; 
	
	public Paciente() {}

	public Paciente(int cpf, String nome, Genero genero, Calendar entrada, Calendar saida) {
		this.cpf = cpf;
		this.nome = nome;
		this.genero = genero;
		this.entrada = entrada;
		this.saida = saida;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Calendar getEntrada() {
		return entrada;
	}

	public void setEntrada(Calendar entrada) {
		this.entrada = entrada;
	}

	public Calendar getSaida() {
		return saida;
	}

	public void setSaida(Calendar saida) {
		this.saida = saida;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
	
	
	
}
