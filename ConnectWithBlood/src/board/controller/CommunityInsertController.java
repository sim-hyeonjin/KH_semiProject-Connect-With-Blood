package board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.CommunityService;
import board.model.vo.Attachment;
import board.model.vo.Community;
import common.MyFileRenamePolicy;

/**
 * Servlet implementation class CommunityInsertController
 */
@WebServlet("/insert.co")
public class CommunityInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityInsertController() {
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

			String savePath = request.getSession().getServletContext().getRealPath("/resources/comm_upfiles/");
			
			
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy()); 

			
			String category = multiRequest.getParameter("category");
			String commTitle = multiRequest.getParameter("title");
			String commContent = multiRequest.getParameter("content");
			String commWriter = multiRequest.getParameter("userNo");
			
			Community comm = new Community();
			
			comm.setCategoryNo(category);
			comm.setCommTitle(commTitle);
			comm.setCommContent(commContent);
			comm.setCommWriter(commWriter);
			
			
			Attachment at = null;
			
			if(multiRequest.getOriginalFileName("upfile")!=null) {
				
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
			
				at.setFilePath("resources/comm_upfiles/");

			
			}
			
			int result = new CommunityService().insertComm(comm,at);

			if(result>0) {
				request.getSession().setAttribute("alertMsg", "게시글이 작성되었습니다");
				response.sendRedirect(request.getContextPath()+"/list.co?cpage=1");

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
