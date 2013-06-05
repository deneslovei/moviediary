package org.nnc.moviediary.dao.implementations;

import java.util.List;

import org.hibernate.SessionFactory;
import org.nnc.moviediary.dao.interfaces.CelebrityDao;
import org.nnc.moviediary.domain.entities.Celebrity;
import org.springframework.transaction.annotation.Transactional;

public class CelebrityDaoImpl extends Dao implements CelebrityDao {

	public CelebrityDaoImpl(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Transactional
	@Override
	public void saveCelebrity(final Celebrity celebrity) {
		simpleSave(celebrity);
	}

	@Transactional
	@Override
	public List<Celebrity> getAllCelebrities() {
		return simpleGetAll(Celebrity.class);
	}
}
