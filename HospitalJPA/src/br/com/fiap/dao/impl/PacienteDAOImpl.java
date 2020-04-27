package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entities.Paciente;

public class PacienteDAOImpl extends GenericDAOImpl<Paciente, Integer> 
							 implements PacienteDAO{

	public PacienteDAOImpl(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

}
