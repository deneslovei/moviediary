package org.nnc.moviediary.dao.implementations;

import java.util.List;

import org.hibernate.SessionFactory;
import org.nnc.moviediary.dao.interfaces.GenreDao;
import org.nnc.moviediary.domain.entities.Genre;
import org.springframework.transaction.annotation.Transactional;

public class GenreDaoImpl extends Dao implements GenreDao {

	public GenreDaoImpl(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Genre> getAllGenres() {
		return simpleGetAll(Genre.class);
	}

	@Transactional(readOnly = true)
	@Override
	public Genre getGenreById(final long id) {
		return simpleGetById(Genre.class, id);
	}

	@Transactional
	@Override
	public void saveGenre(final Genre genre) {
		simpleSave(genre);
	}

	@Transactional
	@Override
	public void updateGenre(final Genre genre) {
		simpleUpdate(genre);
	}
}
