package org.nnc.moviediary.dao.implementations;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.nnc.moviediary.dao.interfaces.MovieDao;
import org.nnc.moviediary.domain.entities.Movie;
import org.springframework.transaction.annotation.Transactional;

public class MovieDaoImpl extends Dao implements MovieDao {

	public MovieDaoImpl(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Movie> getMovies() {
		return simpleGetAll(Movie.class);
	}

	@Transactional(readOnly = true)
	@Override
	public Movie getMovie(final long id) {
		return simpleGetById(Movie.class, id);
	}

	@Transactional
	@Override
	public void saveMovie(final Movie movie) {
		simpleSave(movie);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Movie> getMoviesByTitleStart(final String prefix) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Movie.class);
		criteria.add(Restrictions.ilike("originalTitle", "%" + prefix + "%"));
		return criteria.list();
	}
}