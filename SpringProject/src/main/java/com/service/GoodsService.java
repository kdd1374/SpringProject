package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDAO;
import com.dto.GoodsDTO;

@Service
public class GoodsService {

	@Autowired
	GoodsDAO dao;
	
	public List<GoodsDTO> goodsList(String gCategory,int curpage, int purpage) {
		List<GoodsDTO> list = null;
			list = dao.goodsList(gCategory, curpage, purpage);
		return list;
	}
	
	public List<GoodsDTO> goodsAll(){
		List<GoodsDTO> list = null;
			list = dao.goodsAll();
		return list;
	}
	public GoodsDTO codeSerch(String gCode){
		GoodsDTO list = null;
			list = dao.codeSerch(gCode);
		return list;
	}
	
	public int adminUpdateForm(GoodsDTO dto) {
		int n = 0;
			n = dao.adminUpdateForm(dto);
		return n;
	}
	public int adminInsert(GoodsDTO dto) {
		int n = 0;
			n = dao.adminInsert(dto);
		return n;
	}
	
	public int goodsTotal(String gCategory) {
		int n = 0;
			n = dao.goodsTotal(gCategory);
		return n;
	}
}
