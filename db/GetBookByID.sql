DELIMITER //
CREATE PROCEDURE GetBookByID(
    IN p_InventoryId VARCHAR(20)
)
BEGIN
    SELECT * FROM inventory WHERE InventoryId = p_InventoryId;
END //
DELIMITER ;