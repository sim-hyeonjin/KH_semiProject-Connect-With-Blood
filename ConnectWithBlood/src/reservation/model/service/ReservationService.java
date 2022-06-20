package reservation.model.service;
import static common.JDBCTemplate.*;

import java.sql.Connection;

import reservation.model.dao.ReservationDao;
import reservation.model.vo.Reservation;

public class ReservationService {

	public int enrollReservation(Reservation reserv) {
		
		Connection conn = getConnection();
		
		int result = new ReservationDao().enrollReservation(conn, reserv);
		
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

	public Reservation selectReservationList(String userNo) {
		
		Connection conn = getConnection();
		
		Reservation r = new ReservationDao().selectReservationList(conn,userNo);
		
		close(conn);
		
		return r;
		
	}

}
