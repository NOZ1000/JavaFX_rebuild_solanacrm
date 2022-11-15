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


}
