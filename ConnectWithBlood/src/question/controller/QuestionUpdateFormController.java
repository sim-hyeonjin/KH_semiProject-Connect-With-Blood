package question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import question.model.service.QuestionService;
import question.model.vo.Attachment;
import question.model.vo.Category;
import question.model.vo.Question;

/**
 * Servlet implementation class QuestionUpdateFormController
 */
@WebServlet("/updateForm.que")
public class QuestionUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int queNo = Integer.parseInt(request.getParameter("qno"));

		//질문 카테고리 
		ArrayList<Category> clist = new QuestionService().selectCategoryList();
	
		//질문 내용
		Question que = new QuestionService().selectQue(queNo);

		//질문 사진
		Attachment at = new QuestionService().selectAttachment(queNo);
		
		request.setAttribute("clist", clist);
		request.setAttribute("que", que);
		request.setAttribute("at", at);
		
		
		request.getRequestDispatcher("views/question/questionUpdateView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
