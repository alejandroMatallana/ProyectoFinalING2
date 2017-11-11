package com.cooperativacafetera.dealmanager.dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAOGenerico {

	private EntityManager em;
	private Class clase;

	public DAOGenerico(EntityManager em, Class clase) {
		super();
		this.em = em;
		this.clase = clase;
	}

	//Metodo generico para crear un objeto de cualquier tipo
	public void crear(Object obj) {
		em.persist(obj);
	}

	/**
	 * Metodo generico para editar un objeto de cualquier tipo
	 * @param obj
	 */
	public void editar(Object obj) {
		em.merge(obj);
	}

	/**
	 * Metodo generico que permite eliminar un objeto
	 * @param obj
	 */
	public void eliminar(Object obj) {
		em.remove(em.contains(obj) ? obj : em.merge(obj));
	}

	/**
	 * Metodo para buscar un objeto por su llave primaria
	 * @param pk
	 * @return, el objeto si se encuentra
	 */
	public <T> T buscar(Object pk) {
		return (T) em.find(clase, pk);
	}

	public void refrescar(Object entity) {
		em.refresh(entity);
	}
	
	/**
	 * Metodo para listar los objetos guardados en la base de datos
	 * @param nombre
	 * @param parametros
	 * @return, la lista con lo que este en la BD
	 */
	public <T> List<T> ejecutarNamedQuery(String nombre, Object... parametros) {
		Query q = em.createNamedQuery(nombre);
		for (int i = 0; i < parametros.length; i++) {
			Object param = parametros[i];
			q.setParameter(i + 1, param);
		}
		return q.getResultList();
	}
}