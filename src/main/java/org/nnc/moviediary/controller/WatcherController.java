package org.nnc.moviediary.controller;

import javax.servlet.http.HttpServletRequest;

import org.nnc.moviediary.domain.entities.WatchList;
import org.nnc.moviediary.service.interfaces.WatcherService;
import org.nnc.moviediary.util.exceptions.RequiredParameterNotSpecifiedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class WatcherController {

	@Autowired
	private WatcherService watcherService;

	@RequestMapping(value = "/watcher/watch-list/", method = RequestMethod.GET)
	public String getAllMovie(final HttpServletRequest request, final ModelMap model) {
		String watchListId = (String) request.getAttribute("watchListId");
		try {
			final WatchList watchList = watcherService.getPublicWatchListByIdString(watchListId);
			if (watchList == null) {
				// TODO no match result
			}
			model.addAttribute("watchList", watchList);
			return "watchlist";
		} catch (RequiredParameterNotSpecifiedException e) {
			// TODO errorpage
			return "watchlist";
		}
	}

}
