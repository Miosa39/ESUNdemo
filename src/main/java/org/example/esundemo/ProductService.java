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
    public List<Map<String, Object>> getBookList(){
        return repository.getBookList();
    }
    public List<Map<String, Object>> getborrowRecord(String User_ID){
        return repository.getborrowRecord(User_ID);
    }
    public void login(User user){
        System.out.printf(String.valueOf(repository.findAccountByUsername(user).get(0).get("password")));
        //檢查帳號是否存在
        //salt加密
        //比對密碼
        //取得資料
        //更新資料
    }
    public int borrow(String Book_ID,String User_Phonenumber){
        if(repository.checkbook(Book_ID).isEmpty()){
            return -1;//檢查書本是否存在
        }
        if (repository.checkbook(Book_ID).get(0).get("Status") == "on loan") {
            return 1;//檢查書本是否出借中
        }
        if(repository.checkreborrow(Book_ID,User_Phonenumber).isEmpty()) {
            repository.borrow(Book_ID,User_Phonenumber);
        }
        else{
            repository.reborrow(Book_ID,User_Phonenumber);
        }
        return 0;
    }

    public void retu(String Book_ID,String User_Phonenumber){
        if(repository.checkbook(Book_ID).isEmpty()){
            return;//檢查書本是否存在
        }
        if (repository.checkbook(Book_ID).get(0).get("Status") != "on loan") {
           return;//檢查書本是否出借中
        }
        else {
            System.out.printf(Book_ID+User_Phonenumber+"\n");
            repository.retu(Book_ID,User_Phonenumber);
        }
    }
}

