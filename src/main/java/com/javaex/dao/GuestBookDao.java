package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {

	@Autowired
	private SqlSession sqlSession;
		
	public List<GuestBookVo> showList() {
		System.out.println("gbDao.showList");
		
		List<GuestBookVo> gbList = sqlSession.selectList("guestbook.showList");
		
		return gbList;
	}
	
	
	public void add(GuestBookVo gbVo) {
		System.out.println("gbDao.add");
		int count = -1;
		
		count = sqlSession.insert("guestbook.add", gbVo);
		
		if (count > 0) System.out.println("[" + count + "건 등록되었습니다.]");
		else System.out.println("[등록되지 않았습니다.]");
	}
	
	
	public int find(GuestBookVo gbVo) {
		System.out.println("gbDao.find");
		int no = -1;
		
		no = sqlSession.selectOne("guestbook.find", gbVo); 
				
		return no;
	}
	
	
	public void delete(int no) {
		int count = -1;
		
		count = sqlSession.delete("guestbook.delete", no);
		
		if (count > 0) System.out.println("[" + count + "건 삭제되었습니다.]");
		else System.out.println("[삭제되지 않았습니다.]");
	}
	
}
