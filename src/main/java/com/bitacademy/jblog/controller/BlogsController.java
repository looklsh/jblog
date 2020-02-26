package com.bitacademy.jblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.jblog.repository.BlogDao;
import com.bitacademy.jblog.repository.BlogVo;
import com.bitacademy.jblog.repository.UserVo;
import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.BlogServiceimpl;

@Controller
@RequestMapping("/")//블로그 첫화면
public class BlogsController { 
	@Autowired
	BlogServiceimpl blogServiceimpl;
	@Autowired
	BlogDao blogDaoimpl;
	
	@RequestMapping("/{id}")
	public ModelAndView blogs() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userName", "${userName}");
		mav.setViewName("main");
		
		return mav;
	} 
	
	
	@RequestMapping(value="/{id}/admin/basic", method=RequestMethod.GET)//블로그 기본설정화면
	public String admin(@PathVariable("id") String id, Model model) {
		BlogVo blog = blogDaoimpl.getBlog(id);
//		BlogVo blog = 
		//	Blog 정보를 가져와서 -> 모델에 setAttribute
		
		model.addAttribute("blog", blog);
		return "blog/basic";
	}
	
	@RequestMapping(value="/{id}/admin/basic", method=RequestMethod.POST)//블로그 기본설정변경 화면
	public String adminUpdate(@RequestParam("blogTitle")String blogTitle, @RequestParam("real")MultipartFile real, 
								@PathVariable("id") String id, HttpSession session, Model model) {	
		//	BlogVo vo = new BlogVo();
		//	vo.setUserNo(세션에서 userNo);
		//	vo.setBlogTitle(RequestParameter로부터 blogTitle);
		//	vo.setLogoFile(파일 업로드 서비스를 통해 생성된 파일명);
		//	vo -> update 쿼리 수행
//		BlogVo vo = new BlogVo();
		BlogVo vo = blogDaoimpl.getBlog(id);
		System.out.println("Blog Info:" + vo);
//		UserVo user = (UserVo)session.getAttribute("authUser");
//		vo.setUserNo(user.getUserNo());
		vo.setBlogTitle(blogTitle);
		//	문제 1. real Multipart 안넘어오면 저장 하면 안된다
		//	문제 2. 파일명 그대로 둬야 
		
		if (real.getSize() > 0) { //	파일이 있다
			String uploadFilename = blogServiceimpl.store(real);
			model.addAttribute("imageFileName", uploadFilename);
			vo.setLogoFile(uploadFilename);
		}
		blogDaoimpl.update(vo);
//		UserVo user = (UserVo)session.getAttribute("authUser");
//		user.getUserNo();
		
//		((UserVo)session.getAttribute("authUser")).getUserNo();
		
		return "redirect:/"+id+"/admin/basic";
	}
	
	
}
