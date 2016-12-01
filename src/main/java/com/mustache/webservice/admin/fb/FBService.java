package com.mustache.webservice.admin.fb;

import com.mustache.webservice.admin.fb.vo.FBSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Neonexsoft on 2016-12-01.
 */
@Service
@Transactional
public class FBService implements  FBDAO {

	@Autowired
	private FBDAO fbDAO;

	@Override
	public void insertFBAccount(FBSelect fbAccount) {
		fbDAO.insertFBAccount(fbAccount);
	}

	@Override
	public List<FBSelect> selectAllFBAccount() {
		return fbDAO.selectAllFBAccount();
	}

	@Override
	public FBSelect selectFBAccountByFBAccountId(Integer fbAccountId) {
		return fbDAO.selectFBAccountByFBAccountId(fbAccountId);
	}

	@Override
	public void updateFBAccount(FBSelect fbAccount) {
		fbDAO.updateFBAccount(fbAccount);
	}

	@Override
	public void deleteFBAccountByFBAccountId(Integer fbAccountId) {
		fbDAO.deleteFBAccountByFBAccountId(fbAccountId);
	}
}
