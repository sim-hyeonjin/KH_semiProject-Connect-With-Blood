package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.CommunityService;
import board.model.vo.Attachment;
import board.model.vo.Category;
import board.model.vo.Community;

/**
 * Servlet implementation class CommunityUpdateFormController
 */
@WebServlet("/updateForm.co")
public class CommunityUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int commNo = Integer.parseInt(request.getParameter("cno"));
		
		//게시판 카테고리
		ArrayList<Category> clist = new CommunityService().selectCategoryList();
	
		//게시판작성내용
		Community comm = new CommunityService().selectComm(commNo);
		
		//게시판 사진
		Attachment at = new CommunityService().selectAttachment(commNo);
		
		request.setAttribute("clist", clist);
		request.setAttribute("comm", comm);
		request.setAttribute("at", at);
		
		request.getRequestDispatcher("views/board/communityUpdateView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
