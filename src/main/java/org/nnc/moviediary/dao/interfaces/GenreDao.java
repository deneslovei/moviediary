package org.nnc.moviediary.dao.interfaces;

import java.util.List;

import org.nnc.moviediary.domain.entities.Genre;

public interface GenreDao {
	void saveGenre(Genre genre);

	void updateGenre(Genre genre);

	List<Genre> getAllGenres();

	Genre getGenreById(long id);
}
