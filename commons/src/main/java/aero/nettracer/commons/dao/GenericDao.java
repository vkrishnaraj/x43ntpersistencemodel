package aero.nettracer.commons.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

import aero.nettracer.commons.utils.HibernateWrapper;
import org.hibernate.Session;

public interface GenericDao<T, PK extends Serializable> {
	public PK create(T newInstance);
	
	public T load(PK id);

	public T read(PK id);
	
	public T readUniqueResultWithCriteria(Criteria criteria);
	
	public List<T> readResultsListWithCriteria(Criteria criteria);

	public void update(T transientObject);

	public void delete(T persistentObject);
	
	public void deleteMultiple(List<T> persistentObjects);

	public PK create(T newInstance, Session session);

	public T load(PK id, Session session);

	public T read(PK id, Session session);

	public void update(T transientObject, Session session);

	public void delete(T persistentObject, Session session);

	public void deleteMultiple(List<T> persistentObjects, Session session);
	
	public HibernateWrapper getHibernateWrapper();
	
	public void setHibernateWrapper(HibernateWrapper hibernateWrapper);
	
}