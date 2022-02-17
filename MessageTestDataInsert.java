package com.asiana.lawgic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageTestDataInsert {
private Connection conn;
	
	private String[] chatId={"chat1", "chat1", "chat1","chat2","chat3"};
	private String[] content={"안녕하세요!", "안녕하세요 김윤성 변호사 입니다.", "제가 차대차 사고가 났는데 어떻게 해야 할까요?","즉결 심판 가시는 걸 추천드립니다.","상담해주셔서 감사합니다."};
	private String[] sender={"유영균", "김윤성","오재욱","김정현","이동은"};
	private int[] type={1,1,1,1,1};
	private String[] regdate={"2022-01-23","2022-01-23","2022-01-23","2022-01-24","2022-01-24"};

	
	public MessageTestDataInsert(){
		this.conn=DatabaseConnection.getConnection();
	}
	
	public void InsertMessage() throws SQLException{
		String sql="";
		PreparedStatement pstmt=null;
		//pstmt.setInt(1,  employeeId);
		ResultSet rs=null;
		for(int i=0;i<chatId.length;i++){
			sql="INSERT INTO messages (chat_id, content, sender, type, regdate) "
					+ "VALUES ("+"'"+chatId[i]+"'"+","+"'"+content[i]+"'"+","+"'"+sender[i]+"'"+","+
					"'"+type[i]+"'"+","+"'"+regdate[i]+"'"+")";
			System.out.println("sql:"+sql);
//			pstmt=conn.prepareStatement(sql);
//			rs=pstmt.executeQuery();
		}
		rs.close();
		pstmt.close();
		System.out.println("Message 데이터 삽입 완료");
	}
}
