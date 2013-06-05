package org.nnc.moviediary.service.implementations;

import org.nnc.moviediary.dao.interfaces.WatchListDao;
import org.nnc.moviediary.dao.interfaces.WatcherDao;
import org.nnc.moviediary.domain.entities.WatchList;
import org.nnc.moviediary.service.interfaces.WatcherService;
import org.nnc.moviediary.util.exceptions.RequiredParameterNotSpecifiedException;

public class WatcherServiceImpl implements WatcherService {
	@SuppressWarnings("unused")
	private WatcherDao watcherDao;
	private WatchListDao watchListDao;

	@Override
	public WatchList getPublicWatchListByIdString(final String watchListId)
			throws RequiredParameterNotSpecifiedException {
		if (watchListId == null || watchListId.isEmpty()) {
			throw new RequiredParameterNotSpecifiedException();
		} else {
			Long id = Long.parseLong(watchListId);
			return watchListDao.getPublicWatchListById(id);
		}
	}
}
