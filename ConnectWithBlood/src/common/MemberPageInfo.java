package common;


	//회원상태 규민파트 페이징처리

	public class MemberPageInfo {
		int listCount; 	 // 현재 총 게시글 개수 (담아놓을 변수) -> 현재 총 멤버수
		int currentPage; // 현재 페이지(사용자가 요청한 페이지)
		int pageLimit;   // 페이지 하단에 보이는 페이지 페이징 최대 개수
		int memberLimit; // 한 페이지에서 보여질 게시글 개수 -> 한페이지에서 보여질 회원명단(수업과 같이 10명으로)
		int maxPage;     // 가장 마지막 페이지가 몇 번 페이지인지(총 페이지수)
		int startPage;   // 페이징 하단에 보여질 페이징 시작 수
		int endPage;     // 페이지 하단에 보여질 페이징 끝 수
	
	public MemberPageInfo() {
		super();
	}

	public MemberPageInfo(int listCount, int currentPage, int pageLimit, int memberLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.memberLimit = memberLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getMemberLimit() {
		return memberLimit;
	}

	public void setMemberLimit(int memberLimit) {
		this.memberLimit = memberLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "MemberPageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", memberLimit=" + memberLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
	
	
	
}
