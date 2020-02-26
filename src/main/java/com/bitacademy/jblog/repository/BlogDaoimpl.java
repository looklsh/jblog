package com.bitacademy.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDaoimpl implements BlogDao {
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public int update(BlogVo vo) {
		int updatedCount = 0;
		System.out.println("Blog Update:" + vo);
		try {
			 updatedCount = sqlSession.update("blog.upTitleAndFile", vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return updatedCount;
	}
	@Override
	public BlogVo getBlog(String id) {
		BlogVo vo = sqlSession.selectOne("blog.getId", id);
		return vo;
	}

}
