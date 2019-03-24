package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.FavorDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.FavorService;
import com.service.GoodsService;

@Controller
public class FavorController {

	@Autowired
	FavorService service;
	
	@Autowired
	GoodsService gservice;
	
	@RequestMapping("/m/favorList") //favorList
	public String cartList(HttpSession session) {
		
		 MemberDTO x = (MemberDTO)session.getAttribute("logindto");
		        String userid =x.getUserid();
		        FavorService service =new FavorService();
		        List<FavorDTO> list = service.favorList(userid);

		        System.out.println("TTTTTTTTTTTTTTTT"+list);
		        
		        session.setAttribute("favorList", list);
		 
		return "favorList";
	}
	
	@RequestMapping("/m/favorAdd/{gCode}") //goodsRetrieve.jsp
	public String favorAdd(FavorDTO dto , HttpSession session, HttpServletRequest request,@PathVariable(name="gCode",required=false) String gCode
			,@RequestParam(value="gName",required=false) String gName) {
		
		GoodsDTO gdto = gservice.codeSerch(gCode);
		
		System.out.println(dto);
		System.out.println(gName);
		 int n = service.favorAdd(dto);
		session.setAttribute("mesg",dto.getgCode()+" Cart저장성공" );
		return "goodsRetrieve";
	}
	
}
