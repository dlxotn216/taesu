package com.mustache.webservice.movie.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by kim on 2016-11-28.
 */
@Data
public class MovieSelect {
    private Integer movieId;
    private String movieName;
    private String movieUrl;
    private String regUserId;
    private String regUserName;
    private Timestamp regDate;
}