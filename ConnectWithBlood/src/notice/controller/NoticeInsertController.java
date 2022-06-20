package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		
			String noticeTitle = request.getParameter("title");
			String noticeContent = request.getParameter("content");
			String noticeWriter =  request.getParameter("userNo");

			
			Notice n = new Notice();
			
			n.setNoticeTitle(noticeTitle);
			n.setNoticeContent(noticeContent);
			n.setNoticeWriter(noticeWriter);
			
			
			int result = new NoticeService().insertNotice(n);
			
			if(result>0) {
				request.getSession().setAttribute("alertMsg", "공지사항이 작성되었습니다");

				response.sendRedirect(request.getContextPath()+"/list.no?npage=1");
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
