package com.mustache.webservice.admin.movie;

import com.mustache.webservice.admin.movie.vo.MovieLink;
import com.mustache.webservice.admin.movie.vo.MovieSelect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Neonexsoft on 2016-11-29.
 */
@Mapper
public interface MovieDAO {
	Integer insertMovie(MovieSelect movie);
	List<MovieSelect> selectAllMovie();
	MovieSelect selectMovieByMovieId(Integer movieId);
	void updateMovie(MovieSelect movie);
	void deleteMovie(Integer movieId);

	void insertMovieLink(List<MovieLink> movieLink);
	List<MovieLink> selectMovieLinkByMovieId(Integer movieId);

	Integer selectMovieVisitCountTodayByMovieId(Integer movieId);
}
