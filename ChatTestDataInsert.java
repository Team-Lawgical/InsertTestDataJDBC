package com.asiana.lawgic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatTestDataInsert {
private Connection conn;
	
	private String[] chatId={"chat1", "chat2", "chat3"};
	private String[] clientId={"client1", "client2", "client3"};
	private String[] lawyerId={"lawyer1", "lawyer2","lawyer3"};
	private String[] consultId={"consult1","consult2","consult3"};

	
	public ChatTestDataInsert(){
		this.conn=DatabaseConnection.getConnection();
	}
	public void InsertClients() throws SQLException{
		String sql="";
		PreparedStatement pstmt=null;
		//pstmt.setInt(1,  employeeId);
		ResultSet rs=null;
		for(int i=0;i<3;i++){
			sql="INSERT INTO chat (chat_id, client_id, lawyer_id,consult_id) "
					+ "VALUES ("+"'"+chatId[i]+"'"+","+"'"+clientId[i]+"'"+","+"'"+lawyerId[i]+"'"+","+
					"'"+consultId[i]+"'"+")";
			System.out.println("sql:"+sql);
		//	pstmt=conn.prepareStatement(sql);
			//rs=pstmt.executeQuery();
		}
		rs.close();
		pstmt.close();
		System.out.println("Chat 데이터 삽입 완료");
	}
}
