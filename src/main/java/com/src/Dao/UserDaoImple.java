package com.src.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.src.model.User;

public class UserDaoImple implements UserDao {
	DaoService dao = new DaoService();

	@Override
	public boolean userRegister(User user) {
		System.out.println(user);
		boolean f = false;

		String sql = "insert into user_details(fullName, email, password) values(?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = dao.getMyPreparedStatement(sql);
			pstmt.setString(1, user.getFullName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());

			pstmt.executeUpdate();
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;

	}

	@Override
	public User loginUser(String email, String password) {
		User user = null;
		String sql = "select * from user_details where email=? and password=?";

		PreparedStatement pstmt;
		try {
			pstmt = dao.getMyPreparedStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				user = new User();

				user.setId(resultSet.getInt("id"));
				user.setFullName(resultSet.getString("fullName"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public boolean checkOldPassword(int userId, String oldPassword) {
		boolean f = false;
		String sql = "select * from user_details where id=? and password=?";
		PreparedStatement pstmt;
		try {
			pstmt = dao.getMyPreparedStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setString(2, oldPassword);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}

	@Override
	public boolean changePassword(int userId, String newPassword) {
		boolean f = false;
		String sql = "update user_details set password=? where id=?";
		PreparedStatement pstmt;
		try {
			pstmt = dao.getMyPreparedStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setInt(2, userId);

			pstmt.executeUpdate();

			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}

}
