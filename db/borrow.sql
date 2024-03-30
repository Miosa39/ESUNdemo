DELIMITER //
CREATE PROCEDURE borrow(
	IN p_UserID INT,
    IN p_InventoryId INT
)
BEGIN 
	START TRANSACTION;
	UPDATE inventory SET Status = 'on loan' WHERE InventoryId = p_InventoryId;
	INSERT INTO borrowing_record
    (UserId,
    InventoryId,
    BorrowingTime,ReturnTime)    VALUES    (p_UserID,p_InventoryId ,NOW(),NULL);    
    COMMIT;
END //
DELIMITER ;
