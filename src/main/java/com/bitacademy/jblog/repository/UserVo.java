package com.bitacademy.jblog.repository;

import java.util.Date;

public class UserVo {
	private Long userNo;
	private String userName;
	private String id;
	private String password;
	private Date joinDate;
	
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", userName=" + userName + ", id=" + id + ", password=" + password
				+ ", joinDate=" + joinDate + "]";
	}
	
	
	
}
