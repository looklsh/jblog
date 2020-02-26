package com.bitacademy.jblog.repository;

public interface BlogDao {
	public BlogVo getBlog(String id);
	public int update(BlogVo vo);
}
