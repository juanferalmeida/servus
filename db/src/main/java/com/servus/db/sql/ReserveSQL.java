package com.servus.db.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import com.servus.db.Conn;
import com.servus.db.Reserve;

public class ReserveSQL {

	Conn conn = new Conn();
    Connection connection = conn.getConnection();
    
    
  public Reserve getReserve( int reserveId ) throws SQLException
  {
      Reserve reserve = null;
    
      if( connection != null )
      {
          PreparedStatement ps = null;
          ResultSet rs = null;
          ps = connection.prepareStatement( "SELECT * FROM Reserve WHERE reserveId = ? ;" );
          ps.setInt( 1, reserveId );
          rs = ps.executeQuery();
          while( rs.next() )
          {
              reserve = new Reserve();
              reserve.setReserveId(rs.getInt("reserveId"));
              reserve.setUserId( rs.getString( "userId" ) );
              reserve.setServiceId( rs.getInt( "serviceId" ) );
              reserve.setReserveDate(rs.getDate("reserveDate").toLocalDate());
              reserve.setReserveStart(rs.getTime("reserveStart").toLocalTime());
              reserve.setReserveEnd(rs.getTime("reserveEnd").toLocalTime());

              reserve.setStatus( rs.getString( "status" ) );

              reserve.setScore(rs.getInt( "score" ) );
          }
      }
      return reserve;
      
  }
  
  public boolean insert(Reserve reserve) throws SQLException {
		boolean insert = false;
		
		if (connection != null) {
			   PreparedStatement ps = null;
			 ps = connection.prepareStatement( "INSERT INTO Reserve (reserveId, userId, serviceId, reserveDate, reserveStart, reserveEnd, status, score) VALUES(?, ?, ?, ?, ?, ?, ?, ? ); ");
			
				ps.setInt(1, reserve.getReserveId());
				ps.setString(2, reserve.getUserId());
				ps.setInt(3, reserve.getServiceId());
				ps.setDate(4,Date.valueOf(reserve.getReserveDate()));
				ps.setTime(5,Time.valueOf(reserve.getReserveStart()));
				ps.setTime(6,Time.valueOf(reserve.getReserveEnd()));
				ps.setString(7, reserve.getStatus());
				ps.setInt(8, reserve.getScore());
				ps.executeUpdate();
				insert = true;
			
			
		}
		return insert;
	}
  
	public boolean modify(Reserve reserve) throws SQLException {
		boolean modify = false;
		if (connection != null) {
			   PreparedStatement ps = null;
				 ps = connection.prepareStatement( "UPDATE   Person  SET  type = ?, name = ?, mobile = ?, country = ?, city = ?, address = ? , map = ?, birthday = ? WHERE reserveId = ? ;" );

				 ps.setInt(1, reserve.getReserveId());
					ps.setString(2, reserve.getUserId());
					ps.setInt(3, reserve.getServiceId());
					ps.setDate(4,Date.valueOf(reserve.getReserveDate()));
					ps.setTime(5,Time.valueOf(reserve.getReserveStart()));
					ps.setTime(6,Time.valueOf(reserve.getReserveEnd()));
					ps.setString(7, reserve.getStatus());
					ps.setInt(8, reserve.getScore());

			
				ps.executeUpdate();

				modify = true;
		}
		
		return modify;
	}

	public boolean delete(int reserveId) throws SQLException {
		boolean delete = false;

		if (connection != null) {
			   PreparedStatement ps = null;
				ps = connection.prepareStatement("DELETE FROM Reserve WHERE reserveId = ? ; ");
				ps.setInt(1, reserveId);
				ps.executeUpdate();
				delete = true;
			
		}
		return delete;
	}
}