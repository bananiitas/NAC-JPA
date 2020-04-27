package br.com.fiap.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	private double salario; 
	
	@ManyToOne
	@JoinColumn(name = "cnpj")
	private Hospital hospital;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TB_FUNCIONARIO_PACIENTE", 
				joinColumns = @JoinColumn(name = "cpf_funcionario"), 
				inverseJoinColumns = @JoinColumn(name = "cpf_paciente"))
	private List<Paciente> pacientes; 

	public Funcionario() {}

	public Funcionario(int cpf, String nome, Calendar admissao, Genero genero, String cargo, double salario) {
		this.cpf = cpf;
		this.nome = nome;
		this.admissao = admissao;
		this.genero = genero;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	
	public Funcionario(int cpf, String nome, Calendar admissao, Genero genero, String cargo, double salario, List<Paciente> pacientes) {
		this.cpf = cpf;
		this.nome = nome;
		this.admissao = admissao;
		this.genero = genero;
		this.cargo = cargo;
		this.salario = salario;
		this.pacientes = pacientes;
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

	public Calendar getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Calendar admissao) {
		this.admissao = admissao;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	} 
	
	public List<Paciente> getPaciente(){
		return pacientes; 
	}
	
	public void setPaciente(List<Paciente> paciente) {
		this.pacientes = paciente;
	}
	
	
	
	
	
	
}
