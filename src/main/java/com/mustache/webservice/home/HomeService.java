package com.mustache.webservice.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Neonexsoft on 2016-11-28.
 */
@Service
public class HomeService implements HomeDAO{

	@Autowired
	private HomeDAO homeDAO;

	@Override
	public String getCurrentDateTime(){
		return homeDAO.getCurrentDateTime();
	}
}
