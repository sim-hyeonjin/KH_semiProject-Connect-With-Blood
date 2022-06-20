package admin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.MemberService;
import admin.model.vo.AdminMember;
import common.MemberPageInfo;
//규민파트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//규민파트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//회원상태ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
/**
 * Servlet implementation class MemManagementController
 */
@WebServlet("/memManagement.ad")
public class MemManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemManagementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		
		//멤버명단 페이징 처리
		int listCount; 	 // 현재 총 게시글 개수 (담아놓을 변수)
		int currentPage; // 현재 페이지(사용자가 요청한 페이지)
		int pageLimit;   // 페이지 하단에 보이는 페이지 페이징 최대 개수
		int memberLimit; // 한 페이지에서 보여질 게시글 개수
		
		int maxPage;     // 가장 마지막 페이지가 몇 번 페이지인지(총 페이지수)
		int startPage;   // 페이징 하단에 보여질 페이징 시작 수
		int endPage;     // 페이지 하단에 보여질 페이징 끝 수
		
		// listCount 현재 총 회원명단
		listCount = new MemberService().selectListCount(); 
		//System.out.println(listCount); 107나옴.
		
		//currentPage 현재페이지(사용자가 요청한 페이지)
		
		currentPage = Integer.parseInt(request.getParameter("mpage"));
		
		//pageLimit 페이지 하단에 보이는 페이지 페이징 최대 개수
		pageLimit = 10;
		
		//boardLimint 한 페이지에서 보여질 게시글 개수
		memberLimit = 10;
		maxPage = (int)(Math.ceil((double)listCount/memberLimit));
		
		startPage = (currentPage-1)/pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage>maxPage) { //엔드페이지가 맥스페이지보다 클때
			endPage=maxPage; // 앤드페이지랑 맥스페이지가 같다고 변경처리 -끄으으으읕-
		}
		MemberPageInfo pi = new MemberPageInfo(listCount, currentPage, pageLimit, memberLimit, maxPage, startPage, endPage);
		
		ArrayList<AdminMember> list = new MemberService().selectList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/admin/memberManagement.jsp").forward(request, response);
		
		
	}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
