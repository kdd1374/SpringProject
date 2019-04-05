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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.DoneDTO;
import com.dto.GoodsDTO;
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
	public @ResponseBody String cartUpdate(@RequestParam Map<String, Object> map) {
		int n = ser.cartUpdate(map);
		return "cartUpdate";
	}
	
	@RequestMapping("/m/cartDel")
	public @ResponseBody String cartDel(@RequestParam String gCode) {
		int n = ser.cartDel(gCode);
		return "cartDel";
	}
	
	@RequestMapping("/m/cartDelAll")
	public String cartDelAll(String [] check) {
		List<String> list = Arrays.asList(check);
		int n = ser.cartAllDel(list);
		return "redirect:cartList";
	}
	
	@RequestMapping("/m/cartOrderConfirm")
	public String cartOrderConfirm(@RequestParam Map<String, Object> map,
			HttpSession session) {
		List<CartDTO> list = ser.retrieveUpdate(map);
		System.out.println(map+"TTTTTTTTTTTT"+list);
		session.setAttribute("cList", list);
		return "orderConfirm";
	}
	
	@RequestMapping("/m/retrieveOrder")
	public String retrieveOrder(@RequestParam String gCode,@RequestParam(defaultValue="1") int gAmount,
			HttpSession session) {
		List<GoodsDTO> list = ser.retrieveOrder(gCode);
		list.get(0).setgAmount(gAmount);
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
			int n = ser.cartUpdate(map2);
		}else if(list.size() ==0) {
			int n =ser.cartAdd(dto);
		}
		
		session.setAttribute("mesgcart", dto.getgCode()+"Cart저장성공");
		return "redirect:/goodsRetrieve/"+dto.getgCode();
	}
	
	@RequestMapping("/m/cartOrderDone")
	public String cartOrderDone(@ModelAttribute("orderDTO") DoneDTO dto) {
		int n = dser.orderDone(dto, dto.getgCode());
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
	public @ResponseBody String doneDel(@RequestParam String gCode) {
		int n = dser.doneDel(gCode);
		return "orderListDetail";
	}
	
	@RequestMapping("/m/doneDelAll")
	public String doneDelAll(String [] check) {
		List<String> list = Arrays.asList(check);
		int n = dser.doneAllDel(list);
		return "redirect:orderListDetail";
	}
	
	@RequestMapping("/m/cartOrderAllDone")
	public ModelAndView cartOrderAllDone(
			String [] gCode,
			@RequestParam(required=false) String userid,@RequestParam(required=false) String payMethod) {
		List<String> list = Arrays.asList(gCode);
		List<CartDTO> clist = ser.orderAllConfirm(list);
		System.out.println(clist);
		int n = dser.oderAllDone(clist, list);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("orderAllDone");
		mav.addObject("orderAllDone", clist);
		mav.addObject("payMethod", payMethod);
		return mav;
	}

}
