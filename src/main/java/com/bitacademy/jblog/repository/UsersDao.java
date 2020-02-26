package com.bitacademy.jblog.repository;

public interface UsersDao {
	public int insert(UserVo vo); //가입
	public int party(UserVo vo); // 가입과 동시에 블로그생성(?)
	public UserVo selectUser(String id); //중복 검사용
	public UserVo selectUser(String id, String password); //로그인용
	public Long getPk();
}
