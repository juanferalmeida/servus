package com.servus.login;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.servus.db.Person;
import com.servus.db.sql.PersonSQL;

public class Login{
    private static Connection conexion;

	public static void main(String[] args) throws SQLException {
	PersonSQL persSQL = new PersonSQL(conexion);
	Person  per = new Person();
	Gson g = new Gson();



  }
}

