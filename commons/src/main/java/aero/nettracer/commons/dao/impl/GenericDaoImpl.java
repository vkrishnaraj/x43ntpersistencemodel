package aero.nettracer.commons.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import aero.nettracer.commons.dao.GenericDao;
import aero.nettracer.commons.utils.HibernateWrapper;

public abstract class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	private static Logger logger = Logger.getLogger(GenericDaoImpl.class);
	private Class<T> type;
	
	@Autowired
	private HibernateWrapper hibernateWrapper;
	
	@Override
	public HibernateWrapper getHibernateWrapper() {
		return hibernateWrapper;
	}
	
	@Override
	public void setHibernateWrapper(HibernateWrapper hibernateWrapper) {
		this.hibernateWrapper = hibernateWrapper;
	}

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public PK create(T newInstance) {
		Session session = null;
		Transaction t = null;
		try {
			session = openSession();
			t = session.beginTransaction();
			Serializable serializableObj = session.save(newInstance);
			t.commit();
			return (PK) serializableObj;
		} catch (Exception e) {
			rollback(t);
			logger.error("Failed to save.", e);
			throw new RuntimeException(e);
		} finally {
			closeSession(session);
		}
	}

	@Override
	public PK create(T newInstance, Session session) {
		try {
			Serializable serializableObj = session.save(newInstance);
			return (PK) serializableObj;
		}catch (Exception e) {
			logger.error("Failed to save.", e);
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public T read(PK id) {
		Session session = null;
		try {
			session = openSession();
			return (T) session.get(type, id);
		} catch (Exception e) {
			logger.error("Failed to read.", e);
			throw new RuntimeException(e);
		} finally {
			closeSession(session);
		}

	}

	@Override
	public T read(PK id, Session session) {
		try {
			return (T) session.get(type, id);
		} catch (Exception e) {
			logger.error("Failed to read.", e);
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public T load(PK id) {
		Session session = null;
		try {
			session = openSession();
			return (T) session.load(type, id);
		} catch (Exception e) {
			logger.error("Failed to load.", e);
			throw new RuntimeException(e);
		} finally {
			closeSession(session);
		}
	}

	@Override
	public T load(PK id, Session session) {
		try {
			return (T) session.load(type, id);
		} catch (Exception e) {
			logger.error("Failed to load.", e);
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public T readUniqueResultWithCriteria(Criteria criteria) {
		try {
			return (T) criteria.uniqueResult();
		} catch (Exception e) {
			logger.error("Failed to read.", e);
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> readResultsListWithCriteria(Criteria criteria) {
		try {
			return (List<T>) criteria.list();
		} catch (Exception e) {
			logger.error("Failed to read.", e);
			throw new RuntimeException(e);
		}
	}

	public void update(T transientObject) {
		Session session = null;
		Transaction t = null;
		try {
			session = openSession();
			t = session.beginTransaction();
			session.saveOrUpdate(transientObject);
			t.commit();
		} catch (Exception e) {
			rollback(t);
			logger.error("Failed to update.", e);
			throw new RuntimeException(e);
		} finally {
			closeSession(session);
		}

	}

	@Override
	public void update(T transientObject, Session session) {
		try {
			session.saveOrUpdate(transientObject);
		} catch (Exception e) {
			logger.error("Failed to update.", e);
			throw new RuntimeException(e);
		}
	}

	public void delete(T persistentObject) {
		Session session = null;
		Transaction t = null;
		try {
			session = openSession();
			t = session.beginTransaction();
			session.delete(persistentObject);
			t.commit();
		} catch (Exception e) {
			rollback(t);
			logger.error("Failed to delete.", e);
			throw new RuntimeException(e);
		} finally {
			closeSession(session);
		}
	}

	@Override
	public void delete(T persistentObject, Session session) {
		try {
			session.delete(persistentObject);
		} catch (Exception e) {
			logger.error("Failed to delete.", e);
			throw new RuntimeException(e);
		}
	}

	public void deleteMultiple(List<T> persistentObjects) {
		Session session = null;
		Transaction t = null;
		try {
			session = openSession();
			t = session.beginTransaction();
			for(T persistentObject : persistentObjects) {
				session.delete(persistentObject);
			}
			t.commit();
		} catch (Exception e) {
			rollback(t);
			logger.error("Failed to delete.", e);
			throw new RuntimeException(e);
		}finally {
			closeSession(session);
		}
	}

	@Override
	public void deleteMultiple(List<T> persistentObjects, Session session) {
		try {
			for(T persistentObject : persistentObjects) {
				session.delete(persistentObject);
			}
		} catch (Exception e) {
			logger.error("Failed to delete.", e);
			throw new RuntimeException(e);
		}
	}

	protected Session openSession() {
		return getHibernateWrapper().createSession();
	}

	protected void closeSession(Session session) {
		try {
			if (session != null && session.isOpen())
				session.close();
		} catch (Exception e) {
			logger.error("Failed to close hibernate session", e);
		}
	}

	protected void rollback(Transaction t) {
		if (t != null && !t.wasCommitted()) {
			t.rollback();
		}
	}

}
