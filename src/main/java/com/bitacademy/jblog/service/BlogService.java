package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.jblog.repository.BlogVo;

public interface BlogService {
	
	public String store(MultipartFile mFile);
	
}
