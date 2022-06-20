package event.controller;

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
import event.model.service.EventService;
import event.model.vo.Attachment;
import event.model.vo.Event;

/**
 * Servlet implementation class EventUpdateController
 */
@WebServlet("/update.ev")
public class EventUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventUpdateController() {
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
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/event_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());

			int eventNo = Integer.parseInt(multiRequest.getParameter("eno"));
			String eventTitle = multiRequest.getParameter("title");
			String eventContent = multiRequest.getParameter("content");
			
			Event e = new Event();
			
			e.setEventNo(eventNo);
			e.setEventTitle(eventTitle);
			e.setEventContent(eventContent);
			
			Attachment newAttachment = null;

			if(multiRequest.getOriginalFileName("reupfile")!=null) { 

				newAttachment = new Attachment();
				newAttachment.setOriginName(multiRequest.getOriginalFileName("reupfile"));
				newAttachment.setChangeName(multiRequest.getFilesystemName("reupfile"));
				newAttachment.setFilePath("resources/event_upfiles/");
				
				if(multiRequest.getParameter("originFileNo")!=null) {
					
					int originFileNo = Integer.parseInt(multiRequest.getParameter("originFileNo"));

					newAttachment.setFileNo(originFileNo); 

					new File(savePath+multiRequest.getParameter("originFileName")).delete();

					
				}else {
					newAttachment.setRefEno(eventNo);

				}
				
			}
			
			int result = new EventService().updateEvent(e,newAttachment);

			if(result>0) {
				request.getSession().setAttribute("alertMsg", "이벤트가 수정되었습니다");

				response.sendRedirect(request.getContextPath()+"/detail.ev?eno="+eventNo);
			}else {
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
