package org.nnc.moviediary.service.implementations;

import java.util.List;

import org.nnc.moviediary.dao.interfaces.CelebrityDao;
import org.nnc.moviediary.domain.entities.Celebrity;
import org.nnc.moviediary.domain.entities.Movie;
import org.nnc.moviediary.service.interfaces.CelebrityService;

public class CelebrityServiceImpl implements CelebrityService {

	private CelebrityDao celebrityDao;

	public CelebrityServiceImpl(final CelebrityDao celebrityDao) {
		this.celebrityDao = celebrityDao;
	}

	@Override
	public List<String> saveCelebrity(final String celebrityId, final Boolean visible, final String name, final String imdbLink, final String[] featuredInIds,
			final String[] directedMoviesIds) {
		List<String> errors = ServiceUtil.validateCelebrity(celebrityId, visible, name, imdbLink, featuredInIds, directedMoviesIds);
		if (errors.isEmpty()) {
			long id = Long.parseLong(celebrityId);
			List<Movie> featuredIn = ServiceUtil.convertIdsToEntitiesToSave(featuredInIds, Movie.class);
			List<Movie> directedMovies = ServiceUtil.convertIdsToEntitiesToSave(directedMoviesIds, Movie.class);
			saveCelebrity(id, visible, name, imdbLink, featuredIn, directedMovies);
		}
		return errors;
	}

	@Override
	public void saveCelebrity(final long id, final Boolean visible, final String name, final String imdbLink, final List<Movie> featuredIn,
			final List<Movie> directedMovies) {
		Celebrity celebrity = new Celebrity(id, visible, name, imdbLink, featuredIn, directedMovies);
		celebrityDao.saveCelebrity(celebrity);
	}

	@Override
	public List<Celebrity> getAllCelebrities() {
		return celebrityDao.getAllCelebrities();
	}
}
