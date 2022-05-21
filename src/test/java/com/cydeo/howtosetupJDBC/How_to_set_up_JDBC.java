package com.cydeo.howtosetupJDBC;



import java.sql.*;
import java.util.Iterator;

public class How_to_set_up_JDBC  {
    public static void main (String[] args) throws SQLException{


        String url = "jdbc:oracle:thin:@44.202.192.153:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(url , username , password);
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String url2 = "jdbc:oracle:thin:@44.202.192.153:1521:XE" ;
        String username2 = "SP" ;
        String password2 = "SP" ;

        Connection conn2 = DriverManager.getConnection(url2,username2,password2) ;
        Statement stmt = conn2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * From SP.SPARTANS");
        resultSet.next();
        System.out.println("resultSet.getString(1) = " + resultSet.getString(4));
        resultSet.next();
        System.out.println("resultSet.getString(2) = " + resultSet.getString("PHONE"));
        resultSet.next();
        System.out.println(resultSet.getString(4));
//        resultSet=statement.executeQuery("Select COUNTRY_NAME from countries");
//        System.out.println("countries are ");
//        while (resultSet.next()){
//            System.out.println( resultSet.getString(1));
//        }
//        System.out.println("\n"+ "names are ");
//        resultSet=statement.executeQuery("select NAME from SP.SPARTANS");
//        while (resultSet.next()){
//            System.out.println(resultSet.getString(1));
//        }
//        resultSet=statement.executeQuery("select DEPARTMENT_NAME from DEPARTMENTS");
//        resultSet.next();
//        System.out.println(resultSet.getString(1));
//        resultSet=statement.executeQuery("select STREET_ADDRESS from LOCATIONS");
//        resultSet.last();

        System.out.println(resultSet.getString(1));
        resultSet=statement.executeQuery("select GENDER FROM SP.SPARTANS");
        resultSet.absolute(10);
        System.out.println(resultSet.getString(1));

        resultSet=statement.executeQuery("select JOB_TITLE from JOBS");
        resultSet.absolute(5);
        System.out.println(resultSet.getString(1));
        resultSet=statement.executeQuery("select CREATED_AT from SP.SPARTANS");
        resultSet.next();
        System.out.println(resultSet.getDate(1));
        resultSet=statement.executeQuery("select MANAGER_ID from DEPARTMENTS");
        resultSet.absolute(5);
        System.out.println(resultSet.getInt(1));
        resultSet=statement.executeQuery("select max(SALARY) from EMPLOYEES");
        resultSet.next();
        System.out.println(resultSet.getDouble(1));

        resultSet=statement.executeQuery("select * from SP.SPARTANS");
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        System.out.println(resultSetMetaData.getColumnCount());
        resultSet=statement.executeQuery("select * from JOB_HISTORY");
        ResultSetMetaData resultSetMetaData1=resultSet.getMetaData();
        int colCount = resultSetMetaData1.getColumnCount();
        for (int i = 1; i <= colCount; i++) {
            System.out.println(resultSetMetaData1.getColumnName(i));
        }
    }
}
