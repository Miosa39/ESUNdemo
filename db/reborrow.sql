DELIMITER //
CREATE PROCEDURE reborrow(
	IN p_UserID INT,
    IN p_InventoryId INT
)
BEGIN 
	START TRANSACTION;
	UPDATE inventory SET Status = 'on loan' WHERE InventoryId = p_InventoryId;
    UPDATE User SET BorrowingTime = NOW(),ReturnTime = NULL WHERE InventoryId = p_InventoryId AND UserID=p_UserID; 
    COMMIT;
END //
DELIMITER ;
