package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.entities.Funcionario;

public class FuncionarioDAOImpl extends GenericDAOImpl<Funcionario, Integer> 
								implements FuncionarioDAO {

	public FuncionarioDAOImpl(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

}
