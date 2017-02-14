package net.softwareevolutivo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * <b> Generico que permite realizar operaciones sobre los objetos que representan a las tablas de base de datos </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
public class GenericDAO <T>{
	
	@PersistenceContext(unitName = "cajaChica")
	protected EntityManager em;

	private Class<T> object;
	
	public GenericDAO(Class<T> object) {
		this.object = object;
	}
	
	public void insert(T object){
		em.persist(object);
	}
	
	public void remove(T object){
		em.remove(em.merge(object));
	}
	
	public void update(T object){
		em.merge(object);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		StringBuilder sql = new StringBuilder();
		sql.append("select o from ").append(object.getName());
		Query query = em.createQuery(sql.toString());
		return query.getResultList();
	}

}
