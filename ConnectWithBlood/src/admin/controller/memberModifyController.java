package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.service.MemberService;
import admin.model.vo.AdminMember;

/**
 * Servlet implementation class memberModifyController
 */
@WebServlet("/memModify.ad")
public class memberModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//회원정보(등급,상태) 수정하기 05월30일 14시40분 진행
		String userGrade = request.getParameter("userGrade");
		String userStatus = request.getParameter("userStatus");
		String userId = request.getParameter("userId");
		System.out.println("userId : " + userId);
		int modifyMem = new MemberService().modifyMember(userGrade,userStatus,userId);
		
	
		HttpSession session = request.getSession();
		
		session.setAttribute("alertMsg", "회원 정보수정 완료.");
		
		
		response.sendRedirect(request.getContextPath()+"/memManagement.ad?mpage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
