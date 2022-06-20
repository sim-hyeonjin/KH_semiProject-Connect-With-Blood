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
 * Servlet implementation class ModifyController
 */
@WebServlet("/mody.mem")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("UTF-8");
				
					String userId = request.getParameter("userId");
					String userPw = request.getParameter("userPw");
					String userName = request.getParameter("userName");
					String userEmail = request.getParameter("userEmail");
					String userPhone = request.getParameter("userPhone");
					String userAddress = request.getParameter("userAddress");
				 
				
				 Member m = new Member(userId,userPw,userName,userEmail,userPhone,userAddress);
				
				 Member updateMem = new MemberService().modifyMem(m);
				
				
				if(updateMem == null) { 
					request.setAttribute("errorMsg", "회원정보 수정을 실패하였습니다.");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("loginMember", updateMem);
					session.setAttribute("alertMsg", "회원정보 수정 완료!");
					
					response.sendRedirect(request.getContextPath()+"/mypage.mem");
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
