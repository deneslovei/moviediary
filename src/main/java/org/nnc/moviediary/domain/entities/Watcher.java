package org.nnc.moviediary.domain.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.nnc.moviediary.util.BaseProperties;

@Entity(name = Watcher.TABLE_NAME)
public class Watcher extends BaseEntity {
	private static final long serialVersionUID = -4385685818553240613L;

	public static final String TABLE_NAME = BaseProperties.TABLE_PREFIX + "watcher";

	@Column(name = "user", nullable = false, unique = true)
	private User user;

	@OneToMany(mappedBy = "watcher")
	private List<WatchList> watchLists;

	private WatchList favorits;

	Watcher() {
	}

	public Watcher(final User user, final List<WatchList> watchLists, final WatchList favorits) {
		this.user = user;
		this.watchLists = watchLists;
		this.favorits = favorits;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public List<WatchList> getWatchLists() {
		return watchLists;
	}

	public void setWatchLists(final List<WatchList> watchLists) {
		this.watchLists = watchLists;
	}

	public WatchList getFavorits() {
		return favorits;
	}

	public void setFavorits(final WatchList favorits) {
		this.favorits = favorits;
	}
}
