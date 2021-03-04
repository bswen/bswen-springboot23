package com.bswen.app9.customsecurity;

import com.bswen.app9.utils.SystemUtils;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String url = "home_user";
        if(SystemUtils.isRoleAdmin(authentication)) {
            url = "home_admin";
        }
        if (response.isCommitted()) {
            logger.debug(
                    "Response has already been committed. Unable to redirect to "
                            + url);
            return;
        }
        redirectStrategy.sendRedirect(request, response, url);

    }
}
