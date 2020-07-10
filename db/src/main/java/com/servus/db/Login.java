//******************************************************************
//                                                                 
//  Login.java                                               
//  Copyright 2020 PSI AG. All rights reserved.              
//  PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//                                                                 
// ******************************************************************

package com.servus.db;

public class Login
{
    String mail;
    String code;
    Boolean active;
    String userId;

    public Login() {
		
	}

	public Login(String mail, String code, Boolean active, String userId) {
		super();
		this.mail = mail;
		this.code = code;
		this.active = active;
		this.userId = userId;
	}

	public String getMail()
    {
        return mail;
    }

    public void setMail( String aMail )
    {
        mail = aMail;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode( String aCode )
    {
        code = aCode;
    }

    public Boolean isActive()
    {
        return active;
    }

    public void setActive( Boolean aActive )
    {
        active = aActive;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId( String aUserId )
    {
        userId = aUserId;
    }

}
