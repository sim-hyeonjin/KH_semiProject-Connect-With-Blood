package question.model.service;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import question.model.vo.Answer;
import question.model.vo.Attachment;
import common.PageInfo;
import question.model.dao.QuestionDao;
import question.model.vo.Category;
import question.model.vo.Question;

public class QuestionService {

	public int selectQuestionCount() {

		Connection conn = getConnection();
		
		int listCount = new QuestionDao().selectQnaCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Question> selectQuestionList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Question> list = new QuestionDao().selectQuestionList(conn,pi);
		
		close(conn);
		
		return list;
	}



	public Question selectQue(int queNo) {

		Connection conn = getConnection();
		
		Question que = new QuestionDao().selectQue(conn, queNo);
		
		close(conn);
		
		return que;
	}
	
	public ArrayList<Category> selectCategoryList(){
		
		Connection conn = getConnection();
		
		ArrayList<Category> list = new QuestionDao().selectCategoryList(conn);
		
		close(conn);
		
		return list;
		
	}

	public int insertQue(Question que, Attachment at) {

		Connection conn = getConnection();
		
		int result1 = new QuestionDao().insertQue(conn,que);
		
		int result2 = 1;
		
		if(at != null) {
			result2 = new QuestionDao().insertAttachment(conn,at);
		}
		
		if(result1>0&&result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1*result2;
	}

	public Attachment selectAttachment(int queNo) {

		Connection conn = getConnection();
		
		Attachment at = new QuestionDao().selectAttachment(conn,queNo);
		
		close(conn);
		
		return at;
		
	}

	public int updateQuestion(Question que, Attachment newAttachment) {

		Connection conn = getConnection();
		
		int result1 = new QuestionDao().updateQuestion(conn,que,newAttachment);
		
		int result2 = 1;
		
		if(newAttachment != null) {
			if(newAttachment.getFileNo()!=0) {
				result2 = new QuestionDao().updateAttachment(conn,newAttachment);
			}else {
				result2 = new QuestionDao().insertNewAttachment(conn, newAttachment);
			}
		}
		
		return result1*result2;
	}

	public int deletQuestion(int queNo) {

		Connection conn = getConnection();
		
		int result = new QuestionDao().deleteQuesion(conn,queNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	//답변 댓글 작성
	public int insertReply(Answer a) {

		Connection conn = getConnection();
		
		int result = new QuestionDao().insertReply(conn,a);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}

	//답변 댓글 목록 조회
	public ArrayList<Answer> selectReplyList(int queNo) {

		Connection conn = getConnection();
		
		ArrayList<Answer> list = new QuestionDao().selectReplyList(conn,queNo);
		
		close(conn);
		
		return list;
	}


	
	


}
