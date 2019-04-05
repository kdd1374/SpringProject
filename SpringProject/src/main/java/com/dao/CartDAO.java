package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.DoneDTO;
import com.dto.GoodsDTO;


@Repository
public class CartDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	

	
	public List<CartDTO> orderAllConfirm(List<String> list) {
		List<CartDTO> n = session.selectList("CartMapper.orderAllConfirm", list);
		return n;
	}
	
	public int cartAllDel(List<String> list) {
		int n = session.delete("CartMapper.cartAllDel", list);
		return n;
	}
	
	public CartDTO cartbygCode(String gCode) {
		CartDTO cdto = session.selectOne("CartMapper.cartbygCode",gCode);
		return cdto;
	}
	
	public List<CartDTO> retrieveUpdate(Map<String, Object> map) {
		List<CartDTO> list = session.selectList("CartMapper.retrieveUpdate",map);
	   return list;
	}
	
	public List<GoodsDTO> retrieveOrder(String gCode) {
		List<GoodsDTO> list = session.selectList("CartMapper.retrieveOrder",gCode);
	   return list;
	}
	
	public int cartUpdate(Map<String, Object> map) {
		int n = session.update("CartMapper.cartUpdate", map);
		return n;
	}

	public int cartDel(String gCode) {
		int n = session.delete("CartMapper.cartDel",gCode);
		return n;
	}
	
	public List<CartDTO> cartList(String userid) {
		List<CartDTO> list = session.selectList("CartMapper.cartList", userid);
		return list;
	}

	public int cartAdd(CartDTO dto) {
		int n = session.insert("CartMapper.cartAdd", dto);
		return n;
	}

}
