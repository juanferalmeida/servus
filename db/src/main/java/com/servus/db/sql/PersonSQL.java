package com.servus.db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.servus.db.Person;

public class PersonSQL
{
	private Connection conexion;

	public PersonSQL(Connection conexion) {
		this.conexion = conexion;
	}


	public Set<Person> consultPerson() throws SQLException {
		Set<Person> listPersons = new HashSet<>();
		if (conexion != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				String consulta = "SELECT * FROM login";
				ps = conexion.prepareStatement(consulta, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while (rs.next()) {
					Person pers = new Person();
					pers.setUserId(rs.getString("userId"));
					pers.setType(rs.getString("type"));
					pers.setName(rs.getString("name"));
					pers.setMobile(rs.getString("mobile"));
					pers.setCountry(rs.getString("country"));
					pers.setCity(rs.getString("city"));
					pers.setAddress(rs.getString("address"));
					pers.setMap(rs.getString("map"));

					pers.setBirthday(rs.getDate("birthday").toLocalDate());
					listPersons.add(pers);
				}
			} finally {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			}
		}
		return listPersons;
	}
	
	public boolean insertPerson(Person pers) throws SQLException {
		boolean insert = false;
		if (conexion != null) {
			PreparedStatement ps = null;
			try {
				String consult = "INSERT INTO Person (userId, type, name, mobile, country, city, address, map, birthday) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = conexion.prepareStatement(consult);
				ps.setString(1, pers.getUserId());
				ps.setString(2, pers.getType());
				ps.setString(3, pers.getName());
				ps.setString(4, pers.getMobile());
				ps.setString(5, pers.getCountry());
				ps.setString(6, pers.getCity());
				ps.setString(7, pers.getAddress());
				ps.setString(8, pers.getMap());
				ps.setDate(9,java.sql.Date.valueOf(pers.getBirthday()));

			
				ps.executeUpdate();
				insert = true;
			} finally {
				if (ps != null) {
					ps.close();
				}
			}
		}
		return insert;
	}
	public boolean modifyPerson(Person pers) throws SQLException {
		boolean modify = false;
		if (conexion != null) {
			PreparedStatement ps = null;
			try {
				String consulta = "UPDATE person SET type = ?, name = ?, mobile = ?, country = ?, city = ?, address = ?, map = ?, birthday = ?  WHERE userId = ? ";
				ps = conexion.prepareStatement(consulta);
				ps.setString(1, pers.getType());
				ps.setString(2, pers.getName());
				ps.setString(3, pers.getMobile());
				ps.setString(4, pers.getCountry());
				ps.setString(5, pers.getCity());
				ps.setString(6, pers.getAddress());
				ps.setString(7, pers.getMap());
				ps.setDate(8,java.sql.Date.valueOf(pers.getBirthday()));
				ps.setString(9, pers.getUserId());

				ps.executeUpdate();

				modify = true;
			} finally {
				if (ps != null) {
					ps.close();
				}
			}
		}
		return modify;
	}
	public boolean deletePerson(String userId) throws SQLException {
		boolean delete = false;

		if (conexion != null) {
			PreparedStatement ps = null;
			try {
				ps = conexion.prepareStatement("DELETE FROM Person WHERE userId = ?");
				ps.setString(1, userId);
				ps.executeUpdate();
				delete = true;
			} finally {
				if (ps != null) {
					ps.close();
				}
			}
		}
		return delete;
	}
}
