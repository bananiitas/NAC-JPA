package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.NoDataException;

public class GenericDAOImpl <E, K> implements GenericDAO<E, K>{
	
	private EntityManager manager; 
	
	private Class<E> clazz; 
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager manager) {
		this.manager = manager;
		this.clazz = (Class<E>) ((ParameterizedType)
				getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void create(E entity) {
		manager.persist(entity);		
	}

	@Override
	public void update(E entity) {
		manager.merge(entity);
	}

	@Override
	public E search(K key) throws NoDataException {
		E entity = manager.find(clazz, key);
		
		if(entity == null)
			throw new NoDataException();
		return entity;
	}

	@Override
	public void delete(K key) throws NoDataException {
		manager.remove(search(key));
	}

	@Override
	public void commit() throws CommitException {
		try {
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();		
			e.printStackTrace();
			throw new CommitException();
		}		
	}

}
