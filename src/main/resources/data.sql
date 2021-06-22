DROP TABLE IF EXISTS Policy_Master;
  
CREATE TABLE Policy_Master(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	Policy_ID VARCHAR(20) NOT NULL,
    Property_Type VARCHAR(30) NOT NULL,
    Consumer_Type VARCHAR(30) NOT NULL,
    Assured_Sum VARCHAR(40) NOT NULL,
    Tenure VARCHAR(30) NOT NULL,
    Business_Value BIGINT NOT NULL,
    Property_Value BIGINT NOT NULL,
    Base_Location VARCHAR(30) NOT NULL,
    Type VARCHAR(30) NOT NULL
);


INSERT INTO Policy_Master(Policy_ID,Property_Type,Consumer_Type,Assured_Sum,Tenure,Business_Value,Property_Value,Base_Location,Type) VALUES 
(1,'Building','Owner','2,00,00,000','2 year',8,5,'Chennai','Pay Back'),
(2,'Building','Owner','4,00,000','2 year',9,10,'Chennai','Fire'),
(3,'Building','Owner','2,00,000','3 year',7,8,'Pune','Replacement'),
(4,'Building','Owner','2,00,000','9 year',10,9,'Delhi','Burglary');