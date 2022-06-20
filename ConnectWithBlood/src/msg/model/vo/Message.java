package msg.model.vo;

import java.sql.Date;

public class Message {

	private int msgNo;			//	MESSAGE_NO	NUMBER
	private String msgTitle;			//	MESSAGE_TITLE	VARCHAR2(100 BYTE)
	private String msgContent;			//	MESSAGE_CONTENT	VARCHAR2(4000 BYTE)
	private Date msgTime;			//	MESSAGE_TIME	DATE
	private int msgSend;			//	MESSAGE_SEND	NUMBER
	private int msgReceive;			//	MESSAGE_RECEIVE	NUMBER
	private String msgStatus;			//	MESSAGE_STATUS	VARCHAR2(1 BYTE)
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(int msgNo, String msgTitle, String msgContent, Date msgTime, int msgSend, int msgReceive,
			String msgStatus) {
		super();
		this.msgNo = msgNo;
		this.msgTitle = msgTitle;
		this.msgContent = msgContent;
		this.msgTime = msgTime;
		this.msgSend = msgSend;
		this.msgReceive = msgReceive;
		this.msgStatus = msgStatus;
	}

	public int getMsgNo() {
		return msgNo;
	}

	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Date getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}

	public int getMsgSend() {
		return msgSend;
	}

	public void setMsgSend(int msgSend) {
		this.msgSend = msgSend;
	}

	public int getMsgReceive() {
		return msgReceive;
	}

	public void setMsgReceive(int msgReceive) {
		this.msgReceive = msgReceive;
	}

	public String getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}

	@Override
	public String toString() {
		return "Message [msgNo=" + msgNo + ", msgTitle=" + msgTitle + ", msgContent=" + msgContent + ", msgTime="
				+ msgTime + ", msgSend=" + msgSend + ", msgReceive=" + msgReceive + ", msgStatus=" + msgStatus + "]";
	}
	
	
	
}
