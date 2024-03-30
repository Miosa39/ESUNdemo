create database esundb; -- Creates the new database
create user 'esun'@'%' identified by 'esundemo'; -- Creates the user
grant all on esundb.* to 'esun'@'%'; -- Gives all privileges to the new user on the newly created database