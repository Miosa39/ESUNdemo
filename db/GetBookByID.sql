DELIMITER //
CREATE PROCEDURE GetBookByID(
    IN p_InventoryId VARCHAR(20)
)
BEGIN
    SELECT * FROM inventory WHERE InventoryId = p_InventoryId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetUserByID(
    IN p_UserID VARCHAR(20)
)
BEGIN
    SELECT * FROM user WHERE UserId = p_UserId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetUserByPhoneNumber(
    IN p_PhoneNumber VARCHAR(20)
)
BEGIN
    SELECT * FROM User WHERE PhoneNumber = p_PhoneNumber;
END //
DELIMITER ;


