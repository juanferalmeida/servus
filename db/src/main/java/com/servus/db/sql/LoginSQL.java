package com.servus.db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.servus.db.Conn;
import com.servus.db.Login;

public class LoginSQL {
	Conn conn = new Conn();
	Connection connection = conn.getConnection();

	public Set<Login> consultLogin() throws SQLException {
		Set<Login> listLogin = new HashSet<>();
		if (connection != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = connection.prepareStatement("SELECT mail,code,active,userId FROM Login");
			rs = ps.executeQuery();
			while (rs.next()) {
				Login lg = new Login();
				lg.setMail(rs.getString("mail"));
				lg.setCode(rs.getString("code"));

				lg.setActive(rs.getBoolean("active"));

				lg.setUserId(rs.getString("userId"));

				listLogin.add(lg);
			}
		}
		return listLogin;

	}

	public Login getUser(String mail) throws SQLException {
		Login login = null;

		if (connection != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = connection.prepareStatement("SELECT * FROM login WHERE mail = ? ;");
			ps.setString(1, mail);
			rs = ps.executeQuery();
			while (rs.next()) {
				login = new Login();
				login.setMail(rs.getString("mail"));
				login.setCode(rs.getString("code"));
				login.setActive(rs.getBoolean("active"));
				login.setUserId(rs.getString("userId"));
			}
		}
		return login;

	}

	public boolean insert(Login log) throws SQLException {
		boolean insert = false;

		if (connection != null) {
			PreparedStatement ps = null;
			ps = connection.prepareStatement("INSERT INTO Login (mail, code, active, userId) VALUES(?, ?, ?, ?) ;");

			ps.setString(1, log.getMail());
			ps.setString(2, log.getCode());
			ps.setBoolean(3, log.isActive());
			ps.setString(4, log.getUserId());
			ps.executeUpdate();
			insert = true;

		}
		return insert;
	}

	public boolean modifyLogin(Login log) throws SQLException {
		boolean modify = false;
		if (connection != null) {
			PreparedStatement ps = null;
			ps = connection.prepareStatement("UPDATE Login  SET  code = ?, active = ?, userId = ?   WHERE mail = ? ;");

			ps.setString(1, log.getCode());
			ps.setBoolean(2, log.isActive());
			ps.setString(3, log.getUserId());
			ps.setString(4, log.getMail());

			ps.executeUpdate();

			modify = true;
		}

		return modify;
	}

	public boolean deleteLogin(Login login) throws SQLException {
		boolean delete = false;

		if (connection != null) {
			PreparedStatement ps = null;
			ps = connection.prepareStatement("DELETE FROM Login WHERE mail = ? ;");
			ps.setString(1, login.getMail());
			ps.executeUpdate();
			delete = true;

		}
		return delete;
	}
}