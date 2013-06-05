package org.nnc.moviediary.controller;

import java.util.List;

import org.nnc.moviediary.service.interfaces.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GenreController {

	//@Autowired
	private GenreService genreService;

	@RequestMapping(value = "/add-genre", method = RequestMethod.GET)
	public String addMovie() {
		return "addGenre";
	}

	@RequestMapping(value = "/save-genre", method = RequestMethod.POST)
	public String saveGenre(final Model model, @RequestParam("genreId") final String genreId, @RequestParam("visible") final Boolean visible,
			@RequestParam("name") final Boolean name, @RequestParam("description") final Boolean description,
			@RequestParam("moviesIds") final String[] moviesIds) {
		List<String> errors = genreService.saveGenre(genreId, visible, name, description, moviesIds);
		if (errors.isEmpty()) {
			return "redirect:genres";
		} else {
			model.addAttribute("errors", errors);
			return "/save-genre";
		}
	}
}
