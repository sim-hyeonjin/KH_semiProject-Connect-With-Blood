package reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reservation.model.service.ReservationService;
import reservation.model.vo.Reservation;

/**
 * Servlet implementation class ReservationController
 */
@WebServlet("/enroll.reserv")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String reservationWriter = request.getParameter("userNo");
		String reservationAddress = request.getParameter("location");
		String reservationAddress2 = request.getParameter("locationDetail");
		String reservationDate = request.getParameter("time");
		
		Reservation reserv = new Reservation(reservationWriter, reservationAddress, reservationAddress2, reservationDate);
		
		int result = new ReservationService().enrollReservation(reserv);
		
		
		if(result>0) {
			
			HttpSession session = request.getSession();
			session.setAttribute("reserv", reserv);
			session.setAttribute("alertMsg", "헌혈 예약이 완료되었습니다.");
			
			request.getRequestDispatcher("views/member/mypage.jsp").forward(request, response);
		
		}else {
			request.setAttribute("errorMsg", "헌혈 예약에 실패하였습니다.");
			response.sendRedirect(request.getContextPath());
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
