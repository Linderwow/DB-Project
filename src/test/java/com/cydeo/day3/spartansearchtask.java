package com.cydeo.day3;


import com.cydeo.Utility.DB_Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class spartansearchtask {
    @Test
    public void    SpartanSearchTask(){
        int actualMaleResult = 48;
        int actualResultFemale = 47;

        DB_Util.createConnection("jdbc:oracle:thin:@44.202.192.153:1521:XE","SP","SP");
        DB_Util.runQuery("Select COUNT(*)AS COUNT FROM SPARTANS WHERE GENDER = 'Male'");
        int expectedMaleResult =Integer.parseInt(DB_Util.getFirstRowFirstColumn());
        Assert.assertEquals(actualMaleResult,expectedMaleResult);
        System.out.println("expectedMaleResult = " + expectedMaleResult);
        DB_Util.runQuery("Select COUNT(*)AS COUNT FROM SPARTANS WHERE GENDER = 'Female'");
        int expectedFemaleresult = Integer.parseInt(DB_Util.getFirstRowFirstColumn());
        Assert.assertEquals(expectedFemaleresult,actualResultFemale);
        System.out.println("expectedFemaleresult = " + expectedFemaleresult);
    }
}
