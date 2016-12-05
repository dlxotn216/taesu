package com.mustache.webservice.security;

import com.mustache.webservice.account.AccountService;
import com.mustache.webservice.authority.AuthorityService;
import com.mustache.webservice.authority.vo.AuthorityForSelect;
import com.mustache.webservice.account.vo.AccountForSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kim on 2016-11-30.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String NOT_MATCHING_ANY_ID_OR_PW = "This account is not matching any id or password";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authToken =
                                            (UsernamePasswordAuthenticationToken) authentication;

        String userId = authToken.getName();
        //System.out.println("user Id : "+ userId);
        AccountForSecurity user = accountService.readAccountForSecurity(userId);
        if(user == null){
            throw new UsernameNotFoundException("This account is not matching any id or password");
        }
        //System.out.println(userId+" select success");

        //패스워드 매칭 수행
        if(!matchPasswd( authToken.getCredentials(), user.getPasswd() )){
            throw new BadCredentialsException("This account is not matching any id or password");
        }

        if(user.getPermit().toUpperCase().equals("N")){
            throw new BadCredentialsException("This account is not permitted");
        }

        List<GrantedAuthority> authorities = getUserRoles(userId);

        return new UsernamePasswordAuthenticationToken(new User(userId, user.getPasswd(), authorities), null, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private boolean matchPasswd(Object target, String origin){
        //System.out.println("match password origin : "+origin+" "+target);
        //System.out.println("match password encoded : "+passwordEncoder.encode(target.toString()));

        return passwordEncoder.matches(target.toString(), origin);
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