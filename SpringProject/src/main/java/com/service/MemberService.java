package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.MemberDTO;
import com.dto.NaverDTO;

@Service
public class MemberService {

	
	@Autowired
	MemberDAO dao;
	
	public int naverInsert(Map<String, Object> map) {
		int n = dao.naverInsert(map);
		return n;
	}
	
	public List<NaverDTO> naverLogin(){
		List<NaverDTO> list = dao.naverLogin();
		return list;
	}
	
	public MemberDTO idCheck(Map<String, Object> map) {
		MemberDTO dto = new MemberDTO();
			dto = dao.idCheck(map);
		return dto;
	}
	
	public List<MemberDTO> selectAll(int curpage, int purpage) {
		List<MemberDTO> list = null;
			list = dao.selectAll(curpage, purpage);
		return list;
	}
	
	public int signUpCheck(String userid) {
		int n = 0;
			n = dao.signUpCheck(userid);
		return n;
	}
	public int memberSignup(MemberDTO dto) {
		int n = 0;
			n = dao.memberSignup(dto);
		return n;
	}
	
	public int memberDel(String userid) {
		int n = 0;
			n = dao.memberDel(userid);
		return n;
	}
	
	public int memberUpdate(MemberDTO dto) {
		int n = 0;
			n = dao.memberUpdate(dto);
		return n;
	}
	
	public MemberDTO idSerch(String userid) {
		MemberDTO dto = new MemberDTO();
			dto = dao.idSerch(userid);
		return dto;
	}
	
	public List<MemberDTO> memberListSerch(Map<String, String> map,int curpage, int purpage){
		List<MemberDTO> list = null;
			list = dao.memberListSerch(map, curpage, purpage);
		return list;
	}
	public int total(Map<String, String> map) {
		int n = 0;
			n = dao.total(map);
		return n;
	}
	
	public MemberDTO idSearch(Map<String, String> map) {
		MemberDTO dto = new MemberDTO();
			dto = dao.idSearch(map);
		return dto;
	}
	
	public int passwordUpdate(Map<String, String> map) {
		int n = 0;
			n = dao.passwordUpdate(map);
		return n;
	}
	
	public MemberDTO passSearch(Map<String, String> map) {
		MemberDTO dto = new MemberDTO();
			dto = dao.passSearch(map);
		return dto;
	}
}
