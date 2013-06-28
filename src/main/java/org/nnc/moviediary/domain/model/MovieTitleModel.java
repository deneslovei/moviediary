package org.nnc.moviediary.domain.model;

public class MovieTitleModel {
	private String id;
	private String title;

	public MovieTitleModel(final String id, final String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

}
