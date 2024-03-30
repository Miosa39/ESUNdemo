package org.example.esundemo;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.esundemo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    ProductService service;

    @Autowired
    User user;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/bookList")
    public  String bookList(@RequestBody String body){
        List<Map<String, Object>> bookList = service.getBookList();
        return "index";
    }
    @PostMapping("/bprrowRecord")
    public  String borrowRecord(@RequestBody String body){
        String[] spilt = body.split("&");
        List<Map<String, Object>> borrowRecordList = service.getborrowRecord(spilt[0].split("=")[1]);
        return "index";
    }
    @PostMapping("/register")
    public String register(@RequestBody String body){
        user = new User();
        String[] spilt = body.split("&");
        user.setUserName(spilt[0].split("=")[1]);
        user.setPhoneNumber(spilt[1].split("=")[1]);
        user.setPassword(spilt[2].split("=")[1]);
        service.registerUser(user);
        return "index";
    }
    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    public String Login(){
        user = new User();
        service.login(user);
        return "index";
    }

    @PostMapping("/borrow")
    public String borrow(@RequestBody String body){
        String[] spilt = body.split("&");
        service.borrow(spilt[0].split("=")[1],spilt[1].split("=")[1]);
        return "index";
    }

    @PostMapping("/return")
    public  String retu(@RequestBody String body){
        String[] spilt = body.split("&");
        service.retu(spilt[0].split("=")[1],spilt[1].split("=")[1]);
        return "index";
    }
}
