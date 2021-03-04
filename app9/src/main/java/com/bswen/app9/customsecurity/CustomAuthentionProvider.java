package com.bswen.app9.customsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomAuthentionProvider implements AuthenticationProvider {
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SCryptPasswordEncoder sCryptPasswordEncoder;

//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = String.valueOf(authentication.getCredentials());
//
//        if("bswen".equals(username)&&"12345".equals(password)) {
//            return new UsernamePasswordAuthenticationToken(username,password, Arrays.asList());
//        }else {
//            throw new AuthenticationCredentialsNotFoundException("not valid password");
//        }
//    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        CustomUserDetails user = (CustomUserDetails)userDetailsService.loadUserByUsername(username);
        switch (user.getUser().getAlgorithm()) {
            case BCRYPT:
                return checkPassword(user,password,bCryptPasswordEncoder);
            case SCRYPT:
                return checkPassword(user,password,sCryptPasswordEncoder);
        }
        throw new BadCredentialsException("bad creds");
    }

    private Authentication checkPassword(CustomUserDetails user, String rawpassword, PasswordEncoder passwordEncoder) {
        if(passwordEncoder.matches(rawpassword,user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),user.getAuthorities());
        }else {
            throw new BadCredentialsException("bad credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
