-- Drop user first if they exist
DROP USER if exists 'dataA'@'%' ;

-- Now create user with prop privileges
CREATE USER 'dataA'@'%' IDENTIFIED BY 'dataA';

GRANT ALL PRIVILEGES ON demeter.* TO 'dataA'@'%';