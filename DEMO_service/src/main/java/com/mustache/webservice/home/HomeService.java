package com.mustache.webservice.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Neonexsoft on 2016-11-28.
 */
@Service
public class HomeService {

	@Autowired
	private HomeDAO homeDAO;

	public String getCurrentDateTime(){
		return homeDAO.getCurrentDateTime();
	}

}
