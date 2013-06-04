package org.nnc.moviediary.dao.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nnc.moviediary.dao.interfaces.WatchListDao;
import org.nnc.moviediary.domain.entities.WatchList;
import org.springframework.transaction.annotation.Transactional;

public class WatchListDaoImpl implements WatchListDao {

	private final SessionFactory sessionFactory;

	public WatchListDaoImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public WatchList getPublicWatchListById(final Long id) {
		Session session = sessionFactory.getCurrentSession();
		WatchList watchList = (WatchList) session.get(WatchList.class, id);
		if (watchList.isPublic()) {
			return watchList;
		} else {
			return null;
		}
	}

}
