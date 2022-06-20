package event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.model.service.EventService;
import event.model.vo.Attachment;
import event.model.vo.Event;

/**
 * Servlet implementation class EventUpdateFormController
 */
@WebServlet("/updateForm.ev")
public class EventUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int eventNo = Integer.parseInt(request.getParameter("eno"));
		
		//이벤트 작성 내용
		Event e = new EventService().selectEvent(eventNo);
		
		//이벤트 작성 사진
		Attachment at = new EventService().selectAttachment(eventNo);

		
		request.setAttribute("e", e);
		request.setAttribute("at", at);

		request.getRequestDispatcher("views/event/eventUpdateForm.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
