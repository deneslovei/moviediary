package org.nnc.moviediary.service.interfaces;

import org.nnc.moviediary.domain.entities.WatchList;
import org.nnc.moviediary.util.exceptions.RequiredParameterNotSpecifiedException;

public interface WatcherService {

	WatchList getPublicWatchListByIdString(String watchListId) throws RequiredParameterNotSpecifiedException;

}
