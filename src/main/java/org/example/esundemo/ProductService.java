package org.example.esundemo;

import org.example.esundemo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.example.esundemo.SecureUtils.getSalt;
import static org.example.esundemo.SecureUtils.getSecurePassword;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;
    public void registerUser(User user){
        try {
            byte[] salt = getSalt();
            user.setPassword(getSecurePassword(user.getPassword(),salt));
            user.setSalt(Arrays.toString(salt));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        repository.register(user);
    }
    public void login(User user){
        System.out.printf(String.valueOf(repository.findAccountByUsername(user).get(0).get("password")));
        //檢查帳號是否存在
        //salt加密
        //比對密碼
        //取得資料
        //更新資料
    }
    public void borrow(String Book_ID,String User_ID){
        if(repository.checkbook(Book_ID)==null){
            return;//檢查書本是否存在
        }
        if (repository.checkbook(Book_ID).get(0).get("Status") == "on loan") {
            return;//檢查書本是否出借中
        }
        repository.borrow(Book_ID,User_ID);
    }

    public void retu(String Book_ID,String User_ID){
        System.out.printf(Book_ID+User_ID+"\n");
        if(repository.checkbook(Book_ID)==null){
            return;//檢查書本是否存在
        }
        if (repository.checkbook(Book_ID).get(0).get("Status") != "on loan") {
           return;//檢查書本是否出借中
        }
        System.out.printf(Book_ID+User_ID+"\n");
        repository.retu(Book_ID,User_ID);
    }
}

