package com.bswen.app9.controller;

import com.bswen.app9.config.MySettings;
import com.bswen.app9.customsecurity.ProductService;
import com.bswen.app9.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {
    @Autowired
    private MySettings mySettings;
    @Autowired
    private ProductService productService;

    @GetMapping("/hello2")
    public @ResponseBody String hello2(Authentication authentication) {
        return String.format("hello2 %s %s",
                authentication==null?"":authentication.getName(),mySettings.isMyBooleanValue());
    }

    @GetMapping("/hello")
    public String hello(Authentication authentication) {
        return "hello";
    }

    @GetMapping("/home")
    public String home(Authentication authentication) {
        return "home";
    }

//    @GetMapping("/login")
//    public String login(Authentication authentication) {
//        return "login";
//    }

    @GetMapping("/home_admin")
    public String adminHome(Authentication authentication, Model model) {
        model.addAttribute("username",authentication==null?"":authentication.getName());
        model.addAttribute("products",productService.findAll());
        return "home_admin";
    }

    @GetMapping("/home_user")
    public String userHome(Authentication authentication, Model model) {
        model.addAttribute("username",authentication==null?"":authentication.getName());
        model.addAttribute("products",productService.findAll());
        return "home_user";
    }

    @GetMapping("/")
    public String root(Authentication authentication, HttpServletResponse response) throws IOException {
        if(authentication!=null&& !StringUtils.isEmpty(authentication.getName())) {
            if(SystemUtils.isRoleAdmin(authentication)) {
                response.sendRedirect("/home_admin");
            }else {
                response.sendRedirect("/home_user");
            }
        }
        return "home";
    }
}
