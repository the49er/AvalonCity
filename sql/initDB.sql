SET @@global.time_zone = '+00:00';
DROP SCHEMA IF EXISTS `aeroparker`;
CREATE SCHEMA IF NOT EXISTS `aeroparker`;
USE aeroparker;
CREATE USER IF NOT EXISTS 'test_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON aeroparker. * TO 'test_user'@'localhost';
FLUSH PRIVILEGES;
