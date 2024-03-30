DELIMITER //
CREATE PROCEDURE retu(
	IN p_UserID INT,
    IN p_InventoryId INT
)
BEGIN 
	START TRANSACTION;
	UPDATE inventory SET Status = 'in stock' WHERE InventoryId = p_InventoryId;
	UPDATE borrowing_record SET ReturnTime = NOW() where InventoryId = p_InventoryId AND UserID=p_UserID;
    COMMIT;
END //
DELIMITER ;
