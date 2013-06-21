package org.nnc.moviediary.domain.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.nnc.moviediary.util.BaseProperties;

@Entity(name = Genre.TABLE_NAME)
public class Genre extends BaseEntity {

	private static final long serialVersionUID = 4828737380556988762L;

	public static final String TABLE_NAME = BaseProperties.TABLE_PREFIX + "genre";

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToMany
	private List<Movie> movies;

	public Genre() {
	}

	public Genre(final long id) {
		super(id);
	}

	public Genre(final long id, final Boolean visible, final String name, final String description, final List<Movie> movies) {
		super(id, visible);
		this.name = name;
		this.description = description;
		this.movies = movies;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(final List<Movie> movies) {
		this.movies = movies;
	}
}
