package com.servus.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn
{
    Connection connection = null;

    public Conn()
    {
    	  String bd = "serdb";
          String login = "root";
          String password = "root";
          String url = "jdbc:mysql://localhost:3306/" + bd + "?serverTimezone=UTC";

        try
        {
            connection = DriverManager.getConnection( url,login,password );
            System.out.println( "conectado.." );
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        return connection;
    }
}
