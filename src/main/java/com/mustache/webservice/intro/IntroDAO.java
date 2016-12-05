package com.mustache.webservice.intro;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Neonexsoft on 2016-12-02.
 */
@Mapper
public interface IntroDAO {
	String selectIntroDomain();
}
