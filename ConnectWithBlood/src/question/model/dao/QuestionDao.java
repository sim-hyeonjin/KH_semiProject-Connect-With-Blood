package question.model.dao;
import static common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import question.model.vo.Answer;
import question.model.vo.Attachment;
import common.PageInfo;
import question.model.vo.Category;
import question.model.vo.Question;

public class QuestionDao {

	private Properties prop = new Properties();
	
	public QuestionDao() {
		
		String fileName = QuestionDao.class.getResource("/db/question/question-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int selectQnaCount(Connection conn) {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQnaCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
		
	}
	
	public ArrayList<Question> selectQuestionList(Connection conn, PageInfo pi) {
		
		ArrayList<Question> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQnaList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Question(rset.getInt("QUESTION_NO")
						             ,rset.getString("QUESTION_TITLE")
						             ,rset.getString("QUESTION_TAG")
						             ,rset.getDate("QUESTION_DATE")
						             ,rset.getString("USER_NAME")
									,rset.getString("CATEGORY_NAME")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
		
	}



	public Question selectQue(Connection conn, int queNo) {

		Question que = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQue");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, queNo);
			
			rset = pstmt.executeQuery();
					
			if(rset.next()) {
				que = new Question(rset.getInt("QUESTION_NO")
									,rset.getString("QUESTION_TITLE")
									,rset.getString("QUESTION_CONTENT")
									,rset.getDate("QUESTION_DATE")
									,rset.getString("USER_NAME")
									,rset.getString("CATEGORY_NAME"));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return que;
	}
	
	public ArrayList<Category> selectCategoryList(Connection conn){
		
		ArrayList<Category> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Category(rset.getInt("CATEGORY_NO")
										,rset.getString("CATEGORY_NAME")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	public int insertQue(Connection conn, Question que) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQue");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, que.getQuestionTitle());
			pstmt.setString(2, que.getQuestionContent());
			pstmt.setInt(3, Integer.parseInt(que.getQuestionTag()));
			pstmt.setString(4, que.getQuestionWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertAttachment(Connection conn, Attachment at) {

		int result = 0;
		
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

	public Attachment selectAttachment(Connection conn, int queNo) {

		Attachment at = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, queNo);
			
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

	public int updateQuestion(Connection conn, Question que, Attachment newAttachment) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateQuestion");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(que.getQuestionTag()));
			pstmt.setString(2, que.getQuestionTitle());
			pstmt.setString(3, que.getQuestionContent());
			pstmt.setInt(4, que.getQuestionNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			
			pstmt.setInt(1, newAttachment.getRefQno());
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

	public int deleteQuesion(Connection conn, int queNo) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteQuestion");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, queNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	//답변 댓글 작성
	public int insertReply(Connection conn, Answer a) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, a.getAnsContent());
			pstmt.setInt(2, a.getOriginNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	//답변 댓글 목록 조회
	public ArrayList<Answer> selectReplyList(Connection conn, int queNo) {

		ArrayList<Answer> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, queNo);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Answer(rset.getInt("ANS_NO")
									,rset.getString("ANS_CONTENT")
									,rset.getString("ANS_DATE")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}



}
