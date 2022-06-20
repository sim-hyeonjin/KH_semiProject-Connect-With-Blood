package reservation.model.vo;



public class Reservation {

	private int reservationNo;					//	RESERVATION_NO	NUMBER
	private String reservationAddress;			//	RESERVATION_ADDRESS	VARCHAR2(500 BYTE)
	private String reservationAddress2;			//	RESERVATION_ADDRESS2	VARCHAR2(500 BYTE)
	private String reservationDate;				//	RESERVATION_DATE	DATE
	private String reservationWriter;			//	RESERVATION_WRITER	NUMBER
	private	String reservationStatus;			//	RESERVATION_STATUS	VARCHAR2(1 BYTE)
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int reservationNo, String reservationAddress, String reservationAddress2, String reservationDate,
			String reservationWriter, String reservationStatus) {
		super();
		this.reservationNo = reservationNo;
		this.reservationAddress = reservationAddress;
		this.reservationAddress2 = reservationAddress2;
		this.reservationDate = reservationDate;
		this.reservationWriter = reservationWriter;
		this.reservationStatus = reservationStatus;
	}

	public Reservation(String reservationWriter, String reservationAddress, String reservationAddress2, String reservationDate
			) {
		super();
		this.reservationWriter = reservationWriter;
		this.reservationAddress = reservationAddress;
		this.reservationAddress2 = reservationAddress2;
		this.reservationDate = reservationDate;
	}

	
	//예약 조회
	public Reservation(int int1, String string, String string2, String string3, int int2, String string4) {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	public int getReservationNo() {
		return reservationNo;
	}


	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getReservationAddress() {
		return reservationAddress;
	}

	public void setReservationAddress(String reservationAddress) {
		this.reservationAddress = reservationAddress;
	}

	public String getReservationAddress2() {
		return reservationAddress2;
	}

	public void setReservationAddress2(String reservationAddress2) {
		this.reservationAddress2 = reservationAddress2;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationWriter() {
		return reservationWriter;
	}

	public void setReservationWriter(String reservationWriter) {
		this.reservationWriter = reservationWriter;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	@Override
	public String toString() {
		return "Reservation [reservationNo=" + reservationNo + ", reservationAddress=" + reservationAddress
				+ ", reservationAddress2=" + reservationAddress2 + ", reservationDate=" + reservationDate
				+ ", reservationWriter=" + reservationWriter + ", reservationStatus=" + reservationStatus + "]";
	}

	
	
	
}
