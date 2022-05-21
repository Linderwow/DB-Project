package com.cydeo.day1;

import com.cydeo.Utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpartanDbPractice {
    DB_Utility db_utility=new DB_Utility();
    public static void main(String[] args) throws SQLException {
        DB_Utility.CreateConn("jdbc:oracle:thin:@54.226.79.215:1521:XE","SP","SP");
        ResultSet resultSet =
                DB_Utility.runQuery("Select * FROM SPARTANS");
        resultSet.next();
        System.out.println("The name is " + resultSet.getString(("Name"))+" whos gender is "
                .concat(resultSet.getString("Gender") +" and his phone number is ")
                .concat(resultSet.getString("Phone")));

        DB_Utility.destroy();

    }
}
