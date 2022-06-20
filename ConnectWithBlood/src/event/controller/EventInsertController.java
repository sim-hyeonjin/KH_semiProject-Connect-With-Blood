package event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.MyFileRenamePolicy;
import event.model.service.EventService;
import event.model.vo.Attachment;
import event.model.vo.Event;

/**
 * Servlet implementation class EventInsertController
 */
@WebServlet("/insert.ev")
public class EventInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventInsertController() {
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

			String savePath = request.getSession().getServletContext().getRealPath("/resources/event_upfiles/");

			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());

			Event e = new Event();
			
			e.setEventTitle(multiRequest.getParameter("title"));
			e.setEventContent(multiRequest.getParameter("content"));
			
			Attachment at = null;

			if(multiRequest.getOriginalFileName("upfile")!=null) {
				
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
			
				at.setFilePath("resources/event_upfiles/");

			
			}
			
			int result = new EventService().insertAttachmentEvent(e,at);
			
			if(result>0) {
				request.getSession().setAttribute("alertMsg", "이벤트가 작성되었습니다");

				response.sendRedirect(request.getContextPath()+"/list.ev?epage=1");
			}else{
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
