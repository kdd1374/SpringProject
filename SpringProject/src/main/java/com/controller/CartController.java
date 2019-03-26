package com.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.DoneDTO;
import com.dto.MemberDTO;
import com.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	CartService ser;
	
	@RequestMapping("/m/cartList")
	public ModelAndView cartList(HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		List<CartDTO> list = ser.cartList(dto.getUserid());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cartList");
		mav.addObject("cartList", list);
		
		return mav;
	}
	
	@RequestMapping("/m/cartUpdate")
	public String cartUpdate(@RequestParam Map<String, Object> map) {
		System.out.println(map);
		int n = ser.cartUpdate(map);
		return "cartList";
	}
	
	@RequestMapping("/m/cartDel")
	public String cartDel(@RequestParam String gCode) {
		int n = ser.cartDel(gCode);
		return "cartList";
	}
	
	@RequestMapping("/m/cartDelAll")
	public String cartDelAll(String [] check) {
		System.out.println(check);
		return "cartList";
	}
	
	@RequestMapping("/m/cartOrderConfirm")
	public String cartOrderConfirm(@RequestParam Map<String, Object> map,
			HttpSession session) {
		System.out.println(map);
		List<CartDTO> list = ser.retrieveUpdate(map);
		session.setAttribute("cList", list);
		return "orderConfirm";
	}
	
	@RequestMapping("/m/cartOrderAllConfirm")
	@ModelAttribute("cartList")
	public String cartOrderAllConfirm(List<String> check) {
		List<CartDTO> list = ser.orderAllConfirm(check);
		return "orderAllConfirm";
	}
	
	@RequestMapping("/m/goodsCart")
	public String goodsCart(CartDTO dto,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gCode",dto.getgCode());
		map.put("userid",dto.getUserid());
		List<CartDTO> list = ser.retrieveUpdate(map);
		if(list.size()!=0) {
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("gCode",dto.getgCode());
			map2.put("gAmount",dto.getgAmount()+list.get(0).getgAmount());
			System.out.println(map2);
			int n = ser.cartUpdate(map2);
		}else if(list.size() ==0) {
			int n =ser.cartAdd(dto);
		}
		
		session.setAttribute("mesgcart", dto.getgCode()+"Cart저장성공");
		return "goodsRetrieve";
	}
	
	@RequestMapping("/m/cartOrderDone")
	public String cartOrderDone(@ModelAttribute("orderDTO") DoneDTO dto) {
		int n = ser.orderDone(dto, dto.getgCode());
		return "orderDone";
	}
	

}
