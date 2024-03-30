package org.example.esundemo;

import org.example.esundemo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

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
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        repository.register(user);
    }
}

