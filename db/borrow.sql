DELIMITER //
CREATE PROCEDURE borrow(
	IN p_UserID INT,
    IN p_InventoryId INT
)
BEGIN 
	START TRANSACTION;
	UPDATE inventory SET Status = 'on loan' WHERE InventoryId = p_InventoryId;
	INSERT INTO borrowing_record (UserId, InventoryId,  BorrowingTime,ReturnTime)  VALUES   (p_UserID,p_InventoryId ,NOW(),NULL);    
    COMMIT;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE reborrow(
	IN p_UserID INT,
    IN p_InventoryId INT
)
BEGIN 
	START TRANSACTION;
	UPDATE inventory SET Status = 'on loan' WHERE InventoryId = p_InventoryId;
    UPDATE borrowing_record SET BorrowingTime = NOW(),ReturnTime = null WHERE InventoryId = p_InventoryId AND UserID = p_UserID; 
    COMMIT;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetUserBycheckreborrow(
    IN p_UserID INT,
	IN p_InventoryId INT
)
BEGIN
    SELECT * FROM borrowing_record  WHERE UserId = p_UserID AND InventoryId = p_InventoryId;
END //
DELIMITER ;

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