package com.servus.login;

import java.sql.SQLException;

import com.google.gson.Gson;
import com.servus.db.Login;
import com.servus.db.Message;
import com.servus.db.Result;
import com.servus.db.sql.LoginSQL;

public class SignOn
{
    public static void main( String[] args )
    {
		Gson g = new Gson();

        LoginSQL loginSQL = new LoginSQL();
        String mail = "juan@gmail.com";
        String code = "12345";
        Login user = null;
        Result resultOK = new Result("OK", "Acces Granted", mail);
        Result resultNoExist = new Result("Error", "This User Does Not Exist!", mail);
        Result resultNoActive = new Result("Error", "This User Does Not Active!", mail);
        Result resultFailPassword = new Result("Error", "Password Incorrect!", mail);

        Message message1 = new Message(mail,code);
        try
        {
            user = loginSQL.getUser( mail );
    		System.out.println(g.toJson(message1));

            		
        }
        catch( SQLException e )
        {
            System.err.println( e.getLocalizedMessage() );
            e.printStackTrace();
        }

        if( user == null )
        {
    		System.out.println(g.toJson(resultNoExist));
        }
        else if( !user.isActive() )
        {
    		System.out.println(g.toJson(resultNoActive));
        }
        else if( !user.getCode()
            .equals( code ) )
        {
    		System.out.println(g.toJson(resultFailPassword));
        }
        else
        {
        
    		System.out.println(g.toJson(resultOK) + " " + user.getUserId());

        }
    }
    
   
    
    
}


