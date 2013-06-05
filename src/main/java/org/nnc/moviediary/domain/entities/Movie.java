package org.nnc.moviediary.domain.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.nnc.moviediary.util.BaseProperties;

@Entity(name = Movie.TABLE_NAME)
public class Movie extends BaseEntity {
	private static final long serialVersionUID = 5551932695338051710L;

	public static final String TABLE_NAME = BaseProperties.TABLE_PREFIX + "movie";

	@Column(name = "original_title", nullable = false)
	private String originalTitle;

	@Column(name = "english_title")
	private String englishTitle;

	@Column(name = "hungarian_title")
	private String hungarianTitle;

	@Column(name = "year", nullable = false, length = 4)
	private String year;

	@Column(name = "running_time", nullable = false)
	private Integer runningTime;

	@ManyToOne
	private Celebrity director;

	@Column(name = "rating")
	private Integer rating;

	@Column(name = "language", nullable = false)
	private String language;

	@ManyToMany
	private List<Genre> genres;

	@ManyToMany
	private List<Celebrity> actors;

	@Column(name = "imdb_link")
	private String imdbLink;

	public Movie() {
	}

	public Movie(final long id, final Boolean visible, final String originalTitle, final String englishTitle, final String hungarianTitle, final String year,
			final Integer runningTime, final Celebrity director, final Integer rating, final String language, final List<Genre> genres,
			final List<Celebrity> actors, final String imdbLink) {
		super(id, visible);
		this.originalTitle = originalTitle;
		this.englishTitle = englishTitle;
		this.hungarianTitle = hungarianTitle;
		this.year = year;
		this.runningTime = runningTime;
		this.director = director;
		this.rating = rating;
		this.language = language;
		this.genres = genres;
		this.actors = actors;
		this.imdbLink = imdbLink;
	}
}
