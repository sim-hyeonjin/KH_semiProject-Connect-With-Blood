package board.model.vo;

import java.sql.Date;

public class Community {
		
		private int commNo;								//	COMM_NO	NUMBER
		private String commTitle;						//	COMM_TITLE	VARCHAR2(100 BYTE)
		private String commContent;						//	COMM_CONTENT	VARCHAR2(4000 BYTE)
		private int commCount;							//	COMM_COUNT	NUMBER
		private Date commDate;							//	COMM_DATE	DATE
		private String commWriter;						//	COMM_WRITER	NUMBER
		private String categoryNo;							//	CATEGORY_NO	NUMBER
		private String commStatus;						//	COMM_STATUS	VARCHAR2(1 BYTE)
		
		public Community() {
			super();
		}

		public Community(int commNo, String commTitle, String commContent, int commCount, Date commDate,
				String commWriter, String categoryNo, String commStatus) {
			super();
			this.commNo = commNo;
			this.commTitle = commTitle;
			this.commContent = commContent;
			this.commCount = commCount;
			this.commDate = commDate;
			this.commWriter = commWriter;
			this.categoryNo = categoryNo;
			this.commStatus = commStatus;
		}	
		
		public Community(int commNo, String commTitle, int commCount, Date commDate, String commWriter,
				String categoryNo) {
			super();
			this.commNo = commNo;
			this.commTitle = commTitle;
			this.commCount = commCount;
			this.commDate = commDate;
			this.commWriter = commWriter;
			this.categoryNo = categoryNo;
		}
		
		

		public Community(int commNo, String commTitle, String commContent, Date commDate, String commWriter,
				String categoryNo) {
			super();
			this.commNo = commNo;
			this.commTitle = commTitle;
			this.commContent = commContent;
			this.commDate = commDate;
			this.commWriter = commWriter;
			this.categoryNo = categoryNo;
		}

		public int getCommNo() {
			return commNo;
		}

		public void setCommNo(int commNo) {
			this.commNo = commNo;
		}

		public String getCommTitle() {
			return commTitle;
		}

		public void setCommTitle(String commTitle) {
			this.commTitle = commTitle;
		}

		public String getCommContent() {
			return commContent;
		}

		public void setCommContent(String commContent) {
			this.commContent = commContent;
		}

		public int getCommCount() {
			return commCount;
		}

		public void setCommCount(int commCount) {
			this.commCount = commCount;
		}

		public Date getCommDate() {
			return commDate;
		}

		public void setCommDate(Date commDate) {
			this.commDate = commDate;
		}

		public String getCommWriter() {
			return commWriter;
		}

		public void setCommWriter(String commWriter) {
			this.commWriter = commWriter;
		}

		public String getCategoryNo() {
			return categoryNo;
		}

		public void setCategoryNo(String categoryNo) {
			this.categoryNo = categoryNo;
		}

		public String getCommStatus() {
			return commStatus;
		}

		public void setCommStatus(String commStatus) {
			this.commStatus = commStatus;
		}

		@Override
		public String toString() {
			return "Community [commNo=" + commNo + ", commTitle=" + commTitle + ", commContent=" + commContent
					+ ", commCount=" + commCount + ", commDate=" + commDate + ", commWriter=" + commWriter
					+ ", categoryNo=" + categoryNo + ", commStatus=" + commStatus + "]";
		}
		
		
		
		
	
}
