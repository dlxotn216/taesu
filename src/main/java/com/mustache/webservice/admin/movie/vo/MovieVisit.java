package com.mustache.webservice.admin.movie.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by Neonexsoft on 2016-11-29.
CREATE TABLE `movie_visit` (
`MOVIE_ID` INT(11) NOT NULL,
`VISIT_ID` VARCHAR(50) NOT NULL,
`VISIT_DATE` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
INDEX `FK_movie_visit_movie` (`MOVIE_ID`),
CONSTRAINT `FK_movie_visit_movie` FOREIGN KEY (`MOVIE_ID`) REFERENCES `movie` (`MOVIE_ID`) ON DELETE CASCADE
)
 */
@Data
public class MovieVisit {
	private Integer movieId;
	private String visitId;
	private Timestamp visitDate;
}
