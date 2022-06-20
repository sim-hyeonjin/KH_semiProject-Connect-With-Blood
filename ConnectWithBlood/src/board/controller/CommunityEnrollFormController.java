package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.CommunityService;
import board.model.vo.Category;

/**
 * Servlet implementation class CommunityEnrollFormController
 */
@WebServlet("/enrollForm.co")
public class CommunityEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityEnrollFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//CommunityEnrollFormController는 주소 / 카테고리 db에서 가져오려고 있음
		//가져와서 등록페이지(=communityEnrollForm.jsp)로 감
		

		//카테고리데이터 가져오기
		ArrayList<Category> list = new CommunityService().selectCategoryList();

		request.setAttribute("list",list);
		request.getRequestDispatcher("views/board/communityEnrollForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
