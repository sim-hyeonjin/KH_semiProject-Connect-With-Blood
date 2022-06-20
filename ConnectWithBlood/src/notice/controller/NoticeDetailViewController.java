package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.CommunityService;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDetailViewController
 */
@WebServlet("/detail.no")
public class NoticeDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int noticeNo = Integer.parseInt(request.getParameter("nno"));

		//조회수 증가
		int result = new NoticeService().increaseCount(noticeNo);
		
		if(result>0) {
			
			//공지사항 상세보기
			Notice n =  new NoticeService().selectNotice(noticeNo);		
			
			request.setAttribute("n", n);
			
			request.getRequestDispatcher("views/notice/noticeDetailView.jsp").forward(request, response);


		}else {
			request.setAttribute("errorMsg", "공지사항상세조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		
		
		
		
		
//		request.getRequestDispatcher("views/notice/noticeDetailView.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
