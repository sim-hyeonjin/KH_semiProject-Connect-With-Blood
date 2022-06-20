package question.model.vo;

import java.sql.Date;

public class Question {

	private int questionNo;				//	QUESTION_NO	NUMBER
	private String questionTitle;       //	QUESTION_TITLE	VARCHAR2(100 BYTE)
	private String questionContent;	    //	QUESTION_CONTENT	VARCHAR2(4000 BYTE)
	private Date questionDate;			//	QUESTION_DATE	DATE
	private String questionTag;			//	QUESTION_TAG	
	private String questionAnswer;		//	QUESTION_ANS	VARCHAR2(4000 BYTE)
	private Date questionAnswerDate;	//	QUESTION_ANSDATE	DATE
	private String questionWriter;		//	QUESTION_WRITER	NUMBER
	private String questionStatus;		//	QUESTION_STATUS	VARCHAR2(1 BYTE)
	private String categoryNo;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int questionNo, String questionTitle, String questionContent, Date questionDate, String questionTag,
			String questionAnswer, Date questionAnswerDate, String questionWriter, String questionStatus,
			String categoryNo) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionDate = questionDate;
		this.questionTag = questionTag;
		this.questionAnswer = questionAnswer;
		this.questionAnswerDate = questionAnswerDate;
		this.questionWriter = questionWriter;
		this.questionStatus = questionStatus;
		this.categoryNo = categoryNo;
	}
	
	

	public Question(int questionNo, String questionTitle, String questionContent, Date questionDate,
			String questionWriter, String categoryNo) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionDate = questionDate;
		this.questionWriter = questionWriter;
		this.categoryNo = categoryNo;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public Date getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}

	public String getQuestionTag() {
		return questionTag;
	}

	public void setQuestionTag(String questionTag) {
		this.questionTag = questionTag;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public Date getQuestionAnswerDate() {
		return questionAnswerDate;
	}

	public void setQuestionAnswerDate(Date questionAnswerDate) {
		this.questionAnswerDate = questionAnswerDate;
	}

	public String getQuestionWriter() {
		return questionWriter;
	}

	public void setQuestionWriter(String questionWriter) {
		this.questionWriter = questionWriter;
	}

	public String getQuestionStatus() {
		return questionStatus;
	}

	public void setQuestionStatus(String questionStatus) {
		this.questionStatus = questionStatus;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "Question [questionNo=" + questionNo + ", questionTitle=" + questionTitle + ", questionContent="
				+ questionContent + ", questionDate=" + questionDate + ", questionTag=" + questionTag
				+ ", questionAnswer=" + questionAnswer + ", questionAnswerDate=" + questionAnswerDate
				+ ", questionWriter=" + questionWriter + ", questionStatus=" + questionStatus + ", categoryNo="
				+ categoryNo + "]";
	}
	
	
}


