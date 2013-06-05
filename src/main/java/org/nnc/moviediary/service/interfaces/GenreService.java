package org.nnc.moviediary.service.interfaces;

import java.util.List;

public interface GenreService {

	List<String> saveGenre(String genreId, Boolean visible, Boolean name, Boolean description, String[] moviesIds);

}
