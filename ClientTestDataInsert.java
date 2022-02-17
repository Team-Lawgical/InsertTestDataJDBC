package com.asiana.lawgic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientTestDataInsert {
	private Connection conn;
	
	private String[] clientName={"Young", "Jack", "Teddy"};
	private String[] clientPassword={"pwd1324", "dwefd454!", "cvlsd!%"};
	private String[] clientId={"client1", "client2","client3"};
	private String[] clientBirthday={"1994-05-23","1995-03-16","1995-08-11"};
	private String[] clientEmail={"young@naver.com","JaeUk@Yahoo.com","JungHyun@nate.com"};
	private String[] clientAddress={"Gyeonggi-do Republic of Korea","Gyeonggi-do Republic of Korea", "Seoul, Republic of Korea"};
	private String[] clientPhone={"01030588541","01033462624","01078738433"};
	private String[] clientCarType={"Genesis","Sonata","Lamborghini"};
	private int[] clientGender={1,0,1};
	
	public ClientTestDataInsert(){
		this.conn=DatabaseConnection.getConnection();
	}
	
	public void InsertClients() throws SQLException{
		String sql="";
		PreparedStatement pstmt=null;
		//pstmt.setInt(1,  employeeId);
		ResultSet rs=null;
		for(int i=0;i<3;i++){
			sql="INSERT INTO client (client_id, client_pw, client_name,client_birthday, client_email, client_address, client_phone, client_car_type, client_gender) "
					+ "VALUES ("+"'"+clientId[i]+"'"+","+"'"+clientPassword[i]+"'"+","+"'"+clientName[i]+"'"+","+
					"'"+clientBirthday[i]+"'"+","+"'"+clientEmail[i]+"'"+","+"'"+clientAddress[i]+"'"+","+"'"+clientPhone[i]+"'"+","+"'"+clientCarType[i]+"'"+","+"'"+clientGender[i]+"'"+")";
			System.out.println("sql:"+sql);
//			pstmt=conn.prepareStatement(sql);
//			rs=pstmt.executeQuery();
		}
		rs.close();
		pstmt.close();
		System.out.println("Client 데이터 삽입 완료");
	}
}

