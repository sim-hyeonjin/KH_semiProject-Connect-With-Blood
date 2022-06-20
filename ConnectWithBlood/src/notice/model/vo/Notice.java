package notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int noticeNo;				//	NOTICE_NO	NUMBER
	private String noticeTitle;			//	NOTICE_TITLE	VARCHAR2(100 BYTE)
	private String noticeContent;		//	NOTICE_CONTENT	VARCHAR2(4000 BYTE)
	private Date noticeDate;			//	NOTICE_DATE	DATE
	private int noticeCount;			//	NOTICE_COUNT	NUMBER
	private String noticeWriter;		//	NOTICE_WRITER	NUMBER
	private String noticeStatus;		//	NOTICE_STATUS	VARCHAR2(1 BYTE)
	
	public Notice() {
		super();
	}

	public Notice(int noticeNo, String noticeTitle, String noticeContent, Date noticeDate, int noticeCount,
			String noticeWriter, String noticeStatus) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeCount = noticeCount;
		this.noticeWriter = noticeWriter;
		this.noticeStatus = noticeStatus;
	}


	public Notice(int noticeNo, String noticeTitle, String noticeContent, Date noticeDate, int noticeCount,
			String noticeWriter) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeCount = noticeCount;
		this.noticeWriter = noticeWriter;
	}

	
	public Notice(int noticeNo, String noticeTitle, String noticeContent, Date noticeDate, String noticeWriter) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeWriter = noticeWriter;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int getNoticeCount() {
		return noticeCount;
	}

	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	@Override
	public String toString() {
		return "Notice [NoticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeDate=" + noticeDate + ", noticeCount=" + noticeCount + ", noticeWriter=" + noticeWriter
				+ ", noticeStatus=" + noticeStatus + "]";
	}
	
	
	
	
	
	
	
	
	
	
}

