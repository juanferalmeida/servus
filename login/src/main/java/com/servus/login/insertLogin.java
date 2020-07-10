package com.servus.login;

import java.sql.SQLException;

import com.servus.db.Login;
import com.servus.db.sql.LoginSQL;

public class insertLogin {

	public static void main(String[] args) {
		 Login insertLog = new Login("mikasa@gmail.com","9999",true,"mikasa@gmail.com");
		    LoginSQL loginSQL = new LoginSQL();

		    try {
		    	loginSQL.insert(insertLog);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		    

	}


