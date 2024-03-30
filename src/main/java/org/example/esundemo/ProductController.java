package org.example.esundemo;

import org.example.esundemo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping("/newUser")
    public String newUser(){
        user = new User();
        user.setUserName("test");
        user.setPhoneNumber(String.valueOf(123456789));
        user.setPassword(String.valueOf(123));
        service.registerUser(user);
        return "index";
    }
}
