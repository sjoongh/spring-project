package com.bitacademy.myportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.exception.UserDaoException;
import com.bitacademy.myportal.repository.UserDao;
import com.bitacademy.myportal.repository.UserVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDaoImpl;
	
	@Override
	public boolean join(UserVo vo) throws UserDaoException {
		int insertedCount = userDaoImpl.insert(vo);
		// 정상 동작시 insertedCount == 1이여야 함
		return 1 == insertedCount;
	}

	@Override
	public UserVo getUser(String email, String password) {
		UserVo userVo = userDaoImpl.selectUser(email, password);
		return userVo;
	}

	@Override
	public UserVo getUser(String email) {
		UserVo userVo = userDaoImpl.selectUser(email);
		return userVo;
	}
	
	@Override
	public boolean loginupdate(UserVo vo) {
		int updatedCount = userDaoImpl.updateUser(vo);
		return 1 == updatedCount;
	}

}
