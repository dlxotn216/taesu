package com.mustache.webservice.master;

import com.mustache.webservice.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by kim on 2016-12-01.
 */
@Controller
@RequestMapping(value="/master")
public class MasterController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String masterIndex(){
        System.out.println("MASTER INDEX");
        return "master/index";
    }
}
