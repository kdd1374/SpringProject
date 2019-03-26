package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FavorDAO;
import com.dto.FavorDTO;
import com.dto.GoodsDTO;

@Service
public class FavorService {
	
	@Autowired
	FavorDAO dao;
	
	public List<FavorDTO> retrieveFavor(String gCode) {
		List<FavorDTO> list = null;
			list = dao.retrieveFavor(gCode);
		return list;
	}//retrieve select
	
	
	
	public int favorDel(String gCode) {
		int n = 0;
			 n = dao.favorDel(gCode);
		return n;
	}//del
	
	 public List<FavorDTO> favorList(String userid) {
			List<FavorDTO> list = null;
				 list = dao.favorList( userid);
			return list;
		}//end list
	 
	public int favorAdd(FavorDTO dto) {
		int n = 0;
			n = dao.favorAdd( dto);
		return n;
	}// end cartAdd

}// end class
