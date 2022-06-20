package faq.model.service;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import faq.model.dao.FaqDao;
import faq.model.vo.Faq;

public class FaqService {

	public ArrayList<Faq> selectFaqList() {
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new FaqDao().selectFaqList(conn);
		
		close(conn);
		
		return list;
	}

}
