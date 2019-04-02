package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CompanyDAO;
import com.dto.GoodsDTO;

@Service
public class CompanyService {
	
	@Autowired
	CompanyDAO dao;
	
	
	
	public List<GoodsDTO> companyList(Map<String,String> map){
		List<GoodsDTO> list = dao.companyList(map);
		return list;
	}

}
