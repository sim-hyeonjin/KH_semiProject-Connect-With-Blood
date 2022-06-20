package question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import question.model.service.QuestionService;
import question.model.vo.Attachment;
import question.model.vo.Question;

/**
 * Servlet implementation class QuestionDetailViewController
 */
@WebServlet("/detail.que")
public class QuestionDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int queNo = Integer.parseInt(request.getParameter("qno"));
		

		
		//조회수 증가
//		int result = new QuestionService().increaseCount(queNo);
	
			//상세보기
			//사진없는 QnA
			
			Question que = new QuestionService().selectQue(queNo);
			
			
			//사진있는 QnA
			Attachment at = new QuestionService().selectAttachment(queNo);
			
			
			request.setAttribute("que", que);
			request.setAttribute("at", at);
			
			
			if(que!=null) {
				request.getRequestDispatcher("views/question/questionDetailView.jsp").forward(request, response);
			}else {
			
				request.setAttribute("errorMsg", "질문 상세조회 실패");
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
