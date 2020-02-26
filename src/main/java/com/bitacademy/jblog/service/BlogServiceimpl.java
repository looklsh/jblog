package com.bitacademy.jblog.service; 

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.jblog.repository.BlogVo;
@Service
public class BlogServiceimpl implements BlogService {
	
	@Override
	public String store(MultipartFile mFile) {
		
		String originalFileName = mFile.getOriginalFilename();
		
		String extName = originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();
		Calendar cal = Calendar.getInstance();
		
		String savedFileName = String.valueOf(cal.getTimeInMillis()) + extName;
		
		try {
			writeFile(mFile, savedFileName);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return savedFileName;
	}
	
	private void writeFile(MultipartFile mFile, String savedFileName) throws IOException{
		byte[] fileData = mFile.getBytes();
		
		FileOutputStream fos = new FileOutputStream("/upload/" + savedFileName);
		fos.write(fileData);
		fos.close();
	}
	
	

}
