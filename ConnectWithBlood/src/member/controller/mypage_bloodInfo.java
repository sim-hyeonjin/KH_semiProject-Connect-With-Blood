package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.BloodInfo;

/**
 * Servlet implementation class mypage_bloodInfo
 */
@WebServlet("/mybloodInfo.mem")
public class mypage_bloodInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mypage_bloodInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		
		String userBloodInfo = new MemberService().selectBloodWh(userId);
		
		
		
		if(userBloodInfo==null){ 
			request.setAttribute("alertMsg", "조회된 결과가 없습니다.");
			
			request.getRequestDispatcher("views/member/mypage.jsp").forward(request, response);
		
		}else { 
			HttpSession session = request.getSession();
			session.setAttribute("userBloodInfo", userBloodInfo);
	        request.getRequestDispatcher("views/member/mypage.jsp").forward(request, response);
			
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
