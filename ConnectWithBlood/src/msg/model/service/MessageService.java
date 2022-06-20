package msg.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.vo.Member;
import msg.model.dao.MessageDao;

public class MessageService {

	public ArrayList<Member> searchId(String searchId) {

		Connection conn = getConnection();
		
		ArrayList<Member> list = new MessageDao().searchId(conn,searchId);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Member> memberListMsg() {

		Connection conn = getConnection();
		
		ArrayList<Member> list = new MessageDao().memberListMsg(conn);

		close(conn);
		
		return list;
	}

}
