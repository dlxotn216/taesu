package com.mustache.webservice.admin.fb;

import com.mustache.webservice.admin.fb.vo.FBSelect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Neonexsoft on 2016-12-01.
 */
@Mapper
public interface FBDAO {
	void insertFBAccount(FBSelect fbAccount);
	List<FBSelect> selectAllFBAccount();
	FBSelect selectFBAccountByFBAccountId(Integer fbAccountId);
	void updateFBAccount(FBSelect fbAccount);
	void deleteFBAccountByFBAccountId(Integer fbAccountId);
}
