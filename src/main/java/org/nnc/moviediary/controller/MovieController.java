package org.nnc.moviediary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nnc.moviediary.domain.entities.Movie;
import org.nnc.moviediary.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

	public static final String MOVIES_HTTP_LOCATION = "/movie/";

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/add-movie", method = RequestMethod.GET)
	public String addMovie() {
		return "addMovie";
	}

	@RequestMapping(value = "/save-movie", method = RequestMethod.POST)
	public String saveMovie(final Model model, @RequestParam("movieId") final String movieId, @RequestParam("visible") final Boolean visible,
			@RequestParam("originalTitle") final String originalTitle, @RequestParam("englishTitle") final String englishTitle,
			@RequestParam("hungarianTitle") final String hungarianTitle, @RequestParam("year") final String year,
			@RequestParam("runningTime") final String runningTime, @RequestParam("director") final String director,
			@RequestParam("imdbLink") final String imdbLink, @RequestParam("rating") final String rating, @RequestParam("language") final String language,
			@RequestParam(value = "genres", required = false) final String[] genres, @RequestParam(value = "actors", required = false) final String[] actors) {

		List<String> errors = movieService.saveMovie(movieId, visible, originalTitle, englishTitle, hungarianTitle, year, runningTime, director, rating,
				language, genres, actors, imdbLink);
		if (errors.isEmpty()) {
			return "redirect:/movies";
		} else {
			model.addAttribute("errors", errors);
			return "/add-movie";
		}
	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String getAllMovie(final ModelMap model) {
		List<Movie> movies = movieService.getAllMovies();
		model.addAttribute("movies", movies);
		return "movies";
	}

	@RequestMapping(value = MOVIES_HTTP_LOCATION + "**", method = RequestMethod.GET)
	public String getMovie(final HttpServletRequest request, final ModelMap model) {
		System.out.println(model.get("movie"));
		try {
			String movieUrl = request.getRequestURI();
			int start = movieUrl.indexOf(MOVIES_HTTP_LOCATION) + MOVIES_HTTP_LOCATION.length();
			int end = movieUrl.indexOf("/", start);
			String movieIdString = movieUrl.substring(start, end);
			Long movieId = Long.parseLong(movieIdString);
			model.addAttribute("movie", movieService.getMovie(movieId));
			return "movie";
		} catch (NumberFormatException e) {
			System.out.println("Nincs ilyen oldal.");
			return "redirect:/movies";
		}
	}
}
