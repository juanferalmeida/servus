package com.servus.db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servus.db.Conn;
import com.servus.db.ServiceType;

public class ServiceTypeSQL {
	Conn conn = new Conn();
    Connection connection = conn.getConnection();
    
    
  public  ServiceType getServiceType( String serviceType ) throws SQLException
  {
	  ServiceType servicetype = null;
    
      if( connection != null )
      {
          PreparedStatement ps = null;
          ResultSet rs = null;
          ps = connection.prepareStatement( "SELECT * FROM servicetype WHERE serviceType = ? ;" );
          ps.setString( 1, serviceType );
          rs = ps.executeQuery();
          while( rs.next() )
          {
        	  servicetype = new ServiceType();
        	  servicetype.setServiceType(rs.getString("serviceType"));
        	  servicetype.setName( rs.getString( "name" ) );
              

            
          }
      }
      return servicetype;
      
  }
  
  public boolean insert(ServiceType servicetype) throws SQLException {
		boolean insert = false;
		
		if (connection != null) {
			   PreparedStatement ps = null;
			 ps = connection.prepareStatement( "INSERT INTO ServiceType (serviceType,  name) VALUES(?, ? )");
			
				ps.setString(1, servicetype.getServiceType());
				ps.setString(2, servicetype.getName());
				

				ps.executeUpdate();
				insert = true;
			
			
		}
		return insert;
	}
  
	public boolean modify(ServiceType servicetype) throws SQLException {
		boolean modify = false;
		if (connection != null) {
			   PreparedStatement ps = null;
				 ps = connection.prepareStatement( "UPDATE ServiceType  SET  name = ? WHERE serviceType = ? ;" );

					ps.setString(1, servicetype.getServiceType());
					ps.setString(2, servicetype.getName());
					
			
				ps.executeUpdate();

				modify = true;
		}
		
		return modify;
	}

	public boolean delete(String  servicetype) throws SQLException {
		boolean delete = false;

		if (connection != null) {
			   PreparedStatement ps = null;
				ps = connection.prepareStatement("DELETE FROM ServiceType WHERE serviceType = ? ");
				ps.setString(1, servicetype);
				
				ps.executeUpdate();
				delete = true;
			
		}
		return delete;
	}


}




