package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.NoticeDAO;
import com.dto.NoticeDTO;

@Service
public class NoticeService {
	
	@Autowired
	NoticeDAO dao;
	
	public List<NoticeDTO> noticeList(NoticeDTO noticeDto,int curpage,int purpage) {
		List<NoticeDTO> list = null;
			list = dao.noticeList(noticeDto,curpage,purpage);
		return list; 
	}// 페이징
	
	public int noticeAdd(NoticeDTO noticeDto) {
		int n = dao.noticeAdd(noticeDto);
		return n;
	}// end noticeAdd
	
	
	public int noticeDel(int notice_seq) {
		int n = 0;
			n = dao.noticeDel(notice_seq);
		return n;
	} // end del
	
	
	public NoticeDTO noticeDetail(NoticeDTO noticeDto) {
		NoticeDTO noticeDetail = null;
			noticeDetail = dao.noticeDetail(noticeDto);
		return noticeDetail; //여기도 마찬가지
	}// end noticeService
	
	public void noticeUpd(NoticeDTO noticedto) {
		int n = 0;
			dao.noticeUpd(noticedto);
			
	}
	
	public List<NoticeDTO> selectAll(int curPage, int purpage) {
		List<NoticeDTO> list = null;
			list = dao.selectAll(curPage, purpage);
		return list;
	}
	
	public int totalRecord(NoticeDTO noticeDto) {
		int n = 0;
			n = dao.totalRecord();
		return n;
	}
	
	
}// end class
