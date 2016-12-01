package com.mustache.webservice.account;

import com.mustache.webservice.account.vo.AccountForInsert;
import com.mustache.webservice.account.vo.AccountForUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kim on 2016-11-30.
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    private static Logger log = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(value="/account/{userId}", method=RequestMethod.GET)
    public Object readAccountById(@PathVariable String userId){
        return accountService.readAccountById(userId);
    }

    @RequestMapping(value="/account/create", method= RequestMethod.GET)
    public String readAccountView(){
        return "account/create";
    }

    @ResponseBody
    @RequestMapping(value="/account", method= RequestMethod.POST)
    public Object createAccount(@RequestBody AccountForInsert account){
        System.out.println(account.getPasswd());
        System.out.println(account.getUserName());
        System.out.println(account.getUserEmail());

        accountService.createAccount(account);
        log.info("create account finished");

        return new ResponseEntity<Object>(HttpStatus.OK);
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
