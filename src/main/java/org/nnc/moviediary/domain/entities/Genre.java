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

	Genre() {
	}

	public Genre(final long id) {
		super(id);
	}
}
