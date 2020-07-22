package com.servus.db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servus.db.Conn;
import com.servus.db.Service;

public class ServiceSQL {

	Conn conn = new Conn();
	Connection connection = conn.getConnection();

	public Service getService(int serviceId) throws SQLException {
		Service service = null;

		if (connection != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = connection.prepareStatement("SELECT * FROM Service WHERE serviceId = ?; ");
			ps.setInt(1, serviceId);
			rs = ps.executeQuery();
			while (rs.next()) {
				service = new Service();
				service.setServiceId(rs.getInt("serviceId"));
				service.setAdminId(rs.getString("adminId"));
				service.setServiceType(rs.getString("serviceType"));
				service.setName(rs.getString("name"));
				service.setDescription(rs.getString("description"));
				service.setMobile(rs.getString("mobile"));
				service.setCountry(rs.getString("country"));
				service.setCity(rs.getString("city"));
				service.setAddress(rs.getString("address"));
				service.setMap(rs.getString("map"));
				service.setAvailable(rs.getBoolean("available"));

			}
		}
		return service;

	}

	public boolean insert(Service service) throws SQLException {
		boolean insert = false;

		if (connection != null) {
			PreparedStatement ps = null;
			ps = connection.prepareStatement(
					"INSERT INTO Service (serviceId, adminId, serviceType, name, description, mobile, country, city, address, map, available) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ); ");

			ps.setInt(1, service.getServiceId());
			ps.setString(2, service.getAdminId());
			ps.setString(3, service.getServiceType());
			ps.setString(4, service.getName());
			ps.setString(5, service.getDescription());
			ps.setString(6, service.getMobile());
			ps.setString(7, service.getCountry());
			ps.setString(8, service.getCity());
			ps.setString(9, service.getAddress());
			ps.setString(10, service.getMap());
			ps.setBoolean(11, service.isAvailable());

			ps.executeUpdate();
			insert = true;

		}
		return insert;
	}

	public boolean modify(Service service) throws SQLException {
		boolean modify = false;
		if (connection != null) {
			PreparedStatement ps = null;
			ps = connection.prepareStatement(
					"UPDATE   Service  SET  adminId = ?, serviceType = ?, name = ?, description = ?, mobile = ?, country = ? , city = ?, address = ?, map = ?, available= ? WHERE serviceId = ? ;");

			ps.setInt(1, service.getServiceId());
			ps.setString(2, service.getAdminId());
			ps.setString(3, service.getServiceType());
			ps.setString(4, service.getName());
			ps.setString(5, service.getDescription());
			ps.setString(6, service.getMobile());
			ps.setString(7, service.getCountry());
			ps.setString(8, service.getCity());
			ps.setString(9, service.getAddress());
			ps.setString(10, service.getMap());
			ps.setBoolean(11, service.isAvailable());

			ps.executeUpdate();

			modify = true;
		}

		return modify;
	}

	public boolean delete(int serviceId) throws SQLException {
		boolean delete = false;

		if (connection != null) {
			PreparedStatement ps = null;
			ps = connection.prepareStatement("DELETE FROM Service WHERE serviceId = ? ; ");
			ps.setInt(1, serviceId);
			ps.executeUpdate();
			delete = true;

		}
		return delete;
	}

}
