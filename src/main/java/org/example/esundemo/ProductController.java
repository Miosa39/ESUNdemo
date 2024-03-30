package org.example.esundemo;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.esundemo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@Controller
public class ProductController {
    @Autowired
    ProductService service;

    @Autowired
    User user;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("eventName", "FIFA 2018");
        return "index";
    }
    @GetMapping("/register")
    public String register(){
        user = new User();
        user.setUserName("test");
        user.setPhoneNumber(String.valueOf(123456789));
        user.setPassword(String.valueOf(123));
        service.registerUser(user);
        return "index";
    }
    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    public String Login(Authentication authentication){
        //System.out.printf(authentication.name());
        user = new User();
        user.setPhoneNumber(String.valueOf(123456789));
        user.setPassword(String.valueOf(123));
        service.login(user);
        return "index";
    }
}
