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
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("/m/favorAdd") //goodsRetrieve.jsp
	public String favorAdd(FavorDTO dto , HttpSession session) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gCode",dto.getgCode());
		map.put("userid",dto.getUserid());
		
		List<FavorDTO> list = service.favorList(dto.getUserid());
		String gCode = (String) map.get("gCode");
		String xx =null;
		for (FavorDTO favorDTO : list) {
			System.out.println(favorDTO.getgCode());
			if(list.size()!=0 && gCode.equals(favorDTO.getgCode())) {
			xx=favorDTO.getgCode();break;
			}
	        }
		if(list.size()!=0 && gCode.equals(xx)) {
			session.setAttribute("mesgcart","해당 상품은 위시 리스트에 있는 상품입니다" );
		}else {
			int n =service.favorAdd(dto);
			session.setAttribute("mesgcart",dto.getgCode()+" 위시 리스트 저장성공" );
		}
		return "redirect:/goodsRetrieve/"+dto.getgCode();
	}
		
	@RequestMapping("/m/favorDel") //goodsRetrieve.jsp
	public @ResponseBody String favorDel( @RequestParam ("gCode") String gCode , HttpSession session) {
		 int n =service.favorDel(gCode);
		return "favorDel";
	}
	
	
}
