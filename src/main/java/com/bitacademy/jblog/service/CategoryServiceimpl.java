package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.CategoryDao;
import com.bitacademy.jblog.repository.CategoryVo;
@Service
public class CategoryServiceimpl implements CategoryService {
	@Autowired 
	CategoryDao categoryDaoimpl;
	@Override
	public List<CategoryVo> getList() {
		List<CategoryVo> list = categoryDaoimpl.selectAll();
		return list;
	}

	@Override
	public boolean write(CategoryVo vo) {
		int insertedCount = categoryDaoimpl.insert(vo);
		return insertedCount == 1;
	}

}
