package org.nnc.moviediary.service.interfaces;

import java.util.List;

import org.nnc.moviediary.domain.entities.Genre;

public interface GenreService {

	List<Genre> getAllGenres();

	Genre getGenreById(String genreId);

	List<String> saveGenre(Boolean visible, String name, String description, String[] moviesIds);

	List<String> updateGenre(String genreId, Boolean visible, String name, String description, String[] moviesIds);

}
