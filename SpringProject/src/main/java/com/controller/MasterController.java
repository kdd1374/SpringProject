package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;
import com.service.MemberService;

@Controller
public class MasterController {

	@Autowired
	GoodsService gservice;
	
	@Autowired
	MemberService mservice;
	
	
	@RequestMapping("/g/goodsUpdate")
	public ModelAndView goodsUpdate(@RequestParam(value="curpage", required=false) String cur,
			@RequestParam(required=false) String gCategory,
			HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		ModelAndView mav = new ModelAndView();
		List<GoodsDTO> list = null;
		int curpage = 0;
		int purpage = 20;
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
		int g = 0;
		if(cur==null) {
			curpage=1;
		}else {
			curpage = Integer.parseInt(cur);
		}
		if(gCategory==null) {
			list = gservice.goodsAll();
			a = gservice.goodsTotal("toy");
			b = gservice.goodsTotal("send");
			c = gservice.goodsTotal("healthy");
			d = gservice.goodsTotal("rice");
			e = gservice.goodsTotal("snack");
			f = gservice.goodsTotal("tower");
			g = gservice.goodsTotal("scratcher");
		}else {
			list = gservice.goodsList(gCategory, curpage, purpage);
			a = gservice.goodsTotal("toy");
			b = gservice.goodsTotal("send");
			c = gservice.goodsTotal("healthy");
			d = gservice.goodsTotal("rice");
			e = gservice.goodsTotal("snack");
			f = gservice.goodsTotal("tower");
			g = gservice.goodsTotal("scratcher");
		}
		mav.setViewName("goodsUpdate");
		mav.addObject("goodsAll", list);
		mav.addObject("toy", a);
		mav.addObject("send", b);
		mav.addObject("healthy", c);
		mav.addObject("rice", d);
		mav.addObject("snack", e);
		mav.addObject("tower", f);
		mav.addObject("scratcher", g);
		
		return mav;
	}
	
	@RequestMapping("/g/memberList")
	public ModelAndView memberList(@RequestParam(value="curpage",required=false) String cur) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, String> map = new HashMap<String, String>();
		int curpage = 0;
		int purpage = 10;
		if(cur==null) {
			curpage=1;
		}else {
			curpage=Integer.parseInt(cur);
		}
		
		int total = mservice.total(map)/purpage;
		if(total%purpage != 0 || total<1) {
			total++;
		}
		System.out.println(mservice.total(map));
		System.out.println(total);
		List<MemberDTO> mdto = mservice.selectAll(curpage, purpage);
		mav.addObject("curpage", curpage);
		mav.addObject("total", total);
		mav.addObject("memberlistdto", mdto);
		mav.setViewName("memberList");
		
		return mav;
	}
	
	@RequestMapping("/g/memberListForm")
	public ModelAndView memberListForm(@RequestParam(value="curpage", required=false) String cur,
			@RequestParam String serch, @RequestParam String nameOrId) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, String> map = new HashMap<String, String>();
		List<MemberDTO> list = null;
		int curpage = 0;
		int purpage = 10;
		if(cur ==null) {
			curpage = 1;
		}else {
			curpage = Integer.parseInt(cur);
		}
		if(nameOrId.equals("id")) {
			map.put("userid",serch);
			list = mservice.memberListSerch(map, curpage, purpage);
		}else if(nameOrId.equals("name")) {
			map.put("username", serch);
			list=mservice.memberListSerch(map,curpage,purpage);
		}
		int total = mservice.total(map)/purpage;
		if(mservice.total(map)%purpage != 0) {
			total++;
		}
		mav.addObject("nameOrID", nameOrId);
		mav.addObject("serch", serch);
		mav.addObject("curpage", curpage);
		mav.addObject("total", total);
		mav.addObject("memberlistdto", list);
		mav.setViewName("memberList");
		return mav;
	}
	
}
