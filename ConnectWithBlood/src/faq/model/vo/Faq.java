package faq.model.vo;

import java.sql.Date;

public class Faq {

	private int faqNo;				//	FAQ_NO	NUMBER
	private String faqTitle;		//	FAQ_TITLE	VARCHAR2(100 BYTE)
	private String faqContent;		//	FAQ_CONTENT	VARCHAR2(4000 BYTE)
	private Date faqDate;			//	FAQ_DATE	DATE
	private String faqStatus;		//	FAQ_STATUS	VARCHAR2(1 BYTE)
	
	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faq(int faqNo, String faqTitle, String faqContent, Date faqDate, String faqStatus) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqDate = faqDate;
		this.faqStatus = faqStatus;
	}

	public Faq(int faqNo, String faqTitle, String faqContent, Date faqDate) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqDate = faqDate;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public Date getFaqDate() {
		return faqDate;
	}

	public void setFaqDate(Date faqDate) {
		this.faqDate = faqDate;
	}

	public String getFaqStatus() {
		return faqStatus;
	}

	public void setFaqStatus(String faqStatus) {
		this.faqStatus = faqStatus;
	}

	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + ", faqDate=" + faqDate
				+ ", faqStatus=" + faqStatus + "]";
	}
	
}
