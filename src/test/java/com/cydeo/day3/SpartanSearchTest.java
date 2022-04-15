package com.cydeo.day3;

import com.cydeo.utility.DB_Util;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Background : on Spartan UI All Data page ,
 * Search functionality has been acting up
 * It does not always return correct result count
 * You opened the defect , it has been fixed
 * and yet it occasionally comes back again
 * Now you are writing automated test to make sure
 * it works all the times
 *  few scenario you came up with
 *    search by gender should work
 *    search by partial name should work
 *    search by partial name + gender should
 *
 */

public class SpartanSearchTest {


    @Test
    public void testSearchByGender(){

        // Assuming you already used your awesome webdriver knowledge
        // to get actual result from that total count
        // or by counting the web table row and got below result
        //
        int actualResultMale   = 48;
        int actualResultFemale = 47;

        // now get expected result from Database query
        // For Male :  SELECT COUNT(*) AS COUNT FROM SPARTAN WHERE GENDER = 'Male'
        // For Female :SELECT COUNT(*) AS COUNT FROM SPARTAN WHERE GENDER = 'Female'

        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE" ;
        String username = "SP" ;
        String password = "SP" ;

        DB_Util.createConnection(url, username, password);
        DB_Util.runQuery("SELECT COUNT(*) AS COUNT FROM SPARTAN WHERE GENDER = 'Male'");
        int expectedMaleResult =  Integer.parseInt( DB_Util.getFirstRowFirstColumn() )  ;




    }


}
