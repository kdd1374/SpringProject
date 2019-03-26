package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.NoticeDTO;
import com.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService service;
	
	@RequestMapping("/m/notice/{curpage}")
	public String noticeList(NoticeDTO noticeDto,
			@PathVariable(name="curpage" , required=false) int curpage,
			@RequestParam(value="purpage",defaultValue="10")int purpage,
			HttpServletRequest request, HttpSession session) {
		System.out.println("cccc" + noticeDto);
		purpage = 10;
		int total = service.totalRecord(noticeDto)/purpage;
		if(service.totalRecord(noticeDto)%purpage !=0) {
			total++;
		}
		List<NoticeDTO> list = service.noticeList(noticeDto, curpage, purpage);
		request.setAttribute("noticelist", list);
		request.setAttribute("total", total);
		request.setAttribute("curpage", curpage);
		request.setAttribute("noticeDto", noticeDto);
		return "noticeMove";
		
	}
	
	
	@RequestMapping("/m/noticeDetail")
	public ModelAndView noticeDetail(HttpServletRequest request, NoticeDTO noticeDto){
		ModelAndView mav = new ModelAndView();
		
		try {
			
			NoticeDTO noticeDetail = service.noticeDetail(noticeDto);
			System.out.println(noticeDetail);
			mav.setViewName("noticeDetailMove");
			mav.addObject("noticeDetail", noticeDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return mav;
	}
	
	@RequestMapping("/m/noticeAdd")
	public String noticeAdd(NoticeDTO noticeDto,
			HttpSession session) {
			int n = service.noticeAdd(noticeDto);
			System.out.println(noticeDto);
	 session.setAttribute("noticeAdd", "등록되었습니다");
		return "noticeMove";
		
	}
	
	@RequestMapping("/m/noticeAddMove")
	public String noticeAddMove() {
		
		return "noticeAddMove";
	}
	

}
