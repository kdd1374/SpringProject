package com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.GoodsDTO;

@Repository
public class CompanyDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<GoodsDTO> companyList(Map<String,String> map){
		System.out.println(map);
		List<GoodsDTO> list = session.selectList("CompanyMapper.ctyList",map);
		return list;
	}

}
