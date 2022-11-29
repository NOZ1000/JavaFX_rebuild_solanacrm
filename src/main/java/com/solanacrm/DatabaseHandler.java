package com.solanacrm;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void SUUser(String firstName, String lastName, String login, String pass, String isTeacher) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + UserConst.USER_TABLE + " ( " + UserConst.USERS_FIRSTNAME + ", " + UserConst.USERS_LASTNAME + ", " + UserConst.USERS_LOGIN + ", " +
                UserConst.USERS_PASSWORD + ", " + UserConst.IS_TEACHER + " ) " + "VALUES(?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, firstName);
        prSt.setString(2, lastName);
        prSt.setString(3, login);
        prSt.setString(4, pass);
        prSt.setString(5, isTeacher);

        prSt.executeUpdate();
    }

    public ResultSet SIUser(String login, String pass) throws SQLException, ClassNotFoundException {

        ResultSet resSet = null;
        String select = "SELECT * FROM " + UserConst.USER_TABLE + " WHERE " + UserConst.USERS_LOGIN + "=? AND " + UserConst.USERS_PASSWORD + "=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        prSt.setString(1, login);
        prSt.setString(2, pass);

        resSet = prSt.executeQuery();


        return resSet;
    }

    public void CreatePost(String title, String content, String author) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO posts ( title, content, author, date ) VALUES(?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);

        prSt.setString(1, title);
        prSt.setString(2, content);
        prSt.setString(3, author);

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        prSt.setDate(4, date);
        prSt.executeUpdate();
    }


    public int countOfPosts() throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String select = "SELECT * FROM posts";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        resSet = prSt.executeQuery();

        int count=2;
        while(resSet.next()) {
            count++;
        }

        return count;

    }

    public ResultSet getPost(String id) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String select = "SELECT * FROM posts" + " WHERE idposts" + " = " + id;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);


        resSet = prSt.executeQuery();

        return resSet;
    }

    public ResultSet getUser(String id) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String select = "SELECT * FROM users" + " WHERE idusers" + " = " + id;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);


        resSet = prSt.executeQuery();

        return resSet;
    }

    public ResultSet getAllStudents() throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String select = "SELECT * FROM users WHERE is_teacher = false";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);


        resSet = prSt.executeQuery();

        return resSet;
    }
}
