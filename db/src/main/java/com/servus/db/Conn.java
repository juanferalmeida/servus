package com.servus.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn
{
    Connection connection = null;

    public Conn()
    {
        try
        {
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/serdb", "ser", "ser" );
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
