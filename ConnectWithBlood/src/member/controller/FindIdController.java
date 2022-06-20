package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class findId
 */
@WebServlet("/findId.mem")
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		
		String userId = new MemberService().findId(userName,userEmail);
		
		
        if(userId != null) {
           
           request.getSession().setAttribute("userId", userId);
           request.getRequestDispatcher("views/member/findId_after.jsp").forward(request, response);
          
        }
        else {
        	request.setAttribute("errorMsg", "아이디찾기에 실패했습니다.");
        	RequestDispatcher view =  request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request,response);
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
