package notice.model.service;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import common.PageInfo;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

public class NoticeService {

	public int selectListCount() {

		Connection conn = getConnection();
		
		int listCount = new NoticeDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	
	public ArrayList<Notice> selectNoticeList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn,pi);
		
		close(conn);
		
		return list;
	}


	public int increaseCount(int noticeNo) {

		Connection conn = getConnection();

		int result = new NoticeDao().increaseCount(conn,noticeNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;

	}


	public Notice selectNotice(int noticeNo) {

		Connection conn = getConnection();

		Notice n = new NoticeDao().selectNotice(conn,noticeNo);
		
		close(conn);
		
		return n;
	}


	public int insertNotice(Notice n) {

		Connection conn = getConnection();
		
		int result  = new NoticeDao().insertNotice(conn,n);
		
		close(conn);
		
		return result;
	}


	public int updateNotice(Notice n) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().updateNotice(conn,n);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}


	public int deleteNotice(int noticeNo) {

		Connection conn = getConnection();
		
		int result = new NoticeDao().deleteNotice(conn,noticeNo);
				
		if(result>0) { 
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}

	
	
	

}
