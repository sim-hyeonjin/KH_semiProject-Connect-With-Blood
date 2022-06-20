package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.MemberService;
//규민 회원현황 파트 //규민 회원현황 파트 //규민 회원현황 파트 //규민 회원현황 파트 //규민 회원현황 파트 //규민 회원현황 파트
/**
 * Servlet implementation class MemSituationController
 */
@WebServlet("/membershipStatus.ad") //규민 회원현황 파트
public class membershipStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public membershipStatusController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*int userEnrolldate = Integer.parseInt(request.getParameter("userEnrolldate"));
		int userWithdate = Integer.parseInt(request.getParameter("userWithdate"));
		int userSusdate = Integer.parseInt(request.getParameter("userSusdate"));
		
		int shipStatus = new MemberService().shipStatus(userEnrolldate,userWithdate,userSusdate);
		이런식으로 했으니 뭐가 될 일이 있나...
		*/
		
		//db에 접근하기 위한 service 호출(이 안에 dao > 쿼리가 작성되어있는 xml 로 접근하는 소스가 있기때문에)
		MemberService ms = new MemberService();
		
		//금일 신규회원현황
		//MemberService안에 있는 금일 신규현황 쿼리를 호출하는 메소드를 호출한다.
		//호출하여 금일 신규 회원 수 count를 return 받아 todayNewMemberCnt 변수에 넣는다
		int todayNewMemberCnt = ms.selectTodayNewMemberCnt();
		
		//이달 신규회원현황
		//위와 동일하게 /MemberService안에 있는 이달 신규현황 쿼리를 호출하는 메소드를 호출한다.
		int monthNewMemberCnt = ms.selectMonthNewMemberCnt(); // 새로운 메소드 & 쿼리 만들거에요~
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		//금일 탈퇴회원현황
		int todayDelMemberCnt = ms.selectTodayDelMemberCnt(); 
		//이달 탈퇴회원현황
		int monthDelMemberCnt = ms.selectMonthDelMemberCnt();
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		//금일 정지회원현황
		int todayStopMemberCnt = ms.selectTodayStopMemberCnt();
		//이달 탈퇴회원현황
		int monthStopMemberCnt = ms.selectMonthStopMemberCnt();
		
		
		//이제 여기까지 DB를 조회해서 금일 신규현황, 이달 신규현황 가져왓어요 그리고 VIEW에 뿌려줍시당
		request.setAttribute("todayNewMemberCnt", todayNewMemberCnt); //금일 신규회원현황 COUNT
		request.setAttribute("monthNewMemberCnt", monthNewMemberCnt); //이달 신규회원현황 COUNT
		request.setAttribute("todayDelMemberCnt", todayDelMemberCnt); //금일 탈퇴회원현황 COUNT
		request.setAttribute("monthDelMemberCnt", monthDelMemberCnt); //이달 탈퇴회원현황 COUNT
		request.setAttribute("todayStopMemberCnt", todayStopMemberCnt);//금일 정지회원현황 COUNT
		request.setAttribute("monthStopMemberCnt", monthStopMemberCnt); //이달 정지회원현황 COUNT

		
		request.getRequestDispatcher("views/admin/membershipStatus.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
