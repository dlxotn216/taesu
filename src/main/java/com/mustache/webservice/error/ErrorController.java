package com.mustache.webservice.error;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;

/**
 * Created by kim on 2016-12-01.
 */
@Controller
@RequestMapping(value="/error")
public class ErrorController {
    private final String ROLE_MASTER    = "ROLE_MASTER";
    private final String ROLE_ADMIN     = "ROLE_ADMIN";
    private final String ROLE_USER      = "ROLE_USER";
    private final String ROLE_ANONYMOUS = "ROLE_ANONYMUS";

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String ERROR403(Model model){
        Iterator it
                = SecurityContextHolder.getContext().getAuthentication().getAuthorities().iterator();
        String auth = ROLE_ANONYMOUS;

        if(it.hasNext()){
            auth = it.next().toString();
        }
        String retUrl = "/";
        if(auth.equals(ROLE_ANONYMOUS)){
            retUrl = "/";
        } else if(auth.equals(ROLE_USER)){
            retUrl = "/";
        } else if(auth.equals(ROLE_ADMIN)){
            retUrl = "/admin";
        } else if(auth.equals(ROLE_MASTER)){
            retUrl = "/master";
        }
        System.out.println("DEBUG ERROR 403 "+auth+" "+retUrl);
        model.addAttribute("retUrl", retUrl);
        return "error/403";
    }

    @RequestMapping(value="/expire", method=RequestMethod.GET)
    public String expire(){
        return "error/expire";
    }
}
