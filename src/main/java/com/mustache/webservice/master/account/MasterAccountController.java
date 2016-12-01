package com.mustache.webservice.master.account;

import com.mustache.webservice.account.AccountService;
import com.mustache.webservice.account.vo.AccountForSelect;
import com.mustache.webservice.account.vo.AccountForUpdate;
import com.mustache.webservice.authority.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kim on 2016-12-01.
 */
@Controller
@RequestMapping(value="/master")
public class MasterAccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping(value="/account", method= RequestMethod.GET)
    public List<AccountForSelect> readAccount(){
        return accountService.readAllAccount();
    }

    @RequestMapping(value="/account/list", method= RequestMethod.GET)
    public String readAllAccountPage(Model model){
        model.addAttribute("accounts", readAccount());
        return "master/account/list";
    }

    @RequestMapping(value="/account/manage/{userId}", method=RequestMethod.GET)
    public String readManageAccountPage(@PathVariable String userId, Model model){
        model.addAttribute("account", accountService.readAccountById(userId));
        model.addAttribute("authorities", authorityService.readAuthorities());
        return "master/account/manage";
    }

    @ResponseBody
    @RequestMapping(value="/account/{userId}", method=RequestMethod.PUT)
    public Object updateAccountById(@RequestBody AccountForUpdate accountForUpdate, @PathVariable String userId){
        return accountService.updateAccountById(accountForUpdate, userId)> 0 ?
                        new ResponseEntity<Object>(HttpStatus.OK)
                            : new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

    //// TODO: 2016-12-01
    //권한을 변경했을 때
    //감지할 수 있도록
    //Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    //http://stackoverflow.com/questions/9910252/how-to-reload-authorities-on-user-update-with-spring-security
    //List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());
    //updatedAuthorities.add(...); //add your role here [e.g., new SimpleGrantedAuthority("ROLE_NEW_ROLE")]

    //Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);

    //SecurityContextHolder.getContext().setAuthentication(newAuth);
    /**
     *
     * ROLE_MASTER 권한을 가진 사용자가
     * 다른 사용자의 권한정보나 허가 여부를 변경할 때
     * 호출되는 메소드
     *
     * @param accountForUpdate
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/account/user/{userId}", method=RequestMethod.PUT)
    public Object updateUserAccountById(@RequestBody AccountForUpdate accountForUpdate, @PathVariable String userId) {

        return accountService.updateAccountById(accountForUpdate, userId, true)> 0 ?
                new ResponseEntity<Object>(HttpStatus.OK)
                : new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
    @ResponseBody
    @RequestMapping(value="/account/{userId}", method=RequestMethod.DELETE)
    public Object deleteAccount(@PathVariable String userId){
        return accountService.deleteAccount(userId, true) > 0 ?
                new ResponseEntity<Object>(HttpStatus.OK)
                : new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}