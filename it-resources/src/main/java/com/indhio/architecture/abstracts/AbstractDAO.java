package com.indhio.architecture.abstracts;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Vinicius Nascimento
 * 
 */
public abstract class AbstractDAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Produces
	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<T> entityClass;

	/**
	 * Obtém a classe de entidade.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
		if (entityClass == null) {
			Type type = getClass().getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				ParameterizedType paramType = (ParameterizedType) type;
				entityClass = (Class<T>) paramType.getActualTypeArguments()[0];
			} else {
				throw new IllegalArgumentException("Erro ao tentar obter a classe de entidade");
			}
		}

		return entityClass;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public T find(Long id) {
		return (T) entityManager.find(getEntityClass(), id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Object find(Long id, Class<T> clazz) {
		return entityManager.find(clazz, id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public T find(String id) {
		return (T) entityManager.find(getEntityClass(), id);
	}

	public List<T> list() {
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Object find(String id, Class<T> clazz) {
		return entityManager.find(clazz, id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public T merge(T obj) {
		return (T) entityManager.merge(obj);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public T save(T obj) {
		entityManager.persist(obj);
		return obj;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(Long id) {
		entityManager.remove(find(id));
	}

}
