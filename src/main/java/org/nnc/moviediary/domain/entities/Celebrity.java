package org.nnc.moviediary.domain.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.nnc.moviediary.util.BaseProperties;

@Entity(name = Celebrity.TABLE_NAME)
public class Celebrity extends BaseEntity {
	private static final long serialVersionUID = 5371222233211288836L;

	public static final String TABLE_NAME = BaseProperties.TABLE_PREFIX + "celebrity";

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "imdb_link")
	private String imdbLink;

	@ManyToMany(mappedBy = "actors")
	private List<Movie> featuredIn;

	@OneToMany(mappedBy = "director")
	private List<Movie> directedMovies;

	Celebrity() {
	}

	public Celebrity(final long id) {
		super(id);
	}

	public Celebrity(final long id, final Boolean visible, final String name, final String imdbLink, final List<Movie> featuredIn,
			final List<Movie> directedMovies) {
		super(id, visible);
		this.name = name;
		this.imdbLink = imdbLink;
		this.featuredIn = featuredIn;
		this.directedMovies = directedMovies;
	}

}
