package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DoneDAO;
import com.dto.DoneDTO;

@Service
public class DoneService {
	
	@Autowired
	DoneDAO dao;
	
	public int doneAllDel(List<String> list) {
		int n = 0;
			n = dao.doneAllDel(list);
		return n;
	}// end deleteAll
	
	public DoneDTO donebygCode( String gCode) {
		DoneDTO cdto = null;
			 cdto = dao.donebygCode(gCode);
		return cdto;
	}//end idCheck
	
	
	public List<DoneDTO> retrieveUpdate(String gCode) {
		List<DoneDTO> list = null;
			list = dao.retrieveUpdate(gCode);
		return list;
	}//retrieve select
	
	
	public int doneDel(String orderday) {
		int n = 0;
			 n = dao.doneDel(orderday);

		return n;
	}//del
	
	 public List<DoneDTO> doneList(String userid) {
			List<DoneDTO> list = null;
				 list = dao.doneList(userid);
			return list;
		}//end list
	 
	

}// end class
