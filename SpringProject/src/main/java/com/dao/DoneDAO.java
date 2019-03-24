package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.DoneDTO;

@Repository
public class DoneDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public int doneAllDel(List<String> list) {
		int n = session.delete("DoneMapper.doneAllDel", list);
		return n;
	}
	
	public DoneDTO donebygCode(String gCode) {
		DoneDTO cdto = session.selectOne("DoneMapper.donebygCode",gCode);
		return cdto;
	}

	public List<DoneDTO> retrieveUpdate(String gCode) {
		List<DoneDTO> list = session.selectList("DoneMapper.retrieveUpdate",gCode);
	   return list;
	}
	

	public int doneDel(String gCode) {
		int n = session.delete("DoneMapper.doneDel",gCode);
		return n;
	}
	
	public List<DoneDTO> doneList(String userid) {
		List<DoneDTO> list = session.selectList("DoneMapper.doneList", userid);
		return list;
	}

}
