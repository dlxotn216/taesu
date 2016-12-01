package com.mustache.webservice.admin.movie.vo;

import lombok.Data;

/**
 * Created by Neonexsoft on 2016-11-29.
 *
CREATE TABLE `movie_link` (
`MOVIE_LINK_ID` INT(11) NOT NULL AUTO_INCREMENT,
`MOVIE_ID` INT(11) NOT NULL,
`MOVIE_URL` VARCHAR(255) NOT NULL,
PRIMARY KEY (`MOVIE_LINK_ID`),
INDEX `FK_movie_link_movie` (`MOVIE_ID`),
CONSTRAINT `FK_movie_link_movie` FOREIGN KEY (`MOVIE_ID`) REFERENCES `movie` (`MOVIE_ID`) ON DELETE CASCADE
)
 */
@Data
public class MovieLink {
	private Integer movieLinkId;
	private Integer movieId;
	private String movieUrl;
}
