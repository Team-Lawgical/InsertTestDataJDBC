package com.asiana.lawgic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultTestDataInsert {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private String sql = null;

    private String[] consultId = {"1", "2", "3"};
    private String[] appointmentDate = {"2022-02-15", "2022-02-16", "2022-02-17"};
    private String[] attorney = {"jaeuk", "youngkyun", "junghyun"};
    private String[] summary = {"url1", "url2", "url3"};
    private String[] judgement = {"유죄", "유죄", "유죄"};
    private String[] comments = {"없습니다", "없습니다", "없습니다"};
    private String[] oppponentName = {"오재욱", "김정현", "박동은"};
    private String[] oppponentAddress = {"서대문구", "강서구", "영등포구"};
    private String[] oppponentBirthday = {"1994-02-15", "1995-02-16", "1996-02-17"};
    private String[] oppponentPhone = {"010145678", "010345670", "012345679"};
    private String[] oppponentCarType = {"소형차", "중형차", "대형차"};
//    private String[] clientId = {"01012345678", "01012345670", "01012345679"};

    public ConsultTestDataInsert() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        // 2. DB 연결
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
        String user = "hr";
        String pw = "hr";
        connection = DriverManager.getConnection(url, user, pw);
        System.out.println("1, 2, connection ok");
    }

    /* 사원 번호를 이용해서 사원의 이름을 확인하세요 */
    public boolean setConsultInfomation() throws SQLException {

        try {
            for (int i = 0; i < 3; i++) {
                sql = "INSERT INTO consult(consult_id, appointment_date, attorney, summary, " +
                        "judgment, comments, opponent_name, opponent_address, " +
                        "opponent_birthday, opponent_phone, opponent_car_type, client_id) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, consultId[i]);
                preparedStatement.setString(2, appointmentDate[i]);
                preparedStatement.setString(3, attorney[i]);
                preparedStatement.setString(4, summary[i]);
                preparedStatement.setString(5, judgement[i]);
                preparedStatement.setString(6, comments[i]);
                preparedStatement.setString(7, oppponentName[i]);
                preparedStatement.setString(8, oppponentAddress[i]);
                preparedStatement.setString(9, oppponentBirthday[i]);
                preparedStatement.setString(10, oppponentPhone[i]);
                preparedStatement.setString(11, oppponentCarType[i]);
                preparedStatement.setString(12, null);
                preparedStatement.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        System.out.println("정상 종료되었습니다");
        return true;
    }

}
