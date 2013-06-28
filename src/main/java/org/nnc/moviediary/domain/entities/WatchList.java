package org.nnc.moviediary.domain.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.nnc.moviediary.util.BaseProperties;

@Entity(name = WatchList.TABLE_NAME)
public class WatchList extends BaseEntity {
	private static final long serialVersionUID = 5955810968304546718L;

	public static final String TABLE_NAME = BaseProperties.TABLE_PREFIX + "watch_list";

	private Integer lineNumber;

	private Boolean isPublic;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne
	private Watcher watcher;

	@ManyToMany
	@JoinTable(name = BaseProperties.JOIN_TABLE_PREFIX + WatchList.TABLE_NAME + "_" + Movie.TABLE_NAME)
	private List<Movie> movies;

	WatchList() {
	}

	public WatchList(final Integer lineNumber, final Boolean isPublic, final String name, final String description,
			final Watcher watcher, final List<Movie> movies) {
		this.isPublic = isPublic;
		this.lineNumber = lineNumber;
		this.name = name;
		this.description = description;
		this.watcher = watcher;
		this.movies = movies;
	}

	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(final Integer lineNumber) {
		this.lineNumber = lineNumber;
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

	public Watcher getWatcher() {
		return watcher;
	}

	public void setWatcher(final Watcher watcher) {
		this.watcher = watcher;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(final List<Movie> movies) {
		this.movies = movies;
	}

	public Boolean isPublic() {
		return isPublic;
	}

	public void setIsPublic(final Boolean isPublic) {
		this.isPublic = isPublic;
	}
}
