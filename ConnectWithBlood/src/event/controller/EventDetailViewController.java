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
 * Servlet implementation class EventDetailViewController
 */
@WebServlet("/detail.ev")
public class EventDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int eventNo = Integer.parseInt(request.getParameter("eno"));
		
		//조회수 증가
		int result = new EventService().increaseCount(eventNo);
		
		
		if(result>0) {
			//이벤트 내용
			Event event = new EventService().selectEvent(eventNo);
			
			
			//이벤트 상세 사진
			Attachment at = new EventService().selectAttachment(eventNo);
			
			request.setAttribute("event", event);
			request.setAttribute("at", at);
			
			request.getRequestDispatcher("views/event/eventDetailView.jsp").forward(request, response);
			
			
		}else {
			request.setAttribute("errorMsg", "이벤트 상세보기 실패");
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
