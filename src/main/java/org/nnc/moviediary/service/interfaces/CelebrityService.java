package org.nnc.moviediary.service.interfaces;

import java.util.List;

import org.nnc.moviediary.domain.entities.Movie;

public interface CelebrityService {

	List<String> saveCelebrity(String celebrityId, Boolean visible, String name, String imdbLink, String[] featuredInIds, String[] directedMoviesIds);

	void saveCelebrity(long id, Boolean visible, String name, String imdbLink, List<Movie> featuredIn, List<Movie> directedMovies);

}
