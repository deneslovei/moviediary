package org.nnc.moviediary.dao.interfaces;

import org.nnc.moviediary.domain.entities.WatchList;

public interface WatchListDao {

	WatchList getPublicWatchListById(Long id);
}
