package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.entities.Endereco;

public class EnderecoDAOImpl extends GenericDAOImpl<Endereco, Integer> implements EnderecoDAO{

	public EnderecoDAOImpl(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

}
