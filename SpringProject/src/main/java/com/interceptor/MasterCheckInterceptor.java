package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dto.MemberDTO;

public class MasterCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		if(dto != null) {
		if(dto.getMas()==null) {
			
			response.sendRedirect("../login");// /m을 없애기 위해 한칸올라가서 찾는다.
			return false;
		}
		}else {
			response.sendRedirect("../login");// /m을 없애기 위해 한칸올라가서 찾는다.
			return false;
		}
		return true;
	}

	
	
}
