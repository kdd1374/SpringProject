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
import com.service.CartService;
import com.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	GoodsService service;
	
	@Autowired
	CartService cService;
	
	
	@RequestMapping("/goodsList/gCategory/{type}/{curpage}")
	public String goodsList(
			@PathVariable(name="type",required=false) String gCategory,
			@PathVariable(name="curpage",required=false) int curpage,
			@RequestParam (value="purpage",defaultValue="12") int purpage ,
			HttpServletRequest request,HttpSession session) {
		System.out.println(curpage);
		if(gCategory == null) {
			gCategory = "rice";
		}
		purpage = 12;
		int total = service.goodsTotal(gCategory)/purpage;
		if(service.goodsTotal(gCategory)%purpage != 0) {
			total++;
		}
		
		List<GoodsDTO> list = service.goodsList(gCategory, curpage, purpage);
		request.setAttribute("goodsList", list);
		request.setAttribute("goodsTotal", total);
		request.setAttribute("curpage", curpage);
		request.setAttribute("category", gCategory);
		request.setAttribute("goodsList", list);
		return "goodsList";
	}//리스트 페이징 처리
	
	@RequestMapping("/goodsRetrieve/{gCode}") //goodsRetrieve.jsp
	public ModelAndView goodsRetrieve(
			@PathVariable(name="gCode",required=false) String gCode) {
		GoodsDTO dto = service.codeSerch(gCode);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("goodsRetrieve");
		mav.addObject("goodsRetrieve", dto);
		
		return mav;
	}

//	@RequestMapping("/m/goodsCart") //goodsRetrieve.jsp
//	public String goodsCart(CartDTO dto , HttpSession session) {
//		
//		 MemberDTO x = (MemberDTO)session.getAttribute("login");
//		 dto.setUserid(x.getUserid());
//		 int n = cService.cartAdd(dto);
//		 
//		String nextPage = "redirect:/goodsRetrieve?gCode="+dto.getgCode();
//		session.setAttribute("mesg",dto.getgCode()+" Cart저장성공" );
//		return nextPage;
//	}
//	@RequestMapping("/m/cartList") //goodsRetrieve.jsp
//	public ModelAndView cartList(HttpSession session) {
//		
//		 MemberDTO x = (MemberDTO)session.getAttribute("login");
//		 String userid = x.getUserid();
//	     List<CartDTO> list = cService.cartList(userid);
//		 
//	     ModelAndView mav = new ModelAndView();
//	     mav.setViewName("cartList");
//	     mav.addObject("cartList", list);
//		return mav;
//	}
//	
//	
//	@RequestMapping("/m/cartUpdate") //goodsRetrieve.jsp
//	public @ResponseBody String cartUpdate( @RequestParam Map<String, Integer>map) {
//		 int n= cService.cartUpdate(map);
//		return "success";
//	}
//	
//	@RequestMapping("/m/cartDel") //goodsRetrieve.jsp
//	public @ResponseBody String cartDel( @RequestParam ("num") int num) {
//		 int n =cService.cartDel(num);
//		return "success";
//	}
	
	
	
	
	
	
}
