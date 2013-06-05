package org.nnc.moviediary.dao.interfaces;

import java.util.List;

import org.nnc.moviediary.domain.entities.Movie;

public interface MovieDao {
	public List<Movie> getMovies();

	public Movie getMovie(long id);

	public void saveMovie(Movie movie);
}
