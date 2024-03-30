DELIMITER //
CREATE PROCEDURE GetUserByPhoneNumber(
    IN p_PhoneNumber VARCHAR(20)
)
BEGIN
    SELECT * FROM User WHERE PhoneNumber = p_PhoneNumber;
END //
DELIMITER ;