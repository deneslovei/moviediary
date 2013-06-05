package org.nnc.moviediary.dao.implementations;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nnc.moviediary.domain.entities.BaseEntity;

public class Dao {
	protected final SessionFactory sessionFactory;

	public Dao(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public <E extends BaseEntity> void simpleSave(final E entity) {
		entity.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public <E extends BaseEntity> List<E> simpleGetAll(final Class<E> clazz) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		return criteria.list();
	}
}
