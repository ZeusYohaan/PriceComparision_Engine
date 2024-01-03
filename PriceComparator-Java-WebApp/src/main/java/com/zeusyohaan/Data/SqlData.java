package com.zeusyohaan.Data;

import java.sql.*;
import java.util.*;

public class SqlData {
    private final String GET_VEG_DATA = "SELECT * FROM  ?";
    private final String GET_LOGIN_DATA = "SELECT * FROM login";

    private final String GET_VEG_QUERY = "SELECT * FROM ? WHERE dataid = ?";

    public List<vegData> getVegDataDB(String tableName) {
        List<vegData> vegDataList = new ArrayList<>();
        String sqlStmnt = "SELECT * FROM " + tableName;

        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/price_comparator",
                        "root", "2004"
                );
                PreparedStatement getVegDataStatement = connection.prepareStatement(sqlStmnt);
        ) {
            ResultSet getVegDataResult = getVegDataStatement.executeQuery();

            while (getVegDataResult.next()) {
                String dataID = getVegDataResult.getString("dataid");
                String title = getVegDataResult.getString("title");
                String price = getVegDataResult.getString("price");
                String date = getVegDataResult.getString("date");

                vegData vegData = new vegData();
                vegData.setDataId(dataID);
                vegData.setDate(date);
                vegData.setTitle(title);
                vegData.setPrice(price);

                vegDataList.add(vegData);
            }

            getVegDataResult.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vegDataList;
    }

    public List<vegData> getVegDataQueryDB(String tableName, String DataID){
        List<vegData> vegDataList = new ArrayList<>();
        String sqlStmnt = "SELECT * FROM " + tableName + " WHERE dataid = ?";
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/price_comparator",
                        "root", "2004"
                );

                PreparedStatement getVegDataStatement = connection.prepareStatement(sqlStmnt);

        ) {
            getVegDataStatement.setString(1, DataID);
            ResultSet getVegDataResult = getVegDataStatement.executeQuery();
            while (getVegDataResult.next()){
                String dataID = getVegDataResult.getString("dataid");
                String title = getVegDataResult.getString("title");
                String price  = getVegDataResult.getString("price");
                String date = getVegDataResult.getString("date");
                vegData vegData = new vegData();
                vegData.setDataId(dataID);
                vegData.setDate(date);
                vegData.setTitle(title);
                vegData.setPrice(price);
                vegDataList.add(vegData);
            }
            getVegDataResult.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  vegDataList;
    }

    public List<loginData> getLoginDataDB() {
        List<loginData> loginDataList = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/price_comparator",
                        "root", "2004"
                );
                PreparedStatement getLoginDataStatement = connection.prepareStatement(GET_LOGIN_DATA); // Use a constant for login data query
        ) {
            ResultSet getLoginDataResult = getLoginDataStatement.executeQuery();
            while (getLoginDataResult.next()) {
                String username = getLoginDataResult.getString("username");
                String password = getLoginDataResult.getString("pwd");
                loginData loginData = new loginData();
                loginData.setUserName(username);
                loginData.setPassword(password);
                loginDataList.add(loginData);
            }
            getLoginDataResult.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginDataList;
    }


}
