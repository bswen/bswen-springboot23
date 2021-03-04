package com.bswen.app9.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class SystemUtils {
    public static boolean isRoleAdmin(Authentication authentication) {
        if(authentication==null) return false;
        for (final GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            String authorityName = grantedAuthority.getAuthority();
            if (authorityName.equals("ROLE_ADMIN")) {
                return true;
            }
        }
        return false;
    }
}
