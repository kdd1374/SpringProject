package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartDAO;
import com.dto.CartDTO;
import com.dto.DoneDTO;


@Service
public class CartService {

	@Autowired
	
	public int oderAllDone(List<DoneDTO> x, List<String> gCodes) {
		int n = 0;
			n = dao.orderAllDone(x);
			n = dao.cartAllDel(gCodes);
		return n;
	}// end 주문완료

	public int orderDone(DoneDTO dto, String gCode) {
		int n = 0;
			n = dao.orderDone(dto);
			n = dao.cartDel(gCode);
		return n;
	}// end 주문완료

	public List<CartDTO> orderAllConfirm(List<String> list) {
		List<CartDTO> n = null;
			n = dao.orderAllConfirm(list);
		return n;
	}// 전체주문확인

	public int cartAllDel(List<String> list) {
		int n = 0;
			n = dao.cartAllDel(=list);
		return n;
	}// end deleteAll

	public CartDTO cartbygCode(String gCode) {
		CartDTO cdto = null;
			cdto = dao.cartbygCode(gCode);
		return cdto;
	}// end idCheck

	public List<CartDTO> retrieveUpdate(String gCode) {
		List<CartDTO> list = null;
			list = dao.retrieveUpdate(gCode);
		return list;
	}// retrieve select

	public int cartUpdate(HashMap<String, Object> map) {
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
