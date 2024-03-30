package org.example.esundemo;

import org.example.esundemo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void register(User user){
        String procedureCall = "CALL Register(?, ?, ?, ?)";
        jdbcTemplate.update(procedureCall,user.getPhoneNumber(),user.getPassword(), user.getUserName(),user.getSalt());
    }
    public List<Map<String, Object>> findAccountByUsername(User user){
        String procedureCall = "CALL GetUserByPhoneNumber(?)";
        return jdbcTemplate.queryForList(procedureCall,user.getPhoneNumber());
    }
    public void borrow(String Book_ID,String User_ID){
        String procedureCall = "CALL borrow5(?,?)";
        jdbcTemplate.update(procedureCall,Book_ID,User_ID);
    }
    public void reborrow(){

    }
    public List<Map<String, Object>> checkbook(String book_id){
        String procedureCall = "CALL GetBookByID(?)";
        return jdbcTemplate.queryForList(procedureCall,book_id);
    }
    public void retu(String Book_ID,String User_ID){
        String procedureCall = "CALL retu(?,?)";
        jdbcTemplate.update(procedureCall,Book_ID,User_ID);
    }
}



/*
DELIMITER //

CREATE PROCEDURE Register(
    IN p_PhoneNumber VARCHAR(20),
    IN p_Password VARCHAR(255),
    IN p_UserName VARCHAR(100),
    IN p_Salt VARCHAR(255);
)
BEGIN
    INSERT INTO User (PhoneNumber, Password, UserName, Salt, RegistrationTime, LastLoginTime)
    VALUES (p_PhoneNumber, p_Password, p_UserName,  p_Salt , NOW(), NOW());
END //

DELIMITER ;
 */