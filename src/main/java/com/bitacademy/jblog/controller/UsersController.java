package com.bitacademy.jblog.controller;

import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.jblog.exception.UsersDaoException;
import com.bitacademy.jblog.repository.BlogVo;
import com.bitacademy.jblog.repository.UserVo;
import com.bitacademy.jblog.service.UsersService;


@Controller
@RequestMapping("/user")
public class UsersController {
	
	public static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	//회원가입 로직
	@Autowired 
	UsersService usersService;
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinform(@ModelAttribute UserVo userVo) {
		return "users/joinform";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinAction(@ModelAttribute UserVo vo) {
		boolean isSuccess = false;
		try {
			isSuccess = usersService.join(vo);
		}catch(UsersDaoException e) {
			System.err.println("UsersDao 오류:" + e.getMessage());
			System.err.println("오류 발생 당시의 객체정보:" + e.getMessage());
		}
		if(isSuccess) {
			return "redirect:/user/joinsuccess";
		}else {
			return "redirect:/user/join";
		}
	}
	
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "users/joinsuccess";
	}
	
	//아이디 체크
	@ResponseBody
	@RequestMapping("/checkId")
	public Object checkId(@RequestParam String id) {
		UserVo vo = usersService.getUser(id);
		boolean isExists = vo != null;
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("exists", isExists);
		
		return map;
	}
	
	//로그인 로직
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginform() {
		return "users/loginform";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(@RequestParam(value="id", required=false)String id,
							@RequestParam(value="password", required=false)String password, HttpSession session) {
		if(id.length() == 0 || password.length() == 0) {
			System.err.println("로그인 불가");
			return "redirect:/user/login";
		}
		
		UserVo authUser = usersService.getUser(id, password);
//		BlogVo authBlog = blogsService.getUser(id, password);
		
		if(authUser == null) {
			return "redirect:/user/login";
		}else {
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		}
	}
		
	//로그아웃 로직
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutAction(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
