package com.mustache.webservice.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Neonexsoft on 2016-11-28.
 */
@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	@RequestMapping("/")
	public String index(Model model) {
		System.out.println("DEBUG : INDEX");
		//model.addAttribute("CURRENT_TIME", homeService.getCurrentDateTime());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model) {

		return "main";
	}
}
