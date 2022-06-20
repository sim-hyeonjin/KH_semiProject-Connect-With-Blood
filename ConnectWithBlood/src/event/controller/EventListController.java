package event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageInfo;
import event.model.service.EventService;
import event.model.vo.Event;

/**
 * Servlet implementation class EventListController
 */
@WebServlet("/list.ev")
public class EventListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int listCount; 
		int currentPage; 
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage; 
		int endPage; 
		
		listCount = new EventService().selectListCount();
	
		currentPage = Integer.parseInt(request.getParameter("epage"));
		
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)(Math.ceil((double)listCount/boardLimit));
		
		startPage = (currentPage-1)/pageLimit * pageLimit + 1;
		
		endPage = startPage+pageLimit -1;
		
		if(endPage>maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit
				,maxPage,startPage,endPage);
		
		
		
		ArrayList<Event> list = new EventService().selectEventList(pi);
		
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("views/event/eventListView.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
