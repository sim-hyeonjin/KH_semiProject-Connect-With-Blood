package question.model.vo;

import java.sql.Date;

public class Answer {

	private int ansNo;					//	ANS_NO	NUMBER
	private String ansTitle;					//	ANS_TITLE	VARCHAR2(100 BYTE)
	private String ansContent;					//	ANS_CONTENT	VARCHAR2(100 BYTE)
	private String ansDate;					//	ANS_DATE	DATE
	private int originNo;					//	ORIGIN_NO	NUMBER
	private String ansStatus;					//	ANS_STATUS	VARCHAR2(1 BYTE)
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int ansNo, String ansTitle, String ansContent, String ansDate, int originNo, String ansStatus) {
		super();
		this.ansNo = ansNo;
		this.ansTitle = ansTitle;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
		this.originNo = originNo;
		this.ansStatus = ansStatus;
	}

	public Answer(int ansNo, String ansContent, String ansDate) {
		super();
		this.ansNo = ansNo;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
	}

	public int getAnsNo() {
		return ansNo;
	}

	public void setAnsNo(int ansNo) {
		this.ansNo = ansNo;
	}

	public String getAnsTitle() {
		return ansTitle;
	}

	public void setAnsTitle(String ansTitle) {
		this.ansTitle = ansTitle;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	public String getAnsDate() {
		return ansDate;
	}

	public void setAnsDate(String ansDate) {
		this.ansDate = ansDate;
	}

	public int getOriginNo() {
		return originNo;
	}

	public void setOriginNo(int originNo) {
		this.originNo = originNo;
	}

	public String getAnsStatus() {
		return ansStatus;
	}

	public void setAnsStatus(String ansStatus) {
		this.ansStatus = ansStatus;
	}

	@Override
	public String toString() {
		return "Answer [ansNo=" + ansNo + ", ansTitle=" + ansTitle + ", ansContent=" + ansContent + ", ansDate="
				+ ansDate + ", originNo=" + originNo + ", ansStatus=" + ansStatus + "]";
	}
	
	
	
	
}
