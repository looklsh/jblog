package com.bitacademy.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.exception.UsersDaoException;

@Repository("usersDao")
public class UsersDaoimpl implements UsersDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(UserVo vo) {
		//	user.getPk -> long (PK)
//		vo.setUserNo(userNo);
//		Long no = sqlSession.selectOne("user.getPk");
//		vo.setUserNo(no);
		int insertedCount = sqlSession.insert("user.insert", vo);
//		int partiedCount = sqlSession.insert("user.party", vo);
		return insertedCount;
	}

	@Override
	public UserVo selectUser(String id) {
		UserVo user = sqlSession.selectOne("user.selectById", id);
		return user;
	}

	@Override
	public UserVo selectUser(String id, String password) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("password", password);
		
		UserVo user = sqlSession.selectOne("user.selectByIdAndPassword", paramMap); 
		return user;
	}

	@Override
	public int party(UserVo vo) {
		int partiedCount = sqlSession.insert("user.party", vo);
		return partiedCount;
	}

	@Override
	public Long getPk() {
		Long no = sqlSession.selectOne("user.getPk");
		
		return no;
	}
	
}
