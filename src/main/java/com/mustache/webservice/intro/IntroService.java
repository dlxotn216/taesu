package com.mustache.webservice.intro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Neonexsoft on 2016-12-02.
 */
@Service
@Transactional
public class IntroService implements IntroDAO {

	@Autowired
	private IntroDAO introDAO;

	@Override
	public String selectIntroDomain() {
		return introDAO.selectIntroDomain();
	}
}
