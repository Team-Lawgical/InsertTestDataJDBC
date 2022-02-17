package com.asiana.lawgic;

import java.sql.*;

public class LawyerTestDataInsert {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private String sql = null;
    private String[] lawyerId = {"1", "2", "3"};
    private String[] lawyerPassword = {"1234", "2345", "3456"};
    private String[] lawyerName = {"jaeuk", "youngkyun", "junghyun"};
    private String[] lawyerAddress = {"서울시 서대문구", "서울시 강서구", "서울시 영등포구"};
    private String[] lawyerEmail = {"ohju@asianaidt.com", "yuku@asianaidt.com", "kimjh@asianaidt.com"};
    private String[] lawyerPhone = {"01012345678", "01012345670", "01012345679"};
    private String[] category = {"carToCar", "carToHuman", "carAlone"};
    private int[] valid = {1, 1, 0};

    // String[] categoryId = {"1", "2", "3"};

    public LawyerTestDataInsert() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        // 2. DB 연결
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
        String user = "hr";
        String pw = "hr";

        connection = DriverManager.getConnection(url, user, pw);
        System.out.println("1, 2, connection ok");
    }

    /* 사원 번호를 이용해서 사원의 이름을 확인하세요 */
    public boolean setLawyerInfomation() throws SQLException {
        try {
            for (int i = 0; i < 3; i++) {
                sql = "INSERT INTO lawyer(lawyer_id, lawyer_pw, lawyer_name, " +
                        "lawyer_address, lawyer_email, lawyer_phone, category, valid, category_id) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, lawyerId[i]);
                preparedStatement.setString(2, lawyerPassword[i]);
                preparedStatement.setString(3, lawyerName[i]);
                preparedStatement.setString(4, lawyerAddress[i]);
                preparedStatement.setString(5, lawyerEmail[i]);
                preparedStatement.setString(6, lawyerPhone[i]);
                preparedStatement.setString(7, category[i]);
                preparedStatement.setInt(8, valid[i]);
                preparedStatement.setString(9, null);
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
