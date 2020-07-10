package com.servus.db.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servus.db.Conn;
import com.servus.db.Person;

public class PersonSQL
{
	Conn conn = new Conn();
    Connection connection = conn.getConnection();
    
    
  public Person getPerson( String userId ) throws SQLException
  {
      Person pers = null;
    
      if( connection != null )
      {
          PreparedStatement ps = null;
          ResultSet rs = null;
          ps = connection.prepareStatement( "SELECT * FROM Person WHERE userId = ? ;" );
          ps.setString( 1, userId );
          rs = ps.executeQuery();
          while( rs.next() )
          {
              pers = new Person();
              pers.setUserId(rs.getString("userId"));
              pers.setType( rs.getString( "type" ) );
              pers.setName( rs.getString( "name" ) );
              pers.setMobile( rs.getString( "mobile" ) );
              pers.setCountry( rs.getString( "country" ) );

              pers.setCity( rs.getString( "city" ) );

              pers.setAddress( rs.getString( "address" ) );
              pers.setMap( rs.getString( "map" ) ); 	
              pers.setBirthday(rs.getDate("birthday").toLocalDate());
          }
      }
      return pers;
      
  }
  
  public boolean insert(Person pers) throws SQLException {
		boolean insert = false;
		
		if (connection != null) {
			   PreparedStatement ps = null;
			 ps = connection.prepareStatement( "INSERT INTO Persons (userId, type, name, mobile, country, city, address, map, birthday) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ? ) ;");
			
				ps.setString(1, pers.getUserId());
				ps.setString(2, pers.getType());
				ps.setString(3, pers.getName());
				ps.setString(4, pers.getMobile());
				ps.setString(5, pers.getCountry());
				ps.setString(6, pers.getCity());
				ps.setString(7, pers.getAddress());
				ps.setString(8, pers.getMap());

				ps.setDate(9, Date.valueOf(pers.getBirthday()));
				ps.executeUpdate();
				insert = true;
			
			
		}
		return insert;
	}
  
	public boolean modify(Person pers) throws SQLException {
		boolean modify = false;
		if (connection != null) {
			   PreparedStatement ps = null;
				 ps = connection.prepareStatement( "UPDATE   Person  SET  type = ?, name = ?, mobile = ?, country = ?, city = ?, address = ? , map = ?, birthday = ? WHERE userId = ? ;" );

					ps.setString(1, pers.getUserId());
					ps.setString(2, pers.getType());
					ps.setString(3, pers.getName());
					ps.setString(4, pers.getMobile());
					ps.setString(5, pers.getCountry());
					ps.setString(6, pers.getCity());
					ps.setString(7, pers.getAddress());
					ps.setString(8, pers.getMap());

					ps.setDate(9, Date.valueOf(pers.getBirthday()));
			
				ps.executeUpdate();

				modify = true;
		}
		
		return modify;
	}

	public boolean delete(String userId) throws SQLException {
		boolean delete = false;

		if (connection != null) {
			   PreparedStatement ps = null;
				ps = connection.prepareStatement("DELETE FROM Person WHERE userId = ? ; ");
				ps.setString(1, userId);
				ps.executeUpdate();
				delete = true;
			
		}
		return delete;
	}
}