package com.controller;

import java.util.ArrayList;
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
import com.service.DoneService;

@Controller
public class CartController {
	
	@Autowired
	CartService ser;
	
	@Autowired
	DoneService dser;
	
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
		List<String> list = Arrays.asList(check);
		int n = ser.cartAllDel(list);
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
	public ModelAndView cartOrderAllConfirm(String [] check) {
		List<String> list = Arrays.asList(check);
		List<CartDTO> clist = ser.orderAllConfirm(list);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("orderAllConfirm");
		mav.addObject("cartList", clist);
		return mav;
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
		return "redirect:/goodsRetrieve/"+dto.getgCode();
	}
	
	@RequestMapping("/m/cartOrderDone")
	public String cartOrderDone(@ModelAttribute("orderDTO") DoneDTO dto) {
		int n = ser.orderDone(dto, dto.getgCode());
		return "orderDone";
	}
	
	@RequestMapping("/m/orderListDetail")
	public ModelAndView orderListDetail(HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		List<DoneDTO> list =dser.doneList(dto.getUserid());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("orderListDetail");
		mav.addObject("doneList", list);
		return mav;
	}
	
	@RequestMapping("/m/doneDel")
	public String doneDel(@RequestParam String gCode) {
		int n = dser.doneDel(gCode);
		return "orderListDetail";
	}
	
	@RequestMapping("/m/doneDelAll")
	public String doneDelAll(String [] check) {
		List<String> list = Arrays.asList(check);
		int n = dser.doneAllDel(list);
		return "orderListDetail";
	}
	
	@RequestMapping("/m/cartOrderAllDone")
	public ModelAndView cartOrderAllDone(@RequestParam(required=false) List<DoneDTO> dlist,
			String [] gCode) {
		System.out.println(dlist);
		System.out.println(gCode[0]);
		List<String> list = Arrays.asList(gCode);
		List<DoneDTO> olist = new ArrayList<DoneDTO>();
		int n = ser.oderAllDone(dlist, list);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("orderAllDone");
		mav.addObject("orderAllDone", dlist);
		return mav;
	}

}
