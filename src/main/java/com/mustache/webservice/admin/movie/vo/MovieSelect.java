package com.mustache.webservice.admin.movie.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by kim on 2016-11-28.
CREATE TABLE `movie` (
`MOVIE_ID` INT(11) NOT NULL AUTO_INCREMENT,
`FB_ACCOUNT_ID` INT(11) NOT NULL DEFAULT '0',
`REG_USER_ID` INT(11) NOT NULL DEFAULT '0',
`MOVIE_NAME` VARCHAR(50) NOT NULL,
`REG_DATE` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`MOVIE_ID`)
)
 */
@Data
public class MovieSelect {
	private Integer movieId;
	private Integer fbAccountId;
	private String regUserId;
	private String movieName;
	private Timestamp regDate;

	private String regUserName;
	private Integer visitCount;
	private String [] links;
}