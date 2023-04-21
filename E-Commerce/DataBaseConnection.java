package com.example.ecommerce;
import java.sql.*;

public class DataBaseConnection {

    String dbURl = "jdbc:mysql://localhost:3306/ecommerce";
    String userName = "root";
    String password = "Notavailable@7";

    private Statement getStatement(){
        try{
            Connection conn =  DriverManager.getConnection(dbURl, userName, password);
            return conn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet getQueryTable(String query){
        Statement statement = getStatement();
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertUpdate(String query){
        Statement statement = getStatement();
        try {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM product";
        DataBaseConnection dbConn = new DataBaseConnection();
        ResultSet rs = dbConn.getQueryTable(query);
        if(rs != null){
            System.out.println("Connected To Database");
        }
    }

}
