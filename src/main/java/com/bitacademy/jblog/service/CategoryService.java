package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.repository.CategoryVo;

public interface CategoryService {
	public List<CategoryVo> getList();
	public boolean write(CategoryVo vo);
}
