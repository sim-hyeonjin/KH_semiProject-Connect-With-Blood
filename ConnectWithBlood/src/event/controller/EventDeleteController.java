package event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.model.service.EventService;

/**
 * Servlet implementation class EventDeleteController
 */
@WebServlet("/delete.ev")
public class EventDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int eventNo = Integer.parseInt(request.getParameter("eno"));
	
		int result = new EventService().deleteEvent(eventNo);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "이벤트가 삭제되었습니다");

			response.sendRedirect(request.getContextPath()+"/list.ev?epage=1");
		}else {
			response.sendRedirect("views/common/communityErrorPage.jsp");

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
