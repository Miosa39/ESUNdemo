DELIMITER //
CREATE PROCEDURE Register(
    IN p_PhoneNumber VARCHAR(20),
    IN p_Password VARCHAR(255),
    IN p_UserName VARCHAR(100),
    IN p_Salt VARCHAR(255)
)
BEGIN
    INSERT INTO User (PhoneNumber, Password, UserName, Salt, RegistrationTime, LastLoginTime)
    VALUES (p_PhoneNumber, p_Password, p_UserName,  p_Salt , NOW(), NOW());
END //
DELIMITER ;
