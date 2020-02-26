package com.bitacademy.jblog.exception;

import com.bitacademy.jblog.repository.UserVo;

public class UsersDaoException extends RuntimeException{
	private UserVo vo = null;
	
	public UsersDaoException() {
		super();
	}
	
	public UsersDaoException(String message) {
		super(message);
	}
	
	public UsersDaoException(String message, UserVo vo) {
		super(message);
		this.vo = vo;
	}

	public UserVo getVo() {
		return vo;
	}

	public void setVo(UserVo vo) {
		this.vo = vo;
	}

	@Override
	public String toString() {
		return "UsersDaoException [vo=" + vo + "]";
	}
	
	
}
