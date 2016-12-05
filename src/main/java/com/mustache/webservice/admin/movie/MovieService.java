package com.mustache.webservice.admin.movie;

import com.mustache.webservice.admin.movie.vo.MovieLink;
import com.mustache.webservice.admin.movie.vo.MovieSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Neonexsoft on 2016-11-29.
 */
@Service
public class MovieService implements MovieDAO {

	@Autowired
	private MovieDAO movieDAO;

	@Override
	public Integer insertMovie(MovieSelect movie) {
		movieDAO.insertMovie(movie);
		return movie.getMovieId();
	}

	@Override
	public List<MovieSelect> selectAllMovie() {
		return movieDAO.selectAllMovie();
	}

	@Override
	public void updateMovie(MovieSelect movie) {
		movieDAO.updateMovie(movie);
	}

	@Override
	public void deleteMovie(Integer movieId) {
		movieDAO.deleteMovie(movieId);
	}

	@Override
	public void insertMovieLink(List<MovieLink> movieLink) {
		movieDAO.insertMovieLink(movieLink);
	}

	@Override
	public List<MovieLink> selectMovieLinkByMovieId(Integer movieId) {
		return movieDAO.selectMovieLinkByMovieId(movieId);
	}

	@Override
	public MovieSelect selectMovieByMovieId(Integer movieId) {
		return movieDAO.selectMovieByMovieId(movieId);
	}

	@Override
	public Integer selectMovieVisitCountTodayByMovieId(Integer movieId) {
		return movieDAO.selectMovieVisitCountTodayByMovieId(movieId);
	}

	@Override
	public void deleteMovieLinkByMovieId(Integer movieId) {
		movieDAO.deleteMovieLinkByMovieId(movieId);
	}
}
