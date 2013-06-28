package org.nnc.moviediary.domain.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@ManyToOne(fetch = FetchType.LAZY)
	private Celebrity director;

	@Column(name = "rating")
	private Integer rating;

	@Column(name = "language", nullable = false)
	private String language;

	@ManyToMany(mappedBy = "movies")
	private List<Genre> genres;

	@ManyToMany(mappedBy = "featuredIn")
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

	public Movie(final long id) {
		super(id);
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(final String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getEnglishTitle() {
		return englishTitle;
	}

	public void setEnglishTitle(final String englishTitle) {
		this.englishTitle = englishTitle;
	}

	public String getHungarianTitle() {
		return hungarianTitle;
	}

	public void setHungarianTitle(final String hungarianTitle) {
		this.hungarianTitle = hungarianTitle;
	}

	public String getYear() {
		return year;
	}

	public void setYear(final String year) {
		this.year = year;
	}

	public Integer getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(final Integer runningTime) {
		this.runningTime = runningTime;
	}

	public Celebrity getDirector() {
		return director;
	}

	public void setDirector(final Celebrity director) {
		this.director = director;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(final Integer rating) {
		this.rating = rating;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(final String language) {
		this.language = language;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(final List<Genre> genres) {
		this.genres = genres;
	}

	public List<Celebrity> getActors() {
		return actors;
	}

	public void setActors(final List<Celebrity> actors) {
		this.actors = actors;
	}

	public String getImdbLink() {
		return imdbLink;
	}

	public void setImdbLink(final String imdbLink) {
		this.imdbLink = imdbLink;
	}
}
