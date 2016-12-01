package com.mustache.webservice.authority;

import com.mustache.webservice.authority.vo.AuthorityForSelect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by kim on 2016-11-30.
 */
@Mapper
public interface AuthorityDao {
    List<AuthorityForSelect> readAccountAuthById(String userId);
    List<AuthorityForSelect> readAuthorities();
}
