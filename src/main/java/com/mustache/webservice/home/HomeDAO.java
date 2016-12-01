package com.mustache.webservice.home;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Neonexsoft on 2016-11-28.
 */
@Mapper
public interface HomeDAO {
	String getCurrentDateTime();
}
