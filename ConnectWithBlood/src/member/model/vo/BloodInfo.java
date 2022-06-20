package member.model.vo;

import java.sql.Date;

public class BloodInfo {

	private String bloodNo;		//    BLOOD_NO VARCHAR2(100) PRIMARY KEY,  -- jsp에서 자리수 제한, 검증 필요
	private String bloodWh;		//    BLOOD_WH VARCHAR2(100),
	private Date bloodDate;		//    BLOOD_DATE DATE DEFAULT SYSDATE,
	private int bloodOwner;		//    BLOOD_OWNER NUMBER NOT NULL,
			//    FOREIGN KEY(BLOOD_OWNER) REFERENCES MEMBER(USER_NO)
    
	
	
	public BloodInfo() {
		// TODO Auto-generated constructor stub
	}
	
	

	//회원증 등록
	public BloodInfo(String bloodNo, String bloodWh, int bloodOwner) {
		super();
		this.bloodNo = bloodNo;
		this.bloodWh = bloodWh;
		this.bloodOwner = bloodOwner;
	}
	public BloodInfo(String bloodNo2, String bloodWh2, String userId) {
		// TODO Auto-generated constructor stub
	}



	public BloodInfo(String bloodNo, String bloodWh, Date bloodDate, int bloodOwner) {
		super();
		this.bloodNo = bloodNo;
		this.bloodWh = bloodWh;
		this.bloodDate = bloodDate;
		this.bloodOwner = bloodOwner;
	}


	public String getBloodNo() {
		return bloodNo;
	}

	public void setBloodNo(String bloodNo) {
		this.bloodNo = bloodNo;
	}


	public String getBloodWh() {
		return bloodWh;
	}

	public void setBloodWh(String bloodWh) {
		this.bloodWh = bloodWh;
	}

	public Date getBloodDate() {
		return bloodDate;
	}

	public void setBloodDate(Date bloodDate) {
		this.bloodDate = bloodDate;
	}

	public int getBloodOwner() {
		return bloodOwner;
	}

	public void setBloodOwner(int bloodOwner) {
		this.bloodOwner = bloodOwner;
	}

	@Override
	public String toString() {
		return "BloodInfo [bloodNo=" + bloodNo + ", bloodWh=" + bloodWh + ", bloodDate="
				+ bloodDate + ", bloodOwner=" + bloodOwner + "]";
	}

	

	
	
	
}
