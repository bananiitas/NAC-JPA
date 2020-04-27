package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.HospitalDAO;
import br.com.fiap.entities.Hospital;

public class HospitalDAOImpl extends GenericDAOImpl<Hospital, Integer> implements HospitalDAO{

	public HospitalDAOImpl(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

}
