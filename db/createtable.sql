USE esundb;
CREATE TABLE User (
    UserId INT PRIMARY KEY AUTO_INCREMENT,
    PhoneNumber VARCHAR(20) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Salt VARCHAR(255) NOT NULL,
    UserName VARCHAR(100),
    RegistrationTime DATETIME,
    LastLoginTime DATETIME
);
CREATE TABLE Inventory (
    InventoryId INT PRIMARY KEY AUTO_INCREMENT,
    ISBN VARCHAR(20),
    StoreTime DATETIME,
    Status ENUM('in stock', 'on loan', 'in preparing', 'lost', 'damage', 'abandoned')
);
CREATE TABLE Book (
    ISBN VARCHAR(20) PRIMARY KEY,
    Name VARCHAR(255),
    Author VARCHAR(100),
    Introduction TEXT
);
CREATE TABLE Borrowing_Record (
    UserId INT,
    InventoryId INT,
    BorrowingTime DATETIME,
    ReturnTime DATETIME,
    PRIMARY KEY (UserId, InventoryId),
    FOREIGN KEY (UserId) REFERENCES User(UserId),
    FOREIGN KEY (InventoryId) REFERENCES Inventory(InventoryId)
);

