package member.model.service;
import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.BloodInfo;
import member.model.vo.Member;
//규민파트 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

public class MemberService { 









	// 금일 신규 현황
	public int selectTodayNewMemberCnt() {
		Connection conn = getConnection();
		
		//db에 접근하기 위한 dao 호출(쿼리가 작성되어있는 xml 로 접근하는 소스가 있기때문에)
		int todayNewMemberCnt = new MemberDao().selectTodayNewMemberCnt(conn); 
		
		close(conn);
		
		return todayNewMemberCnt;
	}
	
	// 이번달 신규 현황
	public int selectMonthNewMemberCnt() {
		Connection conn = getConnection();
		
		//db에 접근하기 위한 dao 호출(쿼리가 작성되어있는 xml 로 접근하는 소스가 있기때문에)
		int monthNewMemberCnt = new MemberDao().selectMonthNewMemberCnt(conn); 
		
		close(conn);
		
		return monthNewMemberCnt;
	}
	
	//금일 탈퇴현황
	public int selectTodayDelMemberCnt() {
		Connection conn = getConnection();
		
		int todayDelMemberCnt = new MemberDao().selectTodayDelMemberCnt(conn);
		
		close(conn);
		
		return todayDelMemberCnt;
	}
	//이번달 탈퇴현황
	public int selectMonthDelMemberCnt() {
		Connection conn = getConnection();
		
		//db에 접근하기 위한 dao 호출(쿼리가 작성되어있는 xml 로 접근하는 소스가 있기때문에)
		int monthDelMemberCnt = new MemberDao().selectMonthDelMemberCnt(conn); 
		
		close(conn);
		
		return monthDelMemberCnt;
	}
	
	//금일 회원 정지현황
	public int selectTodayStopMemberCnt() {
		Connection conn = getConnection();
		
		int todayStopMemberCnt = new MemberDao().selectTodayStopMemberCnt(conn);
		
		close(conn);
		
		return todayStopMemberCnt;

	
	}
	//이번달 회원 정지현황
	public int selectMonthStopMemberCnt() {
		Connection conn = getConnection();
		
		int monthStopMemberCnt = new MemberDao().selectMonthStopMemberCnt(conn);
		
		close(conn);
		
		return monthStopMemberCnt;
	}
		
		

	

	//회원가입
		public int enrollMember(Member m) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new MemberDao().enrollMember(conn,m);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
		}




	//아이디 찾기
	public String findId(String userName,String userEmail) {

		Connection conn = JDBCTemplate.getConnection();
		
		String userId = new MemberDao().findId(conn,userName,userEmail);
		
		close(conn);
		
		return userId;
		
	}





	//비밀번호 찾기
	public String findPw(String userId, String userName, String userEmail) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String userPw = new MemberDao().findPw(conn,userId,userName,userEmail);
		
		close(conn);
		
		return userPw;
	}





	//아이디 중복체크
	public int idCheck(String idCheck) {

		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().idCheck(conn,idCheck);
		
		JDBCTemplate.close(conn);
		
		return count;
	}





	//회원 삭제
	public int deleteMember(String userId, String userPw) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId, userPw);

		
		if(result>0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}



	
	//헌혈증 등록
	public int insertBloodInfo(BloodInfo b) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertBloodInfo(conn,b);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	
	

	//회원정보 수정
	public Member modifyMem(Member m) {

		Connection conn = JDBCTemplate.getConnection();
		
		Member updateMem = null;
		int result = new MemberDao().modifyMem(m,conn);
		
		if(result>0) {
			commit(conn);
			updateMem =new MemberDao().selectMember(conn,m.getUserId());
			
		}else {
			rollback(conn);
		}
		close(conn);
		
		return updateMem;
	}






	//userId->userNo
	public int changeUserNo(String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int bloodOwner = new MemberDao().changeUserNo(conn,userId);
		
		close(conn);
		
		return bloodOwner;
	}












	//헌혈증 wh추출
	public String selectBloodWh(String userId) {

		Connection conn = JDBCTemplate.getConnection();
		
		String bloodWh = new MemberDao().selectBloodWh(conn,userId);
		
		JDBCTemplate.close(conn);
		
		return bloodWh;
	}



	//로그인
	public Member loginMember(String userId, String userPw) {
		
		
		Connection conn =  getConnection();
		
		Member m = new MemberDao().loginMember(conn,userId,userPw);
		
		close(conn);
		
		return m;

	}







	
	
	



	





	

	
}
