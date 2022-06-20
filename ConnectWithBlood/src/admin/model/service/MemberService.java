package admin.model.service;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import admin.model.dao.MemberDao;
import admin.model.vo.AdminMember;
import common.JDBCTemplate;
import common.MemberPageInfo;


	//규민파트 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	//회원정보 ㅡ 규민파트
	public class MemberService { 

	public ArrayList<AdminMember> selectMemberList() {
		Connection conn = getConnection();
		
		ArrayList<AdminMember> list = new MemberDao().selectList(conn);
	
		close(conn);
		
		return list;
	}
	
	//회원검색 ㅡ 규민파트
	public ArrayList<AdminMember> searchMemberList(String keyField, String keyWord, MemberPageInfo pi  ) {
		Connection conn = getConnection();
		
		ArrayList<AdminMember> list1 = new MemberDao().searchMemberList(conn,keyField,keyWord,pi);

		close(conn);

		return list1;
	}
		
		
		
	// 금일 신규 현황 ㅡ 규민파트
	public int selectTodayNewMemberCnt() {
		Connection conn = getConnection();
		
		//db에 접근하기 위한 dao 호출(쿼리가 작성되어있는 xml 로 접근하는 소스가 있기때문에)
		int todayNewMemberCnt = new MemberDao().selectTodayNewMemberCnt(conn); 
		
		close(conn);
		
		return todayNewMemberCnt;
	}
	
	// 이번달 신규 현황 ㅡ 규민파트
	public int selectMonthNewMemberCnt() {
		Connection conn = getConnection();
		
		//db에 접근하기 위한 dao 호출(쿼리가 작성되어있는 xml 로 접근하는 소스가 있기때문에)
		int monthNewMemberCnt = new MemberDao().selectMonthNewMemberCnt(conn); 
		
		close(conn);
		
		return monthNewMemberCnt;
	}
	
	//금일 탈퇴현황 ㅡ 규민파트
	public int selectTodayDelMemberCnt() {
		Connection conn = getConnection();
		
		int todayDelMemberCnt = new MemberDao().selectTodayDelMemberCnt(conn);
		
		close(conn);
		
		return todayDelMemberCnt;
	}
	//이번달 탈퇴현황 ㅡ 규민파트
	public int selectMonthDelMemberCnt() {
		Connection conn = getConnection();
		
		//db에 접근하기 위한 dao 호출(쿼리가 작성되어있는 xml 로 접근하는 소스가 있기때문에)
		int monthDelMemberCnt = new MemberDao().selectMonthDelMemberCnt(conn); 
		
		close(conn);
		
		return monthDelMemberCnt;
	}
	
	//금일 회원 정지현황 ㅡ 규민파트
	public int selectTodayStopMemberCnt() {
		Connection conn = getConnection();
		
		int todayStopMemberCnt = new MemberDao().selectTodayStopMemberCnt(conn);
		
		close(conn);
		
		return todayStopMemberCnt;

	
	}
	//이번달 회원 정지현황 ㅡ 규민파트
	public int selectMonthStopMemberCnt() {
		Connection conn = getConnection();
		
		int monthStopMemberCnt = new MemberDao().selectMonthStopMemberCnt(conn);
		
		close(conn);
		
		return monthStopMemberCnt;
	}
	
	
	//멤버 정보수정(등급,상태) ㅡ 규민
	public int modifyMember(String userGrade, String userStatus, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().modifyMember(conn,userGrade,userStatus,userId);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//회원명단 페이징
	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = new MemberDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	
	//회원명단 페이징2
	public ArrayList<AdminMember> selectList(MemberPageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<AdminMember> list = new MemberDao().selectList(conn,pi);
		
		close(conn);
		
		return list;
	}
	
	


	
}
