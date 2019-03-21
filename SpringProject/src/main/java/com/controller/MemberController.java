package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService ser;
	
	
	@RequestMapping("loginForm")
	public String login(@RequestParam Map<String, Object> map,
			HttpSession session) {
		MemberDTO dto = ser.idCheck(map);
		String nextPage = "";
		if(dto!=null) {
			session.setAttribute("logindto", dto);
			nextPage = "main";
		}else {
			String mesg = "회원정보가 틀렸습니다.";
			System.out.println(mesg);
			session.setAttribute("loginmesg", mesg);
			nextPage = "login";
		}
		return nextPage;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main";
	}
	
	@RequestMapping("memberAdd")
	public String memberAdd(MemberDTO dto, HttpSession session) {
		int n = ser.memberSignup(dto);
		if(n!=0) {
			session.setAttribute("memberAdd", "회원가입성공");
		}
		session.setMaxInactiveInterval(5);
		return "redirect:/main";
	}
	
	@RequestMapping("signupIdCheck")
	public @ResponseBody String signupIdCheck(@RequestParam String userid) {
		int n = ser.signUpCheck(userid);
		String mesg = "";
		if(n==0) {
			mesg="o";
		}else {
			mesg="x";
		}
		return mesg;
	}
	
	@RequestMapping("/m/mypage")
	public String mypage() {
		return "mypage";
	}
	
	@RequestMapping("/m/memberUpdate")
	public ModelAndView memberUpdate(MemberDTO dto, HttpSession session,
			@RequestParam String email) {
		String [] e = email.split("@");
		String email1= e[0];
		String email2 = e[1];
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		int n = ser.memberUpdate(dto);
		MemberDTO ldto = ser.idSerch(dto.getUserid());
		ModelAndView mav = new ModelAndView();
		if(n ==1) {
			String mesg = "정보가 수정되었습니다.";
			session.setAttribute("logindto", ldto);
			mav.setViewName("mypage");
			mav.addObject("upmesg", mesg);
		}
		return mav;
	}
	
	@RequestMapping("/m/memberDelForm")
	public String memberDelForm() {
		return "memberDelForm";
	}
	
	@RequestMapping("/m/memberDel")
	public ModelAndView memberDel(@RequestParam String password,
			HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		ModelAndView mav = new ModelAndView();
		String mesg="";
		if(dto.getPassword().equals(password)) {
			int n = ser.memberDel(dto.getUserid());
			mesg = "회원탈퇴가 무사회 완료되었습니다.";
			session.removeAttribute("logindto");
			mav.setViewName("redirect:/main");
			mav.addObject("delmesg", mesg);
		}else {
			mesg="비밀번호를 확인해주세요";
			mav.setViewName("memberDelForm");
			mav.addObject("delmesg", mesg);
		}
		return mav;
	}
	
}
