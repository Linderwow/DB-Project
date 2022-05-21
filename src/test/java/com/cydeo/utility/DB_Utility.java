package com.cydeo.Utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DB_Utility {
    static Statement statement;
    static ResultSet resultSet;
    static Connection connection;

    public static Connection CreateConn(String url, String username, String password) {

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");

        } catch (SQLException exception) {
            System.err.println("Connection has failed");
        }
        return connection;
    }

    public static ResultSet runQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);

        } catch (SQLException exception) {
            System.err.println("An error occured while getting result set " + exception.getMessage());
        }
        return resultSet;
    }

    /*cleaning up the resources

     */
    public static void destroy() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static int getRowCount() {
        int rowCount = 0;
        try {
            resultSet.last();
            rowCount = resultSet.getRow();

        } catch (SQLException e) {
            System.err.println("Error while getting row count " + e.getMessage());
        }
        return rowCount;
    }

    public static int getColumnCNT() throws SQLException {
        int colCount = 0;
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            colCount = resultSetMetaData.getColumnCount();

        } catch (SQLException exception) {
            System.err.println("Error while counting the columns" + exception.getMessage());
        }
        return colCount;
    }

    public static List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();
        try {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                String colName = rsmd.getColumnLabel(i);
                columnNames.add(colName);

            }
        } catch (SQLException exception) {
            System.err.println("Error while getting column names " + exception.getMessage());
        }
        return columnNames;
    }

    public static List<String> getRowDataAsList(int rowNum) {
        List<String> rowDataList = new ArrayList<>();
        try {
            resultSet.absolute(rowNum);
            for (int i = 1; i < getColumnCNT(); i++) {


                String cellValue = resultSet.getString(i);
                rowDataList.add(cellValue);

            }
        } catch (SQLException exception) {
            System.out.println("Error while extracting row data");
        }
        return rowDataList;
    }

    public static String getColumnDataAtRow(int Rownum, String columnName) {

        String result = "";
        try {
            resultSet.absolute(Rownum);
            result = resultSet.getString(columnName);

        } catch (SQLException exception) {
            System.out.println("Error while reading rows and columns");
        }
        return result;
    }

    public static List<String> getColumnDataIsList(int columnIndex) {
        List<String> columnDataLst = new ArrayList<>();
        try {

            while (resultSet.next()) {
                String cellValue = resultSet.getString(columnIndex);
                columnDataLst.add(cellValue);
            } }catch(
                SQLException exception){
        System.out.println("ERROR WHILE getColumnDataAsList " + exception.getMessage());
        }
        return columnDataLst;
    }
    public static void displayAllData(){
        try {
            resultSet.beforeFirst();
            while(resultSet.next()){
                for (int i = 1; i < getColumnCNT(); i++) {
                    System.out.print(resultSet.getString(i)+"\t");
                }
                System.out.println();
            }
        }catch (SQLException exception){
            System.out.println("Error");
        }
        }

    public static Map<String,String>getRowMap(int rowNum) {
        Map<String, String> rowMap = new LinkedHashMap<>();
        try {
            resultSet.absolute(rowNum);
            ResultSetMetaData rslt = resultSet.getMetaData();
            for (int i = 1; i <= getColumnCNT(); i++) {
                String colName = rslt.getColumnName(i) + " ";
                String cellValue = resultSet.getString(i);
                rowMap.put(colName, " " + cellValue);
            }

        } catch (SQLException exception) {
            System.out.println("Errow getting rowMap"+ exception.getMessage());
        }
    return rowMap;
    }
    public static void main(String[] args)throws SQLException {
        CreateConn("jdbc:oracle:thin:@54.225.25.248:1521:XE","hr","hr");
        ResultSet result = runQuery("Select * FROM CUSTOMERS");
        result.next();
        System.out.println(result.getString(2)+" is in ".concat(result.getString(4)));
        System.out.println(getRowCount() + " Rows in this table");
        System.out.println(getColumnCNT()+" Columns in this table");
        System.out.println(getColumnNames()+ " are the column names");
        System.out.println(getRowDataAsList(1)+" is a content of this row");
        System.out.println("STREET ADDRESS IS " + getColumnDataAtRow(2,"ADDRESS"));
        System.out.println(getColumnDataIsList(2));
        System.out.println(getRowMap(4));
        //displayAllData();
    }

}

