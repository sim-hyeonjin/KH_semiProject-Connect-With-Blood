package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.CommunityService;
import board.model.vo.Attachment;
import board.model.vo.Community;

/**
 * Servlet implementation class CommunityDetailViewController
 */
@WebServlet("/detail.co")
public class CommunityDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int commNo = Integer.parseInt(request.getParameter("cno"));

		
		//조회수 증가 
		int result = new CommunityService().increaseCount(commNo);

		if(result>0) {
			
			//상세보기
			//사진 없는 게시글
			
			Community comm = new CommunityService().selectComm(commNo);
			
			
			//사진 있는 게시글
		
			Attachment at = new CommunityService().selectAttachment(commNo);
			
			
			request.setAttribute("comm", comm);
			request.setAttribute("at", at);
			
			request.getRequestDispatcher("views/board/communityDetailView.jsp").forward(request, response);
		
		}else {
			request.setAttribute("errorMsg", "게시글상세조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp");
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
