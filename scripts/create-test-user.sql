-- Drop user first if they exist
DROP USER if exists 'testA'@'%' ;

-- Now create user with prop privileges
CREATE USER 'testA'@'%' IDENTIFIED BY 'testA';

GRANT ALL PRIVILEGES ON `demeter-test`.* TO 'testA'@'%';