package org.nnc.moviediary.dao.implementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		Session session = sessionFactory.getCurrentSession();
		return (Movie) session.get(Movie.class, id);
	}

	@Transactional
	@Override
	public void saveMovie(final Movie movie) {
		simpleSave(movie);
	}
}