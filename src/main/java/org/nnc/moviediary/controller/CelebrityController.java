package org.nnc.moviediary.controller;

import java.util.List;

import org.nnc.moviediary.domain.entities.Celebrity;
import org.nnc.moviediary.service.interfaces.CelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CelebrityController {

	@Autowired
	private CelebrityService celebrityService;

	@RequestMapping(value = "/celebrities", method = RequestMethod.GET)
	public String getCelebrities(final Model model) {
		List<Celebrity> celebrities = celebrityService.getAllCelebrities();
		model.addAttribute("celebrities", celebrities);
		return "celebrities";
	}

	@RequestMapping(value = "/add-celebrity", method = RequestMethod.GET)
	public String addCelebrity() {
		return "addCelebrity";
	}

	@RequestMapping(value = "/save-celebrity", method = RequestMethod.POST)
	public String saveCelebrity(final Model model, @RequestParam("celebrityId") final String celebrityId, @RequestParam(value = "visible", defaultValue = "false") final Boolean visible,
			@RequestParam("name") final String name, @RequestParam("imdbLink") final String imdbLink,
			@RequestParam(value = "featuredInIds", required = false) final String[] featuredInIds,
			@RequestParam(value = "directedMoviesIds", required = false) final String[] directedMoviesIds) {
		List<String> errors = celebrityService.saveCelebrity(celebrityId, visible, name, imdbLink, featuredInIds, directedMoviesIds);
		if (errors.isEmpty()) {
			return "redirect:/celebrities";
		} else {
			model.addAttribute("errors", errors);
			return "/add-celebrity";
		}
	}
}
