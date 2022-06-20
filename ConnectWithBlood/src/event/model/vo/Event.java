package event.model.vo;

import java.sql.Date;

public class Event {

		private int eventNo;			//		EVENT_NO	NUMBER
		private String eventTitle;			//		EVENT_TITLE	VARCHAR2(100 BYTE)
		private String eventContent;			//		EVENT_CONTENT	VARCHAR2(4000 BYTE)
		private Date eventDate;			//		EVENT_DATE	DATE
		private int eventCount;			//		EVENT_COUNT	NUMBER
		private String eventProgress;			//		EVENT_PROGRESS	VARCHAR2(10 BYTE)
		private String eventStatus;			//		EVENT_STATUS	VARCHAR2(1 BYTE)
		
		private String titleImg;

		
		public Event() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Event(int eventNo, String eventTitle, String eventContent, Date eventDate, int eventCount,
				String eventProgress, String eventStatus) {
			super();
			this.eventNo = eventNo;
			this.eventTitle = eventTitle;
			this.eventContent = eventContent;
			this.eventDate = eventDate;
			this.eventCount = eventCount;
			this.eventProgress = eventProgress;
			this.eventStatus = eventStatus;
		}

		public Event(int eventNo, String eventTitle, int eventCount, String titleImg) {
			super();
			this.eventNo = eventNo;
			this.eventTitle = eventTitle;
			this.eventCount = eventCount;
			this.titleImg = titleImg;
		}

		public Event(int eventNo, String eventTitle, Date eventDate, int eventCount, String eventProgress) {
			super();
			this.eventNo = eventNo;
			this.eventTitle = eventTitle;
			this.eventDate = eventDate;
			this.eventCount = eventCount;
			this.eventProgress = eventProgress;
		}

		public Event(int eventNo, String eventTitle, String eventContent, Date eventDate, String eventProgress) {
			super();
			this.eventNo = eventNo;
			this.eventTitle = eventTitle;
			this.eventContent = eventContent;
			this.eventDate = eventDate;
			this.eventProgress = eventProgress;
		}

		public int getEventNo() {
			return eventNo;
		}

		public void setEventNo(int eventNo) {
			this.eventNo = eventNo;
		}

		public String getEventTitle() {
			return eventTitle;
		}

		public void setEventTitle(String eventTitle) {
			this.eventTitle = eventTitle;
		}

		public String getEventContent() {
			return eventContent;
		}

		public void setEventContent(String eventContent) {
			this.eventContent = eventContent;
		}

		public Date getEventDate() {
			return eventDate;
		}

		public void setEventDate(Date eventDate) {
			this.eventDate = eventDate;
		}

		public int getEventCount() {
			return eventCount;
		}

		public void setEventCount(int eventCount) {
			this.eventCount = eventCount;
		}

		public String getEventProgress() {
			return eventProgress;
		}

		public void setEventProgress(String eventProgress) {
			this.eventProgress = eventProgress;
		}

		public String getEventStatus() {
			return eventStatus;
		}

		public void setEventStatus(String eventStatus) {
			this.eventStatus = eventStatus;
		}

		public String getTitleImg() {
			return titleImg;
		}

		public void setTitleImg(String titleImg) {
			this.titleImg = titleImg;
		}

		@Override
		public String toString() {
			return "Event [eventNo=" + eventNo + ", eventTitle=" + eventTitle + ", eventContent=" + eventContent
					+ ", eventDate=" + eventDate + ", eventCount=" + eventCount + ", eventProgress=" + eventProgress
					+ ", eventStatus=" + eventStatus + "]";
		}
	
		
		
	
}
