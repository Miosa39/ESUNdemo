package org.example.esundemo;

import org.example.esundemo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void register(User user){
        System.out.println("EXCUTE INSERT User");
        jdbcTemplate.update("INSERT INTO user(UserId, PhoneNumber, Password,Salt,serName,RegistrationTime,LastLoginTime)"
                        + "VALUES (?,?,?,?,?,NOW(),NOW())",0,user.getPhoneNumber(),user.getPassword(),user.getSalt(), user.getUserName());
    }
}
