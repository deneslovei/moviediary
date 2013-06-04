package org.nnc.moviediary.dao.implementations;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nnc.moviediary.dao.interfaces.MovieDao;
import org.nnc.moviediary.domain.entities.Movie;
import org.springframework.transaction.annotation.Transactional;

public class MovieDaoImpl implements MovieDao {
	private final SessionFactory sessionFactory;

	public MovieDaoImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Movie> getMovies() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Movie.class);
		List<Movie> movies = criteria.list();
		return movies;
	}

	@Transactional(readOnly = true)
	@Override
	public Movie getMovie(final long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Movie) session.get(Movie.class, id);
	}

	@Transactional
	@Override
	public void saveMovie(final Movie movie) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(movie);
		session.getTransaction().commit();
		session.close();
	}
}