package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CartDAO;
import com.dto.CartDTO;
import com.dto.DoneDTO;
import com.dto.GoodsDTO;


@Service
public class CartService {

	@Autowired
	CartDAO dao;
	


	public List<CartDTO> orderAllConfirm(List<String> list) {
		List<CartDTO> n = null;
			n = dao.orderAllConfirm(list);
		return n;
	}// 전체주문확인

	public int cartAllDel(List<String> list) {
		int n = 0;
			n = dao.cartAllDel(list);
		return n;
	}// end deleteAll

	public CartDTO cartbygCode(String gCode) {
		CartDTO cdto = null;
			cdto = dao.cartbygCode(gCode);
		return cdto;
	}// end idCheck

	public List<CartDTO> retrieveUpdate(Map<String, Object> map) {
		List<CartDTO> list = null;
			list = dao.retrieveUpdate(map);
		return list;
	}// retrieve select
	
	public List<GoodsDTO> retrieveOrder(String gCode) {
		List<GoodsDTO> list = null;
			list = dao.retrieveOrder(gCode);
		return list;
	}// retrieve select

	public int cartUpdate(Map<String, Object> map) {
		int n = 0;
			n = dao.cartUpdate(map);
		return n;
	}// end cartUpdate

	public int cartDel(String gCode) {
		int n = 0;
			n = dao.cartDel(gCode);
		return n;
	}// del

	public List<CartDTO> cartList(String userid) {
		List<CartDTO> list = null;
			list = dao.cartList(userid);
		return list;
	}// end list

	public int cartAdd(CartDTO dto) {
		int n = 0;
			n = dao.cartAdd(dto);
		return n;
	}// end cartAdd

}// end class
