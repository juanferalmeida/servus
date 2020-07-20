package com.servus.db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.servus.db.Login;

public class Login_DAO {
    public Set<Login> findLogin( Connection conexion ) throws SQLException
    {

        Set< Login > listaLogin = new HashSet<>();
        PreparedStatement ps;
        ResultSet rs;
        String consulta;

        if( conexion != null )
        {

            consulta =
                "SELECT mail, code, active, userId FROM Login ";
            ps = conexion.prepareStatement( consulta, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY );
            rs = ps.executeQuery();

            while( rs.next() )
            {

                Login login = new Login();
                login.setMail(rs.getString( "mail" ));
                login.setCode(rs.getString( "code" ));
                login.setActive( rs.getBoolean( "active" ) );
                login.setUserId( rs.getString( "userId" ) );
                listaLogin.add( login );

            }

        }

        return listaLogin;
    }
	
    public boolean insert(Connection conexion, Login log) throws SQLException {
		boolean insert = false;
		
		if (conexion != null) {
			   PreparedStatement ps = null;
			 ps = conexion.prepareStatement( "INSERT INTO Login (mail, code, active, userId) VALUES(?, ?, ?, ?) ;");
			
				ps.setString(1, log.getMail());
				ps.setString(2, log.getCode());
				ps.setBoolean(3, log.isActive());
				ps.setString(4, log.getUserId());
				ps.executeUpdate();
				insert = true;
			
			
		}
		return insert;
	}
    public boolean deleteLogin(Connection conexion,Login login) throws SQLException {
		boolean delete = false;

		if (conexion != null) {
			   PreparedStatement ps = null;
				ps = conexion.prepareStatement("DELETE FROM Login WHERE mail = ? ;");
				ps.setString(1, login.getMail());
				ps.executeUpdate();
				delete = true;
			
		}
		return delete;
	}
}

