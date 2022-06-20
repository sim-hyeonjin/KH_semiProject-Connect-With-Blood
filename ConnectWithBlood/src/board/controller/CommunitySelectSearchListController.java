package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.CommunityService;
import board.model.vo.Community;
import common.PageInfo;

/**
 * Servlet implementation class CommunitySelectSearchListController
 */
@WebServlet("/searchList.co")
public class CommunitySelectSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunitySelectSearchListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String category = request.getParameter("category");
		String search = request.getParameter("search");
//		System.out.println(search);

		int listCount; 
		int currentPage; 
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage; 
		int endPage; 
		
		listCount = new CommunityService().selectSearchListCount(category,search);
	
		currentPage = Integer.parseInt(request.getParameter("cspage"));
		
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
		
//		System.out.println(category);
//		System.out.println(search);
		
		ArrayList<Community> slist = new CommunityService().selectSearchList(pi,category,search);
		
		request.setAttribute("pi",pi);
		request.setAttribute("slist", slist);
		request.getRequestDispatcher("views/board/communitySearchList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
