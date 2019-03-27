package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.NoticeDTO;

@Repository
public class NoticeDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<NoticeDTO> noticeList(NoticeDTO noticeDto , int curpage, int purpage) {
		int offset = (curpage-1)*purpage;
		List<NoticeDTO> list = session.selectList("NoticeMapper.noticeList", noticeDto,new RowBounds(offset,purpage)); 
		return list; // 게시판 목록 및 페이징
		
	}
	
	public int noticeDel(int notice_seq) {
		int n = session.delete("NoticeMapper.noticeDel",notice_seq);
		return n;
	}
	
	
	public int noticeAdd(NoticeDTO noticeDTo) {
		int n = session.insert("NoticeMapper.noticeAdd",noticeDTo);
		return n;
	}
	
	public NoticeDTO noticeDetail(NoticeDTO noticeDto) {
		NoticeDTO noticeDetail = session.selectOne("NoticeMapper.noticeDetail", noticeDto); // "mapper이름.id", 너가 담아서 보낼 값 DTO ㅇㅋ?ㅇㅋ남겨줘
		return noticeDetail; // 그럼 이 list에 값들이 담겨있음 해서 리턴
		
	}
	
	public void noticeUpd( NoticeDTO noticedto) {
		session.selectOne("NoticeMapper.noticeUpd",noticedto);
	}
	
	
	public int totalRecord() {
		int count = session.selectOne("NoticeMapper.totalRecord");
		return count;
		
	}
	public List<NoticeDTO> selectAll(int curPage,int purpage) {
		int offset = (curPage-1)*purpage;
		List<NoticeDTO> list = session.selectList("NoticeMapper.selectAll",null
				,new RowBounds(offset,purpage));
		return list;
	}
}
	
	

