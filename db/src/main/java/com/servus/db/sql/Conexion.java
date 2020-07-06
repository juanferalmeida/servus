package com.servus.db.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static void main(String[] args) {
		  String bd = "serdb";
	        String login = "root";
	        String password = "root";
			
	        String url = "jdbc:mysql://localhost:3306/" + bd + "?serverTimezone=UTC";
	        
	        try (Connection conn = DriverManager.getConnection(url, login, password)) {

	            if (conn != null) {
			  //CONECTADOS CON LA BDA REFERENCIADA POR URL, CON EL USUARIO LOGIN Y SU PASSWORD
	                System.out.println("Conexion a base de datos " + url + " ... OK");
	            }
				
	        } catch (SQLException ex) {
	            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + bd);
				System.out.println("URL utilizada" + url);
	            System.out.println("ERROR: " + ex.getMessage());
	        } catch (Exception e) {
	            System.out.println(e);
	        }

	    }
	}
