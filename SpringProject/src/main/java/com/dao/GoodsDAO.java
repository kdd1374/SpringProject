package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.GoodsDTO;

@Repository
public class GoodsDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<GoodsDTO> goodsList(String gCategory, int curpage, int purpage) {
		int offset = (curpage-1)*purpage;
		List<GoodsDTO> list = session.selectList("GoodsMapper.goodsList", gCategory,new RowBounds(offset, purpage));
		return list;
	}//페이징
	
	public List<GoodsDTO> goodsAll(){
		List<GoodsDTO> list = session.selectList("GoodsMapper.goodsAll");
		return list;
	}
	
	public GoodsDTO codeSerch(String gCode){
		GoodsDTO list = session.selectOne("GoodsMapper.codeSerch", gCode);
		return list;
	}
	
	public int adminUpdateForm(GoodsDTO dto) {
		int n = session.update("GoodsMapper.adminUpdateForm", dto);
		return n;
	}//수량변경
	
	public int adminInsert(GoodsDTO dto) {
		int n = session.insert("GoodsMapper.adminInsert", dto);
		return n;
	}//추가
	
	public int goodsTotal(String gCategory) {
		int n = session.selectOne("GoodsMapper.goodsTotal", gCategory);
		return n;
	}//갯수
	
	public List<GoodsDTO> goodsSearch(String gName) {
		List<GoodsDTO> list = session.selectList("GoodsMapper.goodsSearch", gName);
		return list;
	}
}
