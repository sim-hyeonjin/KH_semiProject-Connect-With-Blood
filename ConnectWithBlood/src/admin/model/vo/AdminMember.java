package admin.model.vo;

import java.sql.Date;

public class AdminMember {


		private int userNo;//	USER_NO	NUMBER
		private String userId;//	USER_ID	VARCHAR2(20 BYTE)
		private String userPw;//	USER_PW	VARCHAR2(50 BYTE)
		private String userName;//	USER_NAME	VARCHAR2(20 BYTE)
		private String userBirth;//	USER_BIRTH	VARCHAR2(20 BYTE)
		private String userEmail;//	USER_EMAIL	VARCHAR2(50 BYTE)
		private String userPhone;//	USER_PHONE	VARCHAR2(20 BYTE)
		private String userAddress;//	USER_ADDRESS	VARCHAR2(500 BYTE)
		private Date userEnrolldate;//	USER_ENROLLDATE	DATE
		private String userGrade;//	USER_GRADE	VARCHAR2(20 BYTE)
		private String userBloodtype;//	USER_BLOODTYPE	VARCHAR2(10 BYTE)
		private Date userLogindate;//	USER_LOGINDATE	DATE
		private Date userWithdate;//	USER_WITHDATE	DATE
		private Date userSusdate;//	USER_SUSDATE	DATE
		private String userStatus;//	USER_STATUS	VARCHAR2(20 BYTE)
		//Logindate - 회원 로그인날짜
		//Withdate - 회원 탈퇴날짜
		//Susdate - 회원 정지/블랙리스트 날짜
		//Status - 회원상태(NORMAL/WITHDRAWAL/SUSPENSION/BLACKLIST)
		
		public AdminMember() {
			super();
		}
		
		
		//유저 페이징처리
		
		public AdminMember(String userId, String userName, Date userEnrolldate, String userGrade, Date userLogindate,
			String userStatus) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.userEnrolldate = userEnrolldate;
			this.userGrade = userGrade;
			this.userLogindate = userLogindate;
			this.userStatus = userStatus;
		}

		//회원정보 검색 유저 아이디,이름,등급
		public AdminMember(String userId, String userName, String userGrade) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.userGrade = userGrade;
		}

		

		public AdminMember(int userNo, String userId, String userPw, String userName, String userBirth, String userEmail,
				String userPhone, String userAddress, Date userEnrolldate, String userGrade, String userBloodtype,
				Date userLogindate, Date userWithdate, Date userSusdate, String userStatus) {
			super();
			this.userNo = userNo;
			this.userId = userId;
			this.userPw = userPw;
			this.userName = userName;
			this.userBirth = userBirth;
			this.userEmail = userEmail;
			this.userPhone = userPhone;
			this.userAddress = userAddress;
			this.userEnrolldate = userEnrolldate;
			this.userGrade = userGrade;
			this.userBloodtype = userBloodtype;
			this.userLogindate = userLogindate;
			this.userWithdate = userWithdate;
			this.userSusdate = userSusdate;
			this.userStatus = userStatus;
		}



		public int getUserNo() {
			return userNo;
		}
		public void setUserNo(int userNo) {
			this.userNo = userNo;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserPw() {
			return userPw;
		}
		public void setUserPw(String userPw) {
			this.userPw = userPw;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserBirth() {
			return userBirth;
		}
		public void setUserBirth(String userBirth) {
			this.userBirth = userBirth;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserPhone() {
			return userPhone;
		}
		public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
		}
		public String getUserAddress() {
			return userAddress;
		}
		public void setUserAddress(String userAddress) {
			this.userAddress = userAddress;
		}
		public Date getUserEnrolldate() {
			return userEnrolldate;
		}
		public void setUserEnrolldate(Date userEnrolldate) {
			this.userEnrolldate = userEnrolldate;
		}
		public String getUserGrade() {
			return userGrade;
		}
		public void setUserGrade(String userGrade) {
			this.userGrade = userGrade;
		}
		public String getUserBloodtype() {
			return userBloodtype;
		}
		public void setUserBloodtype(String userBloodtype) {
			this.userBloodtype = userBloodtype;
		}
		public Date getUserLogindate() {
			return userLogindate;
		}
		public void setUserLogindate(Date userLogindate) {
			this.userLogindate = userLogindate;
		}
		public Date getUserWithdate() {
			return userWithdate;
		}
		public void setUserWithdate(Date userWithdate) {
			this.userWithdate = userWithdate;
		}
		public Date getUserSusdate() {
			return userSusdate;
		}
		public void setUserSusdate(Date userSusdate) {
			this.userSusdate = userSusdate;
		}
		public String getUserStatus() {
			return userStatus;
		}
		public void setUserStatus(String userStatus) {
			this.userStatus = userStatus;
		}
		@Override
		public String toString() {
			return "Member [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
					+ ", userBirth=" + userBirth + ", userEmail=" + userEmail + ", userPhone=" + userPhone
					+ ", userAddress=" + userAddress + ", userEnrolldate=" + userEnrolldate + ", userGrade=" + userGrade
					+ ", userBloodtype=" + userBloodtype + ", userLogindate=" + userLogindate + ", userWithdate="
					+ userWithdate + ", userSusdate=" + userSusdate + ", userStatus=" + userStatus + "]";
		}

}