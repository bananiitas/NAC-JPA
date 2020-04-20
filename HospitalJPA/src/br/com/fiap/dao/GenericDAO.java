package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.NoDataException;

public interface GenericDAO <E, K> {
	
	void create(E entity); 
	
	void update(E entity); 
	
	E search(K key) throws NoDataException; 
	
	void delete(K key) throws NoDataException; 
	
	void commit() throws CommitException; 
	

}
