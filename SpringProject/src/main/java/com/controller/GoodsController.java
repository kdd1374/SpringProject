package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	GoodsService service;

	
	
	@RequestMapping("/goodsList/gCategory/{gCategory}/{curpage}")
	public String goodsList(
			@PathVariable(name="gCategory",required=false) String gCategory,
			@PathVariable(name="curpage",required=false) int curpage,
			@RequestParam (value="purpage",defaultValue="12") int purpage ,
			HttpServletRequest request,HttpSession session) {
		
		if(gCategory == null) {
			gCategory = "rice";
		}
		purpage = 12;
		int total = service.goodsTotal(gCategory)/purpage;//12개출력
		if(service.goodsTotal(gCategory)%purpage != 0) {
			total++;
		}
		
		List<GoodsDTO> list = service.goodsList(gCategory, curpage, purpage);
		request.setAttribute("goodsList", list);
		request.setAttribute("goodsTotal", total);
		request.setAttribute("curpage", curpage);
		request.setAttribute("category", gCategory);
		return "goodsList";
	}//리스트 페이징 처리
	
	@RequestMapping("/goodsRetrieve/{gCode}") //goodsRetrieve.jsp
	public ModelAndView goodsRetrieve(
			@PathVariable(name="gCode",required=false) String gCode) {
		GoodsDTO dto = service.codeSerch(gCode);
		if(dto==null || gCode.length() ==0) {
			dto = (GoodsDTO) service.goodsAll();
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("goodsRetrieve");
		mav.addObject("goodsRetrieve", dto);
		
		return mav;
	}

	@RequestMapping("/goodsSearch/{gName}") //goodsRetrieve.jsp
	public ModelAndView goodsSearch(
			@PathVariable (name="gName",required=false) String gName) {
		List<GoodsDTO> list = service.goodsSearch(gName);
		if(list==null || list.size()==0) {
			list = service.goodsAll();
		}
		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("goodsList");
		mav.addObject("goodsList", list);
		
		return mav;
	}
	

	
	
}
