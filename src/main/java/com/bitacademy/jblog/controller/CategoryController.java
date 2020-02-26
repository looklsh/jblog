package com.bitacademy.jblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.jblog.repository.BlogDao;
import com.bitacademy.jblog.repository.BlogDaoimpl;
import com.bitacademy.jblog.repository.BlogVo;
import com.bitacademy.jblog.repository.CategoryDao;
import com.bitacademy.jblog.repository.CategoryDaoimpl;
import com.bitacademy.jblog.repository.CategoryVo;
import com.bitacademy.jblog.repository.UserVo;
import com.bitacademy.jblog.service.CategoryService;



@Controller
@RequestMapping("/")
public class CategoryController {
	@Autowired
	CategoryDao categoryDaoimpl;
	@Autowired
	CategoryService categoryServiceimpl;
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	
	
	@RequestMapping(value="/{id}/admin/category", method=RequestMethod.GET)
	public String list(Model model ) {
		
//		List<CategoryVo> list = categoryDaoimpl.selectAll();
		List<CategoryVo> list = categoryServiceimpl.getList();
		model.addAttribute("list", list);
		logger.debug("list:" + list);
		return "category/list";
	}
	
	@RequestMapping(value="/{id}/admin/category", method=RequestMethod.POST)
	public String addCategory(@PathVariable("id") String id, @ModelAttribute CategoryVo vo, HttpSession session) {
		UserVo user = (UserVo)session.getAttribute("authUser");
//		Long userNo = user.getUserNo();
//		vo.setUserNo(userNo);
		vo.setUserNo(user.getUserNo());
		
		boolean isSuccess = categoryServiceimpl.write(vo);
		if(isSuccess) {
			List<CategoryVo> list = categoryServiceimpl.getList();
			return "redirect:/{id}/admin/category";
		}else {
			return "category/";
		}
		
	}
	
	
}
