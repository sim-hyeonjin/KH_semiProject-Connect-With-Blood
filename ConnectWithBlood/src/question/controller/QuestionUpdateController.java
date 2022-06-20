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

import common.MyFileRenamePolicy;
import question.model.service.QuestionService;
import question.model.vo.Attachment;
import question.model.vo.Question;

/**
 * Servlet implementation class QuestionUpdateController
 */
@WebServlet("/update.que")
public class QuestionUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		if(ServletFileUpload.isMultipartContent(request)) {

			int maxSize = 10*1024*1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/que_upfiles/");

			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());

			int queNo = Integer.parseInt(multiRequest.getParameter("qno"));
			String queCategory = multiRequest.getParameter("category");
			String queTitle = multiRequest.getParameter("title");
			String queContent = multiRequest.getParameter("content");
			
			Question que = new Question();
			
			que.setQuestionNo(queNo);
			que.setQuestionTag(queCategory);
			que.setQuestionTitle(queTitle);
			que.setQuestionContent(queContent);
			
			
			Attachment newAttachment = null;
			
			if(multiRequest.getOriginalFileName("reupfileQue")!=null) {
				
				newAttachment = new Attachment();
				newAttachment.setOriginName(multiRequest.getOriginalFileName("reupfileQue"));
				newAttachment.setChangeName(multiRequest.getFilesystemName("reupfileQue"));
				newAttachment.setFilePath("resources/que_upfiles/");
				
				if(multiRequest.getParameter("originFileNo")!=null) {
					
					int originFileNo = Integer.parseInt(multiRequest.getParameter("originFileNo"));
					
					newAttachment.setFileNo(originFileNo);
					
					new File(savePath+multiRequest.getParameter("originFileName")).delete();
					
				}else {
					newAttachment.setRefQno(queNo);
				}
				
			}
			
			int result = new QuestionService().updateQuestion(que,newAttachment);
			
			
			if(result>0) {
				request.getSession().setAttribute("alertMsg", "질문이 수정되었습니다");

				response.sendRedirect(request.getContextPath()+"/detail.que?qno="+queNo);
			}else {
				request.setAttribute("errorMsg", "질문 수정 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
