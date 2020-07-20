package com.servus.db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servus.db.Conn;
import com.servus.db.ServiceItem;

public class ServiceItemSQL {
	Conn conn = new Conn();
    Connection connection = conn.getConnection();
    
    
  public ServiceItem getServiceItem( String serviceType, Integer itemId ) throws SQLException
  {
	  ServiceItem serviceitem = null;
    
      if( connection != null )
      {
          PreparedStatement ps = null;
          ResultSet rs = null;
          ps = connection.prepareStatement( "SELECT * FROM ServiceItem WHERE serviceType = ? and itemId = ? ;" );
          ps.setString( 1, serviceType );
          ps.setInt( 2, itemId );

          rs = ps.executeQuery();
          while( rs.next() )
          {
        	  serviceitem = new ServiceItem();
        	  serviceitem.setServiceType(rs.getString("serviceType"));
        	  serviceitem.setItemId( rs.getInt( "itemId" ) );
        	  serviceitem.setName( rs.getString( "name" ) );
              

            
          }
      }
      return serviceitem;
      
  }
  
  public boolean insert(ServiceItem serviceitem) throws SQLException {
		boolean insert = false;
		
		if (connection != null) {
			   PreparedStatement ps = null;
			 ps = connection.prepareStatement( "INSERT INTO ServiceItem (serviceType, itemId, name) VALUES(?, ?, ? ); ");
			
				ps.setString(1, serviceitem.getServiceType());
				ps.setInt(2, serviceitem.getItemId());
				ps.setString(3, serviceitem.getName());
				

				ps.executeUpdate();
				insert = true;
			
			
		}
		return insert;
	}
  
	public boolean modify(ServiceItem serviceitem) throws SQLException {
		boolean modify = false;
		if (connection != null) {
			   PreparedStatement ps = null;
				 ps = connection.prepareStatement( "UPDATE   ServiceItem  SET  name = ? WHERE serviceType = ? AND itemId = ?;" );

				 ps.setString(1, serviceitem.getServiceType());
					ps.setInt(2, serviceitem.getItemId());
					ps.setString(3, serviceitem.getName());

			
				ps.executeUpdate();

				modify = true;
		}
		
		return modify;
	}

	public boolean delete(String serviceType, int itemId) throws SQLException {
		boolean delete = false;

		if (connection != null) {
			   PreparedStatement ps = null;
				ps = connection.prepareStatement("DELETE FROM ServiceItem WHERE serviceType = ? AND itemId = ?");
				ps.setString(1, serviceType);
				ps.setInt(2, itemId);

				ps.executeUpdate();
				delete = true;
			
		}
		return delete;
	}


}




