/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.controller.login;

import com.each.previtale.config.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author victorluni
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final String LOG_PREFIX = "[CUSTOM-AUTHENTICATION-PROVIDER]";

    private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    Properties properties;

    @Autowired
    private HttpSession httpSession;

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
//
//        String user = a.getName();
//        String pass = a.getCredentials().toString();
//
//        log.info(LOG_PREFIX + "[USERNAME]-[{}]", user);
//
//        if (user == null || pass == null || pass.equals("")) {
//            throw new BadCredentialsException("invalid login or password");
//        }
//
//        User userLogin = userRepository.findByRg(Integer.parseInt(user));
//        Aluno aluno = null;
//
//        if(userLogin.getEAluno() == 1){
//            aluno = alunoRepository.findByUser(userLogin);
//            httpSession.setAttribute("aluno", aluno);
//        }
//
//        if (userLogin != null) {
//            List<GrantedAuthority> granted = new ArrayList<>();
//            granted.add(new SimpleGrantedAuthority("1"));
//
//            httpSession.setAttribute("userlogged", userLogin);
//
//            return new UsernamePasswordAuthenticationToken(user, pass, granted);
//        } else {
//            log.error(LOG_PREFIX + "[MESSAGE]-[{}]", "Fail in authentication");
//            throw new BadCredentialsException("Fail in authentication");
//        }
        throw new BadCredentialsException("Fail in authentication");
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
}
