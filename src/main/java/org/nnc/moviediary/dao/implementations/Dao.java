package org.nnc.moviediary.dao.implementations;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.nnc.moviediary.domain.entities.BaseEntity;

public class Dao {
	protected final SessionFactory sessionFactory;

	protected Dao(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	protected <E extends BaseEntity> List<E> simpleGetAll(final Class<E> clazz) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	protected <E extends BaseEntity> List<E> simpleGetAllVisible(final Class<E> clazz) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(Restrictions.eq("visible", true));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	protected <E extends BaseEntity> E simpleGetById(final Class<E> clazz, final long id) {
		Session session = sessionFactory.getCurrentSession();
		return (E) session.get(clazz, id);
	}

	protected <E extends BaseEntity> void simpleSave(final E entity) {
		entity.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}

	protected <E extends BaseEntity> void simpleUpdate(final E entity) {
		entity.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}
}
