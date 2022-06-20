package board.model.vo;

import java.sql.Date;

public class Attachment {

	private int fileNo;				//	FILE_NO	NUMBER
	private String originName;				//	ORIGIN_NAME	VARCHAR2(255 BYTE)
	private String changeName;				//	CHANGE_NAME	VARCHAR2(255 BYTE)
	private String filePath;				//	FILE_PATH	VARCHAR2(1000 BYTE)
	private Date uploadDate;				//	UPLOAD_DATE	DATE
	private int fileLevel;				//	FILE_LEVEL	NUMBER
	private int refCno;				//	REF_CNO	NUMBER
	private String status;				//	STATUS	VARCHAR2(1 BYTE)
	
	public Attachment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attachment(int fileNo, String originName, String changeName, String filePath, Date uploadDate, int fileLevel,
			int refCno, String status) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.fileLevel = fileLevel;
		this.refCno = refCno;
		this.status = status;
	}

	
	public Attachment(int fileNo, String originName, String changeName, String filePath) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public int getRefCno() {
		return refCno;
	}

	public void setRefCno(int refCno) {
		this.refCno = refCno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", fileLevel=" + fileLevel + ", refCno="
				+ refCno + ", status=" + status + "]";
	}
	
	
	
}
