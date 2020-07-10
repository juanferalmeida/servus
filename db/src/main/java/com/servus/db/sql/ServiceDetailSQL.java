package com.servus.db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servus.db.Conn;
import com.servus.db.ServiceDetail;

public class ServiceDetailSQL {
	Conn conn = new Conn();
    Connection connection = conn.getConnection();
    
    
  public ServiceDetail getServiceDetail( int serviceId ) throws SQLException
  {
	  ServiceDetail servicedetail = null;
    
      if( connection != null )
      {
          PreparedStatement ps = null;
          ResultSet rs = null;
          ps = connection.prepareStatement( "SELECT * FROM ServiceDetail WHERE serviceId = ? and item = ? ; " );
          ps.setInt( 1, serviceId );
          rs = ps.executeQuery();
          while( rs.next() )
          {
        	  servicedetail = new ServiceDetail();
        	  servicedetail.setServiceId(rs.getInt("serviceId"));
        	  servicedetail.setItemId( rs.getInt( "itemId" ) );
        	  servicedetail.setName( rs.getString( "name" ) );
        	  servicedetail.setValue( rs.getString( "value" ) );
              

            
          }
      }
      return servicedetail;
      
  }
  
  public boolean insert(ServiceDetail servicedetail) throws SQLException {
		boolean insert = false;
		
		if (connection != null) {
			   PreparedStatement ps = null;
			 ps = connection.prepareStatement( "INSERT INTO ServiceDetail (serviceId, itemId, name, value) VALUES(?, ?, ?, ?)");
			
				ps.setInt(1, servicedetail.getServiceId());
				ps.setInt(2, servicedetail.getItemId());
				ps.setString(3, servicedetail.getName());
				ps.setString(4, servicedetail.getValue());
				


				ps.executeUpdate();
				insert = true;
			
			
		}
		return insert;
	}
  
	public boolean modify(ServiceDetail servicedetail) throws SQLException {
		boolean modify = false;
		if (connection != null) {
			   PreparedStatement ps = null;
				 ps = connection.prepareStatement( "UPDATE   ServiceDetail  SET  name = ?, value = ? WHERE serviceId = ? and itemId = ?;" );

				 	ps.setInt(1, servicedetail.getServiceId());
					ps.setInt(2, servicedetail.getItemId());
					ps.setString(3, servicedetail.getName());
					ps.setString(4, servicedetail.getValue());

			
				ps.executeUpdate();

				modify = true;
		}
		
		return modify;
	}

	public boolean delete(int serviceId, int itemId) throws SQLException {
		boolean delete = false;

		if (connection != null) {
			   PreparedStatement ps = null;
				ps = connection.prepareStatement("DELETE FROM ServiceDetail WHERE serviceId = ? AND itemId = ?");
				ps.setInt(1, serviceId);
				ps.setInt(2, itemId);

				ps.executeUpdate();
				delete = true;
			
		}
		return delete;
	}


}


