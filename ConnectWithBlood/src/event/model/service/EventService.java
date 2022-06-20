package event.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.CommunityDao;
import common.PageInfo;
import event.model.dao.EventDao;
import event.model.vo.Attachment;
import event.model.vo.Event;

public class EventService {

	public int selectListCount() {

		Connection conn = getConnection();
		
		int listCount = new EventDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Event> selectEventList(PageInfo pi) {

		
		Connection conn = getConnection();
		
		ArrayList<Event> list = new EventDao().selectEventList(conn,pi);
		
		close(conn);
		
		return list;
	}

	public int increaseCount(int eventNo) {

		Connection conn = getConnection();
		
		int result = new EventDao().increaseCount(conn,eventNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public Event selectEvent(int eventNo) {

		Connection conn = getConnection();
		
		Event event = new EventDao().selectEvent(conn, eventNo);
		
		close(conn);
		
		return event;
	}

	public int insertAttachmentEvent(Event e, Attachment at) {
		
		Connection conn = getConnection();
		
		int result1 = new EventDao().insertEvent(e,conn);
		
		int result2 = new EventDao().insertAttachment(at,conn);
		
		if(result1>0&&result2>0){
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1*result2;
	}

	public Attachment selectAttachment(int eventNo) {

		Connection conn = getConnection();
		
		Attachment at = new EventDao().selectAttachment(conn,eventNo);
		
		close(conn);
		
		return at;
	}

	public ArrayList<Attachment> selectAttachmentList(int eventNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new EventDao().selectAttachmentList(conn,eventNo);
		
		close(conn);
		
		return list;
	}

	public int updateEvent(Event e, Attachment newAttachment) {

		Connection conn = getConnection();

		int result1 = new EventDao().updateEvent(conn,e,newAttachment);
		
		int result2 = 1;

		if(newAttachment != null) {
			
			if(newAttachment.getFileNo()!=0) {
				result2 = new EventDao().updateAttachment(conn, newAttachment);
			}else {
				result2 = new EventDao().insertNewAttachment(conn, newAttachment);

			}
		}
		
		return result1*result2;

	}

	public int deleteEvent(int eventNo) {

		Connection conn = getConnection();

		int result = new EventDao().deleteEvent(conn,eventNo);

		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}






}
