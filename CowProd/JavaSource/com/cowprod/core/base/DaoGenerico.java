
package com.cowprod.core.base;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


/**
 * Clase que ofrece los servicios base sobre la base de datos
 * 
 * @version 1.0 - 16/05/2012
 * @author Marcelo Hidalgo
 */
public abstract class DaoGenerico<T> {

	@PersistenceContext
	protected EntityManager em;


	private Class<T> tipoEntidad;

	/**
	 * Constructor por defecto,
	 * 
	 * @param tipoEntidad
	 *            clase entidad sobre la cual se realizaran los operaciones sobre la base de datos
	 * @param tipoServicio
	 */
	public DaoGenerico(Class<T> tipoEntidad) {
		this.tipoEntidad = tipoEntidad;

	}

	/**
	 * Guarda un objeto en la base de datos
	 * 
	 * @param entidad
	 */
	public void insertar(T entidad) {
		em.persist(entidad);
	}

	/**
	 * Actualiza un objeto existente, si no existe crea uno nuevo
	 * 
	 * @param entidad
	 */
	public void actualizar(T entidad) {
		System.out.println("entro al merge");
		em.merge(entidad);
	}

	/**
	 * Elimina un objeto de la base de datos
	 * 
	 * @param entidad
	 */
	public void eliminar(T entidad) {
		System.out.println("entro al eliminar");
		em.remove(em.merge(entidad));

	}

	/**
	 * Busca un objeto dado su llave primaria
	 * 
	 * @param id
	 * @return
	 */
	public T buscarPorId(Integer id) {
		return em.find(tipoEntidad, id);
	}

	/**
	 * Busca un objeto dado su llave primaria string
	 * 
	 * @param id
	 * @return
	 */
	public T buscarPorIdString(String id) {
		return em.find(tipoEntidad, id);
	}

	/**
	 * Obtiene todos los registros de la tabla
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> buscarTodos() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(tipoEntidad));
		return em.createQuery(cq).getResultList();
	}

}
