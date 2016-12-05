package com.mustache.webservice.admin.movie;

import com.google.common.base.Strings;
import com.mustache.webservice.admin.fb.FBService;
import com.mustache.webservice.admin.movie.vo.MovieLink;
import com.mustache.webservice.admin.movie.vo.MovieSelect;
import com.mustache.webservice.intro.IntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
	private IntroService introService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private FBService fbService;

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String movie(Model model) {

		return "redirect:list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String movieList(Model model) {
		model.addAttribute("movie", movieService.selectAllMovie());
		model.addAttribute("DOMAIN", introService.selectIntroDomain());
		return "admin/movie/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String movieAdd(Model model) {
		model.addAttribute("FB", fbService.selectAllFBAccount());
		return "admin/movie/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String movieAddProcess(Model model, @ModelAttribute MovieSelect movie, Principal principal) {
		System.out.println("DEBUG : MOVIE ADD PROCESS : " +  movie.getMovieName() + " // " + movie.getLinks().length);
//http://chomman.github.io/blog/spring%20framework/spring-security%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%98%EC%97%AC-%EC%82%AC%EC%9A%A9%EC%9E%90%EC%9D%98-%EC%A0%95%EB%B3%B4%EB%A5%BC-%EC%B0%BE%EB%8A%94-%EB%B0%A9%EB%B2%95/
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("[DEBUG] : SESSION NAME : " + user.getUsername());
		movie.setRegUserId(user.getUsername());
		Integer createdMovieId = movieService.insertMovie(movie);

		if( createdMovieId != null ){
			System.out.println("DEBUG : INSERT SUCCESS ? " + createdMovieId);
			List<MovieLink> insertLinks = new ArrayList<>();
			if( movie.getLinks() != null ){
				String [] movieLinks = movie.getLinks();
				for( int i = 0; i < movie.getLinks().length; i += 1 ){
					String currentMovieLink = movieLinks[i];
					if( !Strings.isNullOrEmpty(currentMovieLink) ){
						MovieLink link = new MovieLink();
									link.setMovieId(createdMovieId);
									link.setMovieUrl(currentMovieLink);
						insertLinks.add(link);
					}
				}
				movieService.insertMovieLink(insertLinks);
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
			model.addAttribute("FB", fbService.selectAllFBAccount());
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
			movieService.deleteMovieLinkByMovieId(movieId);

			String [] movieLink = movie.getLinks();
			List<MovieLink> insertLink = new ArrayList<>();
			if( movieLink != null ){
				for( int i = 0; i < movieLink.length; i += 1 ){
					String currentLink = movieLink[i];
					if( !Strings.isNullOrEmpty(currentLink) ){
						MovieLink link  = new MovieLink();
								link.setMovieId(movieId);
								link.setMovieUrl(currentLink);
						insertLink.add(link);
					}
				}
				movieService.insertMovieLink(insertLink);
			}
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
