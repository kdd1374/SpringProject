package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.FavorDTO;

@Repository
public class FavorDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<FavorDTO> retrieveFavor( String gCode) {
		List<FavorDTO> list = session.selectList("FavorMapper.retrieveFavor",gCode);
	   return list;
	}
	
	public int favorDel(String gCode) {
		int n = session.delete("FavorMapper.favorDel",gCode);
		return n;
	}
	
	public List<FavorDTO> favorList(String userid) {
		List<FavorDTO> list = session.selectList("FavorMapper.favorList", userid);
		return list;
	}

	public int favorAdd(FavorDTO dto) {
		int n = session.insert("FavorMapper.favorAdd", dto);
		return n;
	}

}
