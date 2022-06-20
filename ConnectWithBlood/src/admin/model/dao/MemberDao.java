package admin.model.dao;
import static common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.model.vo.AdminMember;
import common.JDBCTemplate;
import common.MemberPageInfo;

//import org.apache.jasper.compiler.Node.GetProperty;



public class MemberDao {

private Properties prop = new Properties();
	
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/db/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName)); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	//회원정보 ㅡ 규민파트
	public ArrayList<AdminMember> selectList(Connection conn) {
		
		ArrayList<AdminMember> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				list.add(new AdminMember(rset.getInt("USER_NO")
						  ,rset.getString("USER_ID")
						  ,rset.getString("USER_PW")
						  ,rset.getString("USER_NAME")
						  ,rset.getString("USER_BIRTH")
						  ,rset.getString("USER_EMAIL")
						  ,rset.getString("USER_PHONE")
						  ,rset.getString("USER_ADDRESS")
						  ,rset.getDate("USER_ENROLLDATE")
						  ,rset.getString("USER_GRADE")
						  ,rset.getString("USER_BLOODTYPE")
						  ,rset.getDate("USER_LOGINDATE")
						  ,rset.getDate("USER_WITHDATE")
						  ,rset.getDate("USER_SUSDATE")
						  ,rset.getString("USER_STATUS")));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//회원정보 검색구현 - 규민
	public ArrayList<AdminMember> searchMemberList(Connection conn,String keyField, String keyWord,MemberPageInfo pi ) {
		
		ArrayList<AdminMember> list1 = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
	
		String sql = "";// prop.getProperty("searchMemberList");
		
		int startRow = (pi.getCurrentPage()-1)*pi.getMemberLimit()+1; 
		int endRow = pi.getCurrentPage() * pi.getMemberLimit();
		
		
		
		try {
			
			//keyField가 null 또는 값이 없을때 > 즉, 전체 검색이란 얘기
			if("".equals(keyWord) || keyWord == null) {
				//전체검색용 sql 수행
				sql = prop.getProperty("selectMemberList");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rset = pstmt.executeQuery();
			}else {
				
				//이제 여기서는 keyField가 뭐냐에 따라 if문으로 위에 처럼 sql 분기처리 해줘야함
				if(keyField.equals("userName")) {
					sql = prop.getProperty("selectMemberUserNameFindList");
				}else if(keyField.equals("userGrade")) {
					sql = prop.getProperty("selectMemberUserGradeFindList");
				}else if(keyField.equals("userId")) {
					sql = prop.getProperty("selectMemberUserIdFindList");
				}
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, keyWord); //사용자가 입력한 keyWord가 쿼리에 들어가야되기 때문에 넣어줘야한다
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rset = pstmt.executeQuery();
				
			 }/*else if 문을 사용해야 됐었다(아니면 switch case 문)*/
			
			//전체 조회든, 검색을 통한 조회든 뿌려주는 데이터는 같으니까 아래로 바꾼다
			while(rset.next()) {
			list1.add(new AdminMember(
					   rset.getInt("USER_NO")
					  ,rset.getString("USER_ID")
					  ,rset.getString("USER_PW")
					  ,rset.getString("USER_NAME")
					  ,rset.getString("USER_BIRTH")
					  ,rset.getString("USER_EMAIL")
					  ,rset.getString("USER_PHONE")
					  ,rset.getString("USER_ADDRESS")
					  ,rset.getDate("USER_ENROLLDATE")
					  ,rset.getString("USER_GRADE")
					  ,rset.getString("USER_BLOODTYPE")
					  ,rset.getDate("USER_LOGINDATE")
					  ,rset.getDate("USER_WITHDATE")
					  ,rset.getDate("USER_SUSDATE")
					  ,rset.getString("USER_STATUS")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list1;
		
	}

	//금일 신규회원 COUNT ㅡ 규민파트
	public int selectTodayNewMemberCnt(Connection conn) {
		
		int Count = 0; // 
		
		PreparedStatement pstmt = null; // SQL구문을 실행시키는 기능을 갖는 객체
		
		ResultSet rset = null; // query 실행 후 그 값을 rset에 저장
		
		String sql = prop.getProperty("selectTodayNewMemberCnt"); 
		
		try {
			pstmt = conn.prepareStatement(sql); 
			rset = pstmt.executeQuery();		// executeQuery select DB 동작 바뀌지 않고 보여주는 용도
			
			//쿼리에서 AS로 이름변경해서 밑에도 동일하게 변경해줌
			if(rset.next()) { // 결과값의 다음 행의 정보가있으면?
				Count = rset.getInt("TODAY_MEMBER_COUNT");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Count;
	}

	//이번달 신규회원현황 COUNT ㅡ 규민파트
	public int selectMonthNewMemberCnt(Connection conn) {
			
			int Count = 0;
			
			PreparedStatement pstmt = null;
			
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectMonthNewMemberCnt");
			
			try {
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {

					Count = rset.getInt("MONTH_NEWMEMBER_COUNT");
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return Count;
		}
	
	//금일 회원탈퇴현황 COUNT ㅡ 규민파트
	public int selectTodayDelMemberCnt(Connection conn) {
		
		int Count = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTodayDelMemberCnt");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				Count = rset.getInt("TODAY_DELMEMBER_COUNT");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Count;
	}
	
	//이번달 회원탈퇴현황 COUNT ㅡ 규민파트
	public int selectMonthDelMemberCnt(Connection conn) {
		int Count = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMonthDelMemberCnt");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
	
				Count = rset.getInt("MONTH_DELMEMBER_COUNT");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Count;
	}

	//금일 정지회원현황 COUNT ㅡ 규민파트
	public int selectTodayStopMemberCnt(Connection conn) {

		int Count = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTodayStopMemberCnt");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
	
			if(rset.next()) {
				
				Count = rset.getInt("TODAY_STOPMEMBER_COUNT");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return Count;
	}
	
	
	//이번달 정지현황 ㅡ 규민파트
	public int selectMonthStopMemberCnt(Connection conn) {
		int Count = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMonthStopMemberCnt");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				
				Count = rset.getInt("MONTH_STOPMEMBER_COUNT");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Count;
	}

	public int modifyMember(Connection conn, String userGrade, String userStatus, String userId) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("modifyMember");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userStatus );
			pstmt.setString(2, userGrade );
			pstmt.setString(3, userId );
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//멤버명단 페이징처리
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

	public ArrayList<AdminMember> selectList(Connection conn, MemberPageInfo pi) {
		
		ArrayList<AdminMember> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getMemberLimit()+1; //Row 는 행을 의미
			int endRow = pi.getCurrentPage() * pi.getMemberLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new AdminMember(rset.getString("USER_ID")
								   ,rset.getString("USER_NAME")
								   ,rset.getDate("USER_ENROLLDATE")
								   ,rset.getString("USER_GRADE")
								   ,rset.getDate("USER_LOGINDATE")
								   ,rset.getString("USER_STATUS")));
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


