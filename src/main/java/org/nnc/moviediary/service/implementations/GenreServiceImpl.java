package org.nnc.moviediary.service.implementations;

import java.util.List;

import org.nnc.moviediary.dao.interfaces.GenreDao;
import org.nnc.moviediary.domain.entities.Genre;
import org.nnc.moviediary.domain.entities.Movie;
import org.nnc.moviediary.service.interfaces.GenreService;

public class GenreServiceImpl implements GenreService {

	private GenreDao genreDao;

	public GenreServiceImpl(final GenreDao genreDao) {
		this.genreDao = genreDao;
	}

	@Override
	public List<Genre> getAllGenres() {
		return genreDao.getAllGenres();
	}

	@Override
	public Genre getGenreById(final String genreId) {
		long id = Long.parseLong(genreId);
		return genreDao.getGenreById(id);
	}

	@Override
	public List<String> saveGenre(final Boolean visible, final String name, final String description, final String[] moviesIds) {
		List<String> errors = ServiceUtil.validateGenre("0", visible, name, description, moviesIds);
		if (errors.isEmpty()) {
			List<Movie> movies = ServiceUtil.convertIdsToDummyEntitiesToSave(moviesIds, Movie.class);
			saveGenre(visible, name, description, movies);
		}
		return errors;
	}

	private void saveGenre(final Boolean visible, final String name, final String description, final List<Movie> movies) {
		Genre genre = new Genre(0L, visible, name, description, movies);
		genreDao.saveGenre(genre);
	}

	@Override
	public List<String> updateGenre(final String genreId, final Boolean visible, final String name, final String description, final String[] moviesIds) {
		List<String> errors = ServiceUtil.validateGenre(genreId, visible, name, description, moviesIds);
		if (errors.isEmpty()) {
			long id = Long.parseLong(genreId);
			List<Movie> movies = ServiceUtil.convertIdsToDummyEntitiesToSave(moviesIds, Movie.class);
			updateGenre(id, visible, name, description, movies);
		}
		return errors;
	}

	private void updateGenre(final long id, final Boolean visible, final String name, final String description, final List<Movie> movies) {
		Genre genre = new Genre(id, visible, name, description, movies);
		genreDao.updateGenre(genre);
	}
}
