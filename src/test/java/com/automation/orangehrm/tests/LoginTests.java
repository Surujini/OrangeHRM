package com.automation.orangehrm.tests;

import com.automation.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LoginTests extends BaseTest{

    LoginPage loginPage;

    @Test
    public void loginTest(){
        loginPage = new LoginPage(driver);

        Assert.assertEquals(loginPage.loginPageGetText(), "Login", "User is not on the login Page");

        loginPage.usernameInput("Admin");
        loginPage.passwordInput("admin123");
        loginPage.clickSubmitButton();

        Assert.assertEquals(loginPage.dashboardGetText(), "Dashboard", "Login was not successful");

    }


    @Test
    public void loginWrongUsernameTest(){
        loginPage = new LoginPage(driver);

        Assert.assertEquals(loginPage.loginPageGetText(), "Login", "User is not on the login Page");

        loginPage.usernameInput("negus");
        loginPage.passwordInput("admin123");
        loginPage.clickSubmitButton();

        Assert.assertEquals(loginPage.errorMessage(), "Invalid credentials", "Did not receive correct error message");

    }

    @Test
    public void loginWrongPasswordTest(){
        loginPage = new LoginPage(driver);

        Assert.assertEquals(loginPage.loginPageGetText(), "Login", "User is not on the login Page");

        loginPage.usernameInput("Admin");
        loginPage.passwordInput("admin123435223452345234523452345");
        loginPage.clickSubmitButton();

        Assert.assertEquals(loginPage.errorMessage(), "Invalid credentials", "Did not receive correct error message");

    }

    @Test
    public void loginWrongUsernameAndPasswordTest(){
        loginPage = new LoginPage(driver);

        Assert.assertEquals(loginPage.loginPageGetText(), "Login", "User is not on the login Page");

        loginPage.usernameInput("Adminasdffasdfasdfasf");
        loginPage.passwordInput("admin123435223452345234523452345");
        loginPage.clickSubmitButton();

        Assert.assertEquals(loginPage.errorMessage(), "Invalid credentials", "Did not receive correct error message");

    }


    @Test
    public void testing(){

        Map<String, List<String>> dataMap = new HashMap<>();

        List<String> dataList = new LinkedList<>();

        dataList.add("Admin");
        dataList.add("ESS");

        dataMap.put("Row 1" , dataList);

        List<String> results = dataMap.get("Row 1");

        Assert.assertEquals(results.get(0), "Admin", "Did not work");
        Assert.assertEquals(results.get(1), "ESS", "Did not work");



    }


}
