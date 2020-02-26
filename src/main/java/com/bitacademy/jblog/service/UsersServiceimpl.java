package com.bitacademy.jblog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.controller.UsersController;
import com.bitacademy.jblog.repository.UserVo;
import com.bitacademy.jblog.repository.UsersDao;
@Service("usersService")
public class UsersServiceimpl implements UsersService {
	public static final Logger logger = LoggerFactory.getLogger(UsersServiceimpl.class);
	
	@Autowired
	UsersDao usersDao;
	@Override
	public boolean join(UserVo vo) {
		//	usersDao pk 얻어와서 Long에 담아
		Long no = usersDao.getPk();
		vo.setUserNo(no);
		int insertedCount = usersDao.insert(vo);
		logger.debug("inserted UserVo");
		int partiedCount = usersDao.party(vo);
		logger.debug("joined Blog");
		return insertedCount == 1 && partiedCount == 1;
	}

	@Override
	public UserVo getUser(String id, String password) {
		UserVo vo = usersDao.selectUser(id, password);
		return vo;
	}

	@Override
	public UserVo getUser(String id) {
		UserVo vo = usersDao.selectUser(id);
		return vo;
	}

}
