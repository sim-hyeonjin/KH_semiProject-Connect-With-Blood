package board.model.vo;

public class Reply {

	private int replyNo;				//	REPLY_NO	NUMBER
	private String replyContent;				//	REPLY_CONTENT	VARCHAR2(100 BYTE)
	private String replyDate;				//	REPLY_DATE	DATE
	private int replyCommNo;				//	REPLY_COMMNO	NUMBER
	private String replyWriter;				//	REPLY_WRITER	NUMBER
	private String replyStatus;				//	REPLY_STATUS	VARCHAR2(1 BYTE)
	
	
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reply(int replyNo, String replyContent, String replyDate, int replyCommNo, String replyWriter,
			String replyStatus) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyCommNo = replyCommNo;
		this.replyWriter = replyWriter;
		this.replyStatus = replyStatus;
	}


	public Reply(int replyNo, String replyContent, String replyDate, String replyWriter) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyWriter = replyWriter;
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public String getReplyDate() {
		return replyDate;
	}


	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}


	public int getReplyCommNo() {
		return replyCommNo;
	}


	public void setReplyCommNo(int replyCommNo) {
		this.replyCommNo = replyCommNo;
	}


	public String getReplyWriter() {
		return replyWriter;
	}


	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}


	public String getReplyStatus() {
		return replyStatus;
	}


	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}


	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyDate=" + replyDate
				+ ", replyCommNo=" + replyCommNo + ", replyWriter=" + replyWriter + ", replyStatus=" + replyStatus
				+ "]";
	}
	
		
	
}
