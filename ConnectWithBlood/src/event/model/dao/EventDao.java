package event.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import common.PageInfo;
import event.model.vo.Attachment;
import event.model.vo.Event;

public class EventDao {
	
	
	private Properties prop = new Properties();
	
	public EventDao() {
		String fileName = EventDao.class.getResource("/db/event/event-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int selectListCount(Connection conn) {
	
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public ArrayList<Event> selectEventList(Connection conn, PageInfo pi) {

		ArrayList<Event> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("SelectEventList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				list.add(new Event(rset.getInt("EVENT_NO")
									,rset.getString("EVENT_TITLE")
									,rset.getDate("EVENT_DATE")
									,rset.getInt("EVENT_COUNT")
									,rset.getString("EVENT_PROGRESS")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return list;
	}

	public int increaseCount(Connection conn, int eventNo) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eventNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Event selectEvent(Connection conn, int eventNo) {

		Event event = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectEvent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eventNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				event = new Event(rset.getInt("EVENT_NO")
								,rset.getString("EVENT_TITLE")
								,rset.getString("EVENT_CONTENT")
								,rset.getDate("EVENT_DATE")
								,rset.getString("EVENT_PROGRESS"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return event;
	}

	public int insertEvent(Event e, Connection conn) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertEvent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, e.getEventTitle());
			pstmt.setString(2, e.getEventContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertAttachment(Attachment at, Connection conn) {

		int result = 1;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Attachment selectAttachment(Connection conn, int eventNo) {

		Attachment at = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eventNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				at = new Attachment(rset.getInt("FILE_NO")
									,rset.getString("ORIGIN_NAME")
									,rset.getString("CHANGE_NAME")
									,rset.getString("FILE_PATH"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return at;
	}

	public ArrayList<Attachment> selectAttachmentList(Connection conn, int eventNo) {

		ArrayList<Attachment> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachmentlist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eventNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment at = new Attachment(); 
				
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
				
				list.add(at);
			}
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int updateEvent(Connection conn, Event e, Attachment newAttachment) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateEvent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, e.getEventTitle());
			pstmt.setString(2, e.getEventContent());
			pstmt.setInt(3, e.getEventNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateAttachment(Connection conn, Attachment newAttachment) {

		int result = 0;

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newAttachment.getOriginName());
			pstmt.setString(2, newAttachment.getChangeName());
			pstmt.setString(3, newAttachment.getFilePath());
			pstmt.setInt(4, newAttachment.getFileNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertNewAttachment(Connection conn, Attachment newAttachment) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNewAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, newAttachment.getRefCno());
			pstmt.setString(2, newAttachment.getOriginName());
			pstmt.setString(3, newAttachment.getChangeName());
			pstmt.setString(4, newAttachment.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int deleteEvent(Connection conn, int eventNo) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteEvent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eventNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


}
