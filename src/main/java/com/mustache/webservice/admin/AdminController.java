package com.mustache.webservice.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kim on 2016-12-01.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value="", method= RequestMethod.GET)
    public String manageAccount(){
        System.out.println("ADMIN INDEX");
        return "admin/index";
    }


}
