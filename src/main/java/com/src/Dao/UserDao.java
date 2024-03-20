package com.src.Dao;

import java.sql.SQLException;

import com.src.model.User;

public interface UserDao {
	public boolean userRegister(User user) throws SQLException;
	public User loginUser(String email, String password);
	public boolean checkOldPassword(int userId, String oldPassword);
	public boolean changePassword(int userId, String newPassword);

}
