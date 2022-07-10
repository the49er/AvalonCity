USE aeroparker;
CREATE TABLE customers (
id BIGINT NOT NULL AUTO_INCREMENT,
registered DATE,
firstName VARCHAR(50),
lirstName VARCHAR(50),
email_address VARCHAR(255) NOT NULL unique,
title VARCHAR(5) NOT NULL,
CONSTRAINT title_enum_values
CHECK (title IN ('Mr', 'Mrs', 'Ms', 'Miss')),
PRIMARY KEY(id)
);



