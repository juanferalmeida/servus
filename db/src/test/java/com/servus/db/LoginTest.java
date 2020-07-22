//******************************************************************
//                                                                 
//  LoginTest.java                                               
//  Copyright 2020 PSI AG. All rights reserved.              
//  PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//                                                                 
// ******************************************************************

package com.servus.db;

import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;

import com.servus.db.sql.LoginSQL;
import com.servus.db.Login;

import junit.framework.TestCase;

public class LoginTest extends TestCase {
	
	LoginSQL loginSQL = new LoginSQL();

	public void testUserId() {
		String mail = "juan@gmail.com";
		String code = "12344";
		Login user = null;
		try {
			user = loginSQL.getUser(mail);
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		//assertEquals("ALMEIDA", user.userId);
	}

	public void testClaveIncorrecta() {
		String mail = "juan@gmail.com";
		String code = "12344";
		Login user = null;
		try {
			user = loginSQL.getUser(mail);
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		//assertNotEquals("XXXX", user.getCode());

	}
}
