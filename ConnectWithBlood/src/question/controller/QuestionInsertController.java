package question.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import question.model.vo.Attachment;
import common.MyFileRenamePolicy;
import question.model.service.QuestionService;
import question.model.vo.Question;

/**
 * Servlet implementation class QuestionInsertController
 */
@WebServlet("/insert.que")
public class QuestionInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		if(ServletFileUpload.isMultipartContent(request)) {

			int maxSize = 10 * 1024 * 1024;

			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/que_upfiles/");

			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy()); 

			String category = multiRequest.getParameter("category");
			String queTitle = multiRequest.getParameter("title");
			String queContent = multiRequest.getParameter("content");
			String queWriter = multiRequest.getParameter("userNo");

			Question que = new Question();
			
			que.setQuestionTag(category);
			que.setQuestionTitle(queTitle);
			que.setQuestionContent(queContent);
			que.setQuestionWriter(queWriter);
			
			Attachment at = null;

			if(multiRequest.getOriginalFileName("upfileQue")!=null) {
				
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfileQue"));
				at.setChangeName(multiRequest.getFilesystemName("upfileQue"));
				
				at.setFilePath("resources/que_upfiles/");
				
			}
			
			int result = new QuestionService().insertQue(que,at);

			if(result>0) {
				request.getSession().setAttribute("alertMsg", "질문이 등록되었습니다");

				response.sendRedirect(request.getContextPath()+"/list.queu?qpage=1");
			}else {
				if(at!=null) {
					new File(savePath+at.getChangeName()).delete();
				}
				response.sendRedirect("views/common/communityErrorPage.jsp");
			}
			
			
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
