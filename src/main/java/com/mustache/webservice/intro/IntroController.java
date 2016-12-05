package com.mustache.webservice.intro;

import com.mustache.webservice.admin.fb.FBService;
import com.mustache.webservice.admin.fb.vo.FBSelect;
import com.mustache.webservice.admin.movie.MovieService;
import com.mustache.webservice.admin.movie.vo.MovieSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Neonexsoft on 2016-12-02.
 */
@RequestMapping(value = "/intro")
@Controller
public class IntroController {
	@Autowired
	private FBService fbService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private IntroService introService;

	@RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
	public String introduction(Model model, @PathVariable Integer movieId) {

		MovieSelect movie = movieService.selectMovieByMovieId(movieId);

		model.addAttribute("DOMAIN", introService.selectIntroDomain());
		model.addAttribute("MOVIE", movie);
		model.addAttribute("MOVIE_LINK", movieService.selectMovieLinkByMovieId(movieId));
		model.addAttribute("FB", fbService.selectFBAccountByFBAccountId(movie.getFbAccountId()));
		return "intro/main";
	}
}
