package com.asiana.lawgic;

import java.sql.SQLException;

public class TestDataInsertMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		ClientTestDataInsert clientDataInsert=new ClientTestDataInsert();
//		clientDataInsert.InsertClients();
		
		
//		MessageTestDataInsert messageDataInsert=new MessageTestDataInsert();
//		messageDataInsert.InsertMessage();
		
		ChatTestDataInsert chatDataInsert=new ChatTestDataInsert();
		chatDataInsert.InsertClients();
		
//		CategoryTestDataInsert categoryTestDataInsert = new CategoryTestDataInsert();
//        System.out.println(categoryTestDataInsert.setCategoryInfomation());

	}
}
