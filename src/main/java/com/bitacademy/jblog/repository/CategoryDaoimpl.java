package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CategoryDaoimpl implements CategoryDao {
	
	@Autowired
	SqlSession sqlSession;
	@Override
	public List<CategoryVo> selectAll() {
		List<CategoryVo> list = sqlSession.selectList("category.selectAll");
		return list;
	}

	@Override
	public int delete(CategoryVo vo) {
		int deletedCount = sqlSession.insert("category.delete", vo);
		return deletedCount;
	}

	@Override
	public int insert(CategoryVo vo) {
		int insertedCount = sqlSession.insert("category.insert", vo);
		return insertedCount;
	}

}
