package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class DeleteUserController
 */
@WebServlet("/delete.mem")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userPw = request.getParameter("userPw");

		
		HttpSession session = request.getSession();
		String userId = ((Member)session.getAttribute("loginMember")).getUserId();
		
		int result = new MemberService().deleteMember(userId, userPw);
		
		
		if(result>0) { 
			
			session.setAttribute("alertMsg", "회원탈퇴가 완료되었습니다. 안녕히 가세요.");
			
			session.removeAttribute("loginMember");
			
			response.sendRedirect(request.getContextPath());

		}else { 
			
			request.setAttribute("errorMsg", "회원탈퇴에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
