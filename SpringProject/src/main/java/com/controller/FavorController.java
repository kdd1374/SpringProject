package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.FavorDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.FavorService;
import com.service.GoodsService;

@Controller
public class FavorController {

	@Autowired
	FavorService service;
	
	
	@RequestMapping("/m/favorList")
	public ModelAndView favorList(HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		List<FavorDTO> list = service.favorList(dto.getUserid());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("favorList");
		mav.addObject("favorList", list);
		
		return mav;
	}
	
	@RequestMapping("/m/favorAdd/{gCode}") //goodsRetrieve.jsp
	public ModelAndView favorAdd(FavorDTO dto , HttpSession session, @PathVariable(name="gCode",required=false) String gCode) {
		MemberDTO mdto = (MemberDTO)session.getAttribute("logindto");
		List<FavorDTO> list = service.favorList(mdto.getUserid());

		System.out.println(list);
		if(list!=null && gCode.equals(list.get(0).getgCode()) ){

			session.setAttribute("mesgcart",dto.getgCode()+" 리스트에 있는 상품입니다" );
        }else {

			int n =service.favorAdd(dto);
			session.setAttribute("mesgcart",dto.getgCode()+" 리스트 저장성공" );
        }
		ModelAndView mav = new ModelAndView();
		mav.setViewName("goodsRetrieve");
		mav.addObject("goodsRetrieve", dto);
		
		return mav;
	}
//	@RequestMapping("/m/favorAdd/{gCode}")
//	public ModelAndView favorAdd(FavorDTO dto,
//			HttpSession session, @PathVariable(name="gCode",required=false) String gCode,HttpServletResponse response) {
//		System.out.println(gCode);
//		MemberDTO mdto = (MemberDTO)session.getAttribute("logindto");
//		List<FavorDTO> list = service.favorList(mdto.getUserid());
//		if(list.size()!=0) {
//
//			session.setAttribute("mesgcart",dto.getgCode()+" 리스트에 있는 상품입니다" );
//		}else if(list.size() ==0) {
//			int n =service.favorAdd(dto);
//		
//		
//		session.setAttribute("mesgcart", dto.getgCode()+"Cart저장성공");
//		}
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("goodsRetrieve");
//		mav.addObject("goodsRetrieve", list);
//		
//		return mav;
//	}
	
	
}
