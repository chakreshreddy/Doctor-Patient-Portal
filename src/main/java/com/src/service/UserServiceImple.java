package com.src.service;

import java.sql.SQLException;

import com.src.Dao.UserDao;
import com.src.Dao.UserDaoImple;
import com.src.model.User;

public class UserServiceImple implements UserService {
	UserDao udao = new UserDaoImple();

	@Override
	public boolean userRegister(User user) throws SQLException {
		return udao.userRegister(user);
	}

	@Override
	public User loginUser(String email, String password) {
		// TODO Auto-generated method stub
		return udao.loginUser(email, password);
	}

	@Override
	public boolean checkOldPassword(int userId, String oldPassword) {
		// TODO Auto-generated method stub
		return udao.checkOldPassword(userId, oldPassword);
	}

	@Override
	public boolean changePassword(int userId, String newPassword) {
		// TODO Auto-generated method stub
		return udao.changePassword(userId, newPassword);
	}

}
