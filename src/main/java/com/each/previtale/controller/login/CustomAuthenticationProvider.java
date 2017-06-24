/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.controller.login;

import com.each.previtale.config.Properties;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 *
 * @author victorluni
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final String LOG_PREFIX = "[CUSTOM-AUTHENTICATION-PROVIDER]";

    private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    Properties properties;

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {

        String user = a.getName();
        String pass = a.getCredentials().toString();

        log.debug(LOG_PREFIX + "[USERNAME]-[{}]", user);

        if (user == null || pass == null || pass.equals("")) {
            throw new BadCredentialsException("invalid login or password");
        }
//        if (loginService.sktLoginService(user, pass).is2xxSuccessful()) {
        if (1 == 1) {

            List<GrantedAuthority> granted = new ArrayList<>();

            granted.add(new SimpleGrantedAuthority("1"));

            return new UsernamePasswordAuthenticationToken(user, pass, granted);
        } else {
            log.error(LOG_PREFIX + "[MESSAGE]-[{}]", "Fail in authentication");
            throw new BadCredentialsException("Fail in authentication");
        }

    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
}
