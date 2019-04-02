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
		int n = session.delete("NoticeMapper.noticeDel",notice_seq); // 여기도 해놓고 왜 몰라봄 이거 고쳐야겟다는생각을못함
		return n;
	}
	
	
	public int noticeAdd(NoticeDTO noticeDTo) {
		int n = session.insert("NoticeMapper.noticeAdd",noticeDTo); // 여기도 해놓고
		return n;
	}
	
	public NoticeDTO noticeDetail(NoticeDTO noticeDto) {
		NoticeDTO noticeDetail = session.selectOne("NoticeMapper.noticeDetail", noticeDto); // "mapper이름.id", 너가 담아서 보낼 값 DTO ㅇㅋ?ㅇㅋ남겨줘
		return noticeDetail; // 그럼 이 list에 값들이 담겨있음 해서 리턴
		
	}
	
	public void noticeUpd( NoticeDTO noticedto) {
		session.update("NoticeMapper.noticeUpd",noticedto); // 보통 다 있어저거 다 있지?ㅇㅇ
	}
	
	public void updateCnt(NoticeDTO noticeDto) {
		session.update("NoticeMapper.updateCnt",noticeDto);
	}
	
	
	public int totalRecord() {
		int count = session.selectOne("NoticeMapper.totalRecord");
		return count;
		
	}
	public List<NoticeDTO> selectAll(int curPage,int purpage) { //게시판 페이징처리
		int offset = (curPage-1)*purpage;
		List<NoticeDTO> list = session.selectList("NoticeMapper.selectAll",null
				,new RowBounds(offset,purpage));
		return list;
	}
	
}
	
	

