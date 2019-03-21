package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.MemberDTO;


@Repository
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public MemberDTO idCheck(Map<String, Object> map) {
		MemberDTO dto = session.selectOne("MemberMapper.idCheck", map);
		return dto;
	}
	
	public List<MemberDTO> selectAll(int curpage, int purpage) {
		int offset = (curpage-1)*purpage;
		List<MemberDTO> list = session.selectList("MemberMapper.selectAll",null,new RowBounds(offset, purpage));
		return list;
	}
	
	public int signUpCheck(String userid) {
		int n = session.selectOne("MemberMapper.signUpCheck", userid);
		return n;
	}
	
	public int memberSignup(MemberDTO dto) {
		int n = session.insert("MemberMapper.memberSignup", dto);
		return n;
	}
	
	public int memberDel(String userid) {
		int n = session.delete("MemberMapper.memberDel", userid);
		return n;
	}
	public int memberUpdate(MemberDTO dto) {
		int n = session.update("MemberMapper.memberUpdate", dto);
		return n;
	}
	
	public MemberDTO idSerch(String userid) {
		MemberDTO dto = session.selectOne("MemberMapper.idSerch", userid);
		return dto;
	}
	
	public List<MemberDTO> memberListSerch(Map<String, String> map, int curpage, int purpage) {
		int offset = (curpage-1)*purpage;
		List<MemberDTO> list = session.selectList("MemberMapper.memberListSerch", map,new RowBounds(offset, purpage));
		return list;
	}
	
	public int total(Map<String, String> map) {
		int n = session.selectOne("MemberMapper.total",map);
		return n;
	}
	
	public MemberDTO idSearch(Map<String, String> map) {
		MemberDTO dto = session.selectOne("MemberMapper.idSearch", map);
		return dto;
	}
	
	public int passwordUpdate(Map<String, String> map) {
		int n = session.update("MemberMapper.passwordUpdate", map);
		return n;
	}
	
	public MemberDTO passSearch(Map<String, String> map) {
		MemberDTO dto = session.selectOne("MemberMapper.passSearch", map);
		return dto;
	}
}
