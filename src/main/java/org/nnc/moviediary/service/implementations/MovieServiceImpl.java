package org.nnc.moviediary.service.implementations;

import java.util.ArrayList;
import java.util.List;

import org.nnc.moviediary.dao.interfaces.MovieDao;
import org.nnc.moviediary.domain.entities.Celebrity;
import org.nnc.moviediary.domain.entities.Genre;
import org.nnc.moviediary.domain.entities.Movie;
import org.nnc.moviediary.service.interfaces.MovieService;

public class MovieServiceImpl implements MovieService {

	private final MovieDao movieDao;

	public MovieServiceImpl(final MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	@Override
	public Movie getMovie(final long id) {
		return movieDao.getMovie(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieDao.getMovies();
	}

	@Override
	public List<String> saveMovie(final String movieId, final Boolean visible, final String originalTitle, final String englishTitle,
			final String hungarianTitle, final String year, final String runningTime, final String directorId, final String rating, final String language,
			final String[] genresIds, final String[] actorsIds, final String imdbLink) {
		List<String> errors = validateMovieParameters(movieId, visible, originalTitle, englishTitle, hungarianTitle, year, runningTime, directorId, rating,
				language, genresIds, actorsIds, imdbLink);
		if (errors.isEmpty()) {
			long id = Long.parseLong(movieId);
			Integer runningTimeInt = Integer.parseInt(runningTime);
			Celebrity director = new Celebrity(Long.parseLong(directorId));
			Integer ratingInt = Integer.parseInt(rating);
			List<Genre> genres = getGenresListToSave(genresIds);
			List<Celebrity> actors = getActorsListToSave(actorsIds);
			saveMovie(id, visible, originalTitle, englishTitle, hungarianTitle, year, runningTimeInt, director, ratingInt, language, genres, actors, imdbLink);
		}
		return errors;
	}

	private List<String> validateMovieParameters(final String movieId, final Boolean visible, final String originalTitle, final String englishTitle,
			final String hungarianTitle, final String year, final String runningTime, final String directorId, final String rating, final String language,
			final String[] genresIds, final String[] actorsIds, final String imdbLink) {
		List<String> errors = new ArrayList<>();
		// TODO validateMovieParameters
		return errors;
	}

	@Override
	public void saveMovie(final long id, final Boolean visible, final String originalTitle, final String englishTitle, final String hungarianTitle,
			final String year, final Integer runningTime, final Celebrity director, final Integer rating, final String language, final List<Genre> genres,
			final List<Celebrity> actors, final String imdbLink) {
		Movie movie = new Movie(id, visible, originalTitle, englishTitle, hungarianTitle, year, runningTime, director, rating, language, genres, actors,
				imdbLink);
		movieDao.saveMovie(movie);
	}

	private List<Genre> getGenresListToSave(final String[] genresIds) {
		List<Genre> genres = new ArrayList<>(genresIds.length);
		for (String actorId : genresIds) {
			long id = Long.parseLong(actorId);
			genres.add(new Genre(id));
		}
		return genres;
	}

	private List<Celebrity> getActorsListToSave(final String[] actorsIds) {
		List<Celebrity> actors = new ArrayList<>(actorsIds.length);
		for (String actorId : actorsIds) {
			long id = Long.parseLong(actorId);
			actors.add(new Celebrity(id));
		}
		return actors;
	}
}
