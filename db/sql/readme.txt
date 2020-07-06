C:\>mysql -u root -p
Enter password: *****

mysql> CREATE DATABASE serdb;
Query OK, 1 row affected (0.02 sec)

mysql> CREATE USER 'ser'@'localhost' IDENTIFIED BY 'ser';
Query OK, 0 rows affected (0.02 sec)

mysql> GRANT ALL ON serdb.* TO 'ser'@'localhost';
Query OK, 0 rows affected (0.01 sec)

mysql> exit
Bye

C:\>mysql -u ser -p
Enter password: ***

mysql> use serdb
Database changed
