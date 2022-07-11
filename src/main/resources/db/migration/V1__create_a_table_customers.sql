USE aeroparker;
CREATE TABLE customers (
id INT NOT NULL AUTO_INCREMENT,
registered DATE NOT NULL,
email VARCHAR(255) NOT NULL unique,
title VARCHAR(5) NOT NULL,
CONSTRAINT title_enum_values
CHECK (title IN ('Mr', 'Mrs', 'Ms', 'Miss')),
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
addressLine1 VARCHAR(255) NOT NULL,
addressLine2 VARCHAR(255),
city VARCHAR(255) NULL,
postcode VARCHAR(10) NOT NULL,
telNumber VARCHAR(20) NULL,
PRIMARY KEY(id)
);



