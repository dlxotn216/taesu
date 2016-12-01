package com.mustache.webservice.security;

import com.mustache.webservice.account.AccountService;
import com.mustache.webservice.authority.AuthorityService;
import com.mustache.webservice.authority.vo.AuthorityForSelect;
import com.mustache.webservice.account.vo.AccountForSecurity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kim on 2016-11-29.
 */

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;


    private static Logger log = LoggerFactory.getLogger(CustomUserDetailService.class);

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        AccountForSecurity userInfo = accountService.readAccountForSecurity(username);

        if(userInfo == null){
            log.error("user not found");
            throw new UsernameNotFoundException("user not found");
        }

        log.info("get User success : "+userInfo.getUserId());

        List<GrantedAuthority> authorities = getUserRoles(username);

        return new User(userInfo.getUserId(), userInfo.getPasswd(),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> getUserRoles(String username){
        List<GrantedAuthority> results = new ArrayList<>(0);
        List<AuthorityForSelect> userAuths = authorityService.readAccountAuthById(username);

        for(AuthorityForSelect au : userAuths){
            results.add(new SimpleGrantedAuthority(au.getAuthName()));
        }
        return results;
    }


}
