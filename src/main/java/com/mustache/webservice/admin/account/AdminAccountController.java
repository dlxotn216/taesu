package com.mustache.webservice.admin.account;

import com.mustache.webservice.account.AccountService;
import com.mustache.webservice.account.vo.AccountForUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kim on 2016-12-01.
 */
@Controller
@RequestMapping("/admin")
public class AdminAccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/account/{userId}", method=RequestMethod.GET)
    public Object readAccountById(@PathVariable String userId){
        return accountService.readAccountById(userId);
    }

    @RequestMapping(value="/account/manage/{userId}", method=RequestMethod.GET)
    public String readAccountView(@PathVariable String userId, Model model){
        model.addAttribute("account", readAccountById(userId));

        return "account/manage";
    }

    @ResponseBody
    @RequestMapping(value="/account/{userId}", method=RequestMethod.PUT)
    public Object updateAccountById(@RequestBody AccountForUpdate accountForUpdate, @PathVariable String userId){
        return accountService.updateAccountById(accountForUpdate, userId)> 0 ?
                new ResponseEntity<Object>(HttpStatus.OK)
                : new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @RequestMapping(value="/account/{userId}", method=RequestMethod.DELETE)
    public Object deleteAccountById(@PathVariable String userId){
        return accountService.deleteAccount(userId) > 0 ?
                new ResponseEntity<Object>(HttpStatus.OK)
                : new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

}
