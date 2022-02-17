package com.asiana.lawgic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryTestDataInsert {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private String sql = null;

    private int[] categoryId = {1, 2, 3};
    private String[] type = {"CAR_TO_CAR", "CAR_TO_HUMAN", "CAR_ALONE"};

    public CategoryTestDataInsert() throws ClassNotFoundException, SQLException {
    	connection=DatabaseConnection.getConnection();
    }

    /* 사원 번호를 이용해서 사원의 이름을 확인하세요 */
    public boolean setCategoryInfomation() throws SQLException {
        try {
            for (int i = 0; i < 3; i++) {
                sql = "INSERT INTO category(category_id, type) VALUES(?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, categoryId[i]);
                preparedStatement.setString(2, type[i]);
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
