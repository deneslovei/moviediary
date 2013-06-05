package org.nnc.moviediary.service.interfaces;

import java.util.List;

import org.nnc.moviediary.domain.entities.Celebrity;
import org.nnc.moviediary.domain.entities.Genre;
import org.nnc.moviediary.domain.entities.Movie;

public interface MovieService {

	Movie getMovie(long id);

	List<Movie> getAllMovies();

	List<String> saveMovie(String movieId, Boolean visible, String originalTitle, String englishTitle, String hungarianTitle, String year, String runningTime,
			String directorId, String rating, String language, String[] genresIds, String[] actorsIds, String imdbLink);

	void saveMovie(long id, Boolean visible, String originalTitle, String englishTitle, String hungarianTitle, String year, Integer runningTime,
			Celebrity director, Integer rating, String language, List<Genre> genres, List<Celebrity> actors, String imdbLink);
}
