package com.mustache.webservice.admin.movie;

import com.mustache.webservice.admin.movie.vo.MovieLink;
import com.mustache.webservice.admin.movie.vo.MovieSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kim on 2016-11-28.
 */
@Controller
@RequestMapping("/admin/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String movie(Model model) {

		return "redirect:list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String movieList(Model model) {
		model.addAttribute("movie", movieService.selectAllMovie());
		return "admin/movie/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String movieAdd(Model model) {
		// TODO GET FB
		return "admin/movie/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded")
	public String movieAddProcess(Model model,
								  @RequestParam String movieName,
								  @RequestParam String [] movieLink
	) {
		System.out.println("DEBUG : MOVIE ADD PROCESS : " +  movieName + " // " + movieLink.length);
		MovieSelect movie = new MovieSelect();
					movie.setMovieName(movieName);
					movie.setRegUserId(1);
		Integer createdMovieId = movieService.insertMovie(movie);

		if( createdMovieId != null ){
			System.out.println("DEBUG : INSERT SUCCESS ? " + createdMovieId);
			List<MovieLink> movieLinks = new ArrayList<>();
			if( movieLink != null ){
				for( int i = 0; i < movieLink.length; i += 1 ){
					MovieLink link = new MovieLink();
						link.setMovieId(createdMovieId);
						link.setMovieUrl(movieLink[i]);
					movieLinks.add(link);
				}
				movieService.insertMovieLink(movieLinks);
			}
		}
		return "redirect:list";
	}


	@RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
	public String movieDetail(@PathVariable Integer movieId, Model model) {
		// Valid movieId check
		MovieSelect movie = movieService.selectMovieByMovieId(movieId);
		if( movie == null ){
			return "admin/movie/empty";
		} else {
			model.addAttribute("MOVIE", movie);
			model.addAttribute("MOVIE_LINK", movieService.selectMovieLinkByMovieId(movie.getMovieId()));
			return "admin/movie/detail";
		}
	}

	@RequestMapping(value = "/{movieId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object movieUpdate(@PathVariable Integer movieId, @RequestBody MovieSelect movie, Model model) {
		Map<String, Object> response = new HashMap<>();
		if( movie != null ){
			movieService.updateMovie(movie);
		}
		response.put("STATUS", "200");
		return response;
	}

	@RequestMapping(value = "/{movieId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object movieDelete(@PathVariable Integer movieId, Model model) {
		movieService.deleteMovie(movieId);
		Map<String, Object> response = new HashMap<>();
		response.put("STATUS", "200");
		return response;
	}

	@RequestMapping(value = "/{movieId}/visit/today/count", method = RequestMethod.GET)
	@ResponseBody
	public Object movieVisitCount(@PathVariable Integer movieId, Model model) {
		Integer count = movieService.selectMovieVisitCountTodayByMovieId(movieId);
		if( count == null ){
			count = 0;
		}
		return count;
	}
}
