package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.GoodsDTO;
import com.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	CompanyService service;
	
	
	@RequestMapping("/ctyList")
	public ModelAndView xxx(@RequestParam Map<String,String> map) {
		List<GoodsDTO> list = service.companyList(map);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("goodsList");
		mav.addObject("goodsList", list);
		
		return mav;
		
	}
	

}
