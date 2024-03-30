package org.example.esundemo;

import org.example.esundemo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

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
}

